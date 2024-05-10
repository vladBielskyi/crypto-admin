package ua.bielskyi.admin.view.crypto;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.chartsflowui.component.Chart;
import io.jmix.chartsflowui.data.item.SimpleDataItem;
import io.jmix.chartsflowui.kit.component.model.DataSet;
import io.jmix.chartsflowui.kit.data.chart.ListChartItems;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ua.bielskyi.admin.model.Crypto;
import ua.bielskyi.admin.model.CryptoData;
import ua.bielskyi.admin.model.CryptoReport;
import ua.bielskyi.admin.model.CryptoReportItem;
import ua.bielskyi.admin.model.TimeSeriesPeriod;
import ua.bielskyi.admin.service.CryptoTrackerService;
import ua.bielskyi.admin.view.main.MainView;

@Route(value = "crypto-view", layout = MainView.class)
@ViewController("CryptoView")
@ViewDescriptor("crypto-view.xml")
public class CryptoView extends StandardView {

    @ViewComponent
    private Chart chart;

    @ViewComponent
    private JmixSelect<Crypto> base;

    @ViewComponent
    private JmixSelect<Crypto> quote;

    @ViewComponent
    private JmixSelect<TimeSeriesPeriod> period;

    @Autowired
    private CryptoTrackerService cryptoTrackerService;

    @Subscribe
    public void onInit(final InitEvent event) {
        base.setValue(Crypto.BTC);
        quote.setValue(Crypto.ETH);
        period.setValue(TimeSeriesPeriod.HOUR_3);
        updateChart();
    }

    @Subscribe(id = "apply", subject = "clickListener")
    public void onApplyClick(final ClickEvent<JmixButton> event) {
        updateChart();
    }

    private void updateChart() {
        CryptoReport report = cryptoTrackerService.getCryptoReport(base.getValue(), quote.getValue(), period.getValue());
        ListChartItems<SimpleDataItem> items = new ListChartItems<>();
        for (CryptoReportItem crypto : report.getCryptos()) {
            CryptoData data = new CryptoData();
            data.setDate(crypto.getTimeOpen().toLocalDate());
            data.setHigh(crypto.getRateHigh());
            data.setOpen(crypto.getRateOpen());
            data.setLow(crypto.getRateLow());
            data.setClose(crypto.getRateClose());
            items.addItem(new SimpleDataItem(data));
        }

        chart.setDataSet(
                new DataSet().withSource(
                        new DataSet.Source<SimpleDataItem>()
                                .withDataProvider(items)
                                .withCategoryField("date")
                                .withValueFields("open", "close", "low", "high")
                )
        );
    }

}
