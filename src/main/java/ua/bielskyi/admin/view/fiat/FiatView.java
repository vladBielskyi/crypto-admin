package ua.bielskyi.admin.view.fiat;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.chartsflowui.component.Chart;
import io.jmix.chartsflowui.data.ContainerChartItems;
import io.jmix.chartsflowui.data.item.EntityDataItem;
import io.jmix.chartsflowui.kit.component.model.DataSet;
import io.jmix.chartsflowui.kit.component.model.Title;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ua.bielskyi.admin.model.Currency;
import ua.bielskyi.admin.model.ExchangeRatesReport;
import ua.bielskyi.admin.model.FiatGrowth;
import ua.bielskyi.admin.model.SourceItem;
import ua.bielskyi.admin.service.CryptoTrackerService;
import ua.bielskyi.admin.view.main.MainView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Route(value = "fiat-view", layout = MainView.class)
@ViewController("FiatView")
@ViewDescriptor("fiat-view.xml")
public class FiatView extends StandardView {

    @ViewComponent
    private CollectionContainer<FiatGrowth> fiatGrowthDc;

    @ViewComponent
    private Chart chart;

    @ViewComponent
    private JmixSelect<Currency> currency;

    @ViewComponent
    private TypedDatePicker<Comparable> from;

    @ViewComponent
    private TypedDatePicker<Comparable> to;

    @Autowired
    private CryptoTrackerService cryptoTrackerService;

    @Subscribe
    public void onInit(final InitEvent event) {
        List<ExchangeRatesReport> reports = new ArrayList<>(10);
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        Date tenDaysAgo = calendar.getTime();
        calendar.setTime(tenDaysAgo);

        currency.setValue(Currency.USD);
        from.setValue(tenDaysAgo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        to.setValue(currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        while (calendar.getTime().compareTo(currentDate) <= 0) {
            reports.add(cryptoTrackerService.getExchangeRatesForPeriodReport(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        List<FiatGrowth> fiatGrowths = buildFiatGrowthList(reports);
        Title title = new Title();
        title.setText(currency.getValue().getCurrencyName() + " "
                + new SimpleDateFormat("dd.MM.yyyy").format(tenDaysAgo) + " - "
                + new SimpleDateFormat("dd.MM.yyyy").format(currentDate));
        chart.withTitle(title);
        fiatGrowthDc.setItems(fiatGrowths);
    }

    @Subscribe(id = "apply", subject = "clickListener")
    public void onApplyClick(final ClickEvent<JmixButton> event) {
        LocalDate fromDate = from.getValue();
        LocalDate toDate = to.getValue();
        if (isNull(toDate) || isNull(fromDate) || isNull(currency.getValue())) {
            throw new RuntimeException("Field`s [ currency, from, to ] can`t be null");
        }
        if (fromDate.isAfter(toDate)) {
            throw new RuntimeException("FROM can`t be after TO");
        }
        if (toDate.isBefore(fromDate)) {
            throw new RuntimeException("TO can`t be later FROM");
        }
        long daysDifference = ChronoUnit.DAYS.between(fromDate, toDate);
        if (daysDifference > 20) {
            throw new RuntimeException("The difference between date can`t be more 20 days");
        }

        List<ExchangeRatesReport> reports = new ArrayList<>();
        Date convertedFromDate = Date.from(fromDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date convertedToDate = Date.from(toDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertedFromDate);

        while (calendar.getTime().compareTo(convertedToDate) <= 0) {
            reports.add(cryptoTrackerService.getExchangeRatesForPeriodReport(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        List<FiatGrowth> fiatGrowths = buildFiatGrowthList(reports);
        Title title = new Title();
        title.setText(currency.getValue().getCurrencyName() + " "
                + new SimpleDateFormat("dd.MM.yyyy").format(convertedFromDate) + " - "
                + new SimpleDateFormat("dd.MM.yyyy").format(convertedToDate));
        chart.withTitle(title);
        fiatGrowthDc.setItems(fiatGrowths);
        chart.setDataSet(new DataSet().withSource(new DataSet.Source<EntityDataItem>()
                .withDataProvider(new ContainerChartItems<>(fiatGrowthDc))
                .withCategoryField("date")
                .withValueFields("monoValue", "privatValue", "openDataValue")
        ));
    }

    private List<FiatGrowth> buildFiatGrowthList(List<ExchangeRatesReport> reports) {
        List<FiatGrowth> fiatGrowths = new ArrayList<>();
        for (ExchangeRatesReport report : reports) {
            report.getRatesMap().forEach((x, y) -> {
                FiatGrowth fiatGrowth = new FiatGrowth();
                if (Integer.valueOf(x).equals(currency.getValue().getNumericCode())) {
                    fiatGrowth.setDate(report.getDate().format(DateTimeFormatter.ISO_DATE));
                    for (SourceItem source : y.getSources()) {
                        switch (source.getSourceName()) {
                            case MONOBANK:
                                fiatGrowth.setMonoValue(source.getRate().doubleValue());
                                break;
                            case PRIVATBANK:
                                fiatGrowth.setPrivatValue(source.getRate().doubleValue());
                                break;
                            case OPEN_DATA:
                                fiatGrowth.setOpenDataValue(source.getRate().doubleValue());
                                break;
                        }
                    }
                    fiatGrowths.add(fiatGrowth);
                }
            });
        }
        return fiatGrowths;
    }
}