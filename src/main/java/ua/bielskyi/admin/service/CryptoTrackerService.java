package ua.bielskyi.admin.service;

import ua.bielskyi.admin.model.Crypto;
import ua.bielskyi.admin.model.CryptoReport;
import ua.bielskyi.admin.model.ExchangeRatesReport;
import ua.bielskyi.admin.model.TimeSeriesPeriod;

import java.util.Date;

public interface CryptoTrackerService {

    ExchangeRatesReport getExchangeRatesReport();

    ExchangeRatesReport getExchangeRatesForPeriodReport(Date date);

    CryptoReport getCryptoReport(Crypto base, Crypto quote, TimeSeriesPeriod period);
}
