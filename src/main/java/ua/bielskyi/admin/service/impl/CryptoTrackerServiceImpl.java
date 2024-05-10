package ua.bielskyi.admin.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.bielskyi.admin.model.Crypto;
import ua.bielskyi.admin.model.CryptoReport;
import ua.bielskyi.admin.model.ExchangeRatesReport;
import ua.bielskyi.admin.model.TimeSeriesPeriod;
import ua.bielskyi.admin.service.CryptoTrackerService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CryptoTrackerServiceImpl implements CryptoTrackerService {

    private static final String ACTUAL_PATH = "/api/currencies/actual";
    private static final String PERIOD_PATH = "/api/currencies/period";
    private static final String CRYPTO_PATH = "/api/currencies/crypto";

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${ua.bielskyi.crypto.tracker.url}")
    private String baseUrl;

    @Override
    public ExchangeRatesReport getExchangeRatesReport() {
        Request request = new Request.Builder()
                .url(baseUrl + ACTUAL_PATH)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException(String.format("Error while fetching currencies [%s]", response.message()));
            } else {
                return objectMapper.readValue(response.body().string(), ExchangeRatesReport.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ExchangeRatesReport getExchangeRatesForPeriodReport(Date date) {
        Request request = new Request.Builder()
                .url(baseUrl + PERIOD_PATH + "?date=" + new SimpleDateFormat("dd.MM.yyyy").format(date))
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException(String.format("Error while fetching currencies [%s]", response.message()));
            } else {
                return objectMapper.readValue(response.body().string(), ExchangeRatesReport.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CryptoReport getCryptoReport(Crypto base, Crypto quote, TimeSeriesPeriod period) {
        Request request = new Request.Builder()
                .url(baseUrl + CRYPTO_PATH
                        + "?base=" + base.name()
                        + "&quote=" + quote.name()
                        + "&period=" + period.name())
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException(String.format("Error while fetching cryptos [%s]", response.message()));
            } else {
                return objectMapper.readValue(response.body().string(), CryptoReport.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
