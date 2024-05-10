package ua.bielskyi.admin.model;

import io.jmix.core.metamodel.datatype.EnumClass;

public enum Currency implements EnumClass<Integer> {
    USD(840, "United States Dollar"),
    EUR(978, "Euro"),
    CNY(156, "Chinese Yuan Renminbi"),
    JPY(392, "Japanese Yen"),
    GBP(826, "British Pound Sterling"),
    INR(356, "Indian Rupee"),
    AUD(36, "Australian Dollar"),
    CAD(124, "Canadian Dollar"),
    RUB(643, "Russian Ruble"),
    CHF(756, "Swiss Franc"),
    KRW(410, "South Korean Won"),
    BRL(986, "Brazilian Real"),
    MXN(484, "Mexican Peso"),
    SGD(702, "Singapore Dollar"),
    SEK(752, "Swedish Krona"),
    TRY(949, "Turkish Lira"),
    HKD(344, "Hong Kong Dollar"),
    NOK(578, "Norwegian Krone"),
    ZAR(710, "South African Rand"),
    SAR(682, "Saudi Riyal"),
    AED(784, "UAE Dirham"),
    DKK(208, "Danish Krone"),
    MYR(458, "Malaysian Ringgit"),
    NZD(554, "New Zealand Dollar"),
    QAR(634, "Qatari Rial"),
    THB(764, "Thai Baht"),
    CLP(152, "Chilean Peso"),
    IDR(360, "Indonesian Rupiah"),
    TWD(901, "New Taiwan Dollar"),
    PHP(608, "Philippine Peso"),
    COP(170, "Colombian Peso"),
    ILS(376, "Israeli Shekel"),
    PLN(985, "Polish Zloty"),
    EGP(818, "Egyptian Pound"),
    RON(946, "Romanian Leu"),
    HUF(348, "Hungarian Forint"),
    CZK(203, "Czech Koruna"),
    PKR(586, "Pakistani Rupee"),
    KES(404, "Kenyan Shilling"),
    DZD(12, "Algerian Dinar"),
    VND(704, "Vietnamese Dong"),
    NGN(566, "Nigerian Naira"),
    BDT(50, "Bangladeshi Taka"),
    IQD(368, "Iraqi Dinar"),
    XAF(950, "Central African CFA Franc BEAC"),
    KWD(414, "Kuwaiti Dinar"),
    MAD(504, "Moroccan Dirham"),
    UAH(980, "Ukrainian Hryvnia"),
    RSD(941, "Serbian Dinar"),
    CRC(188, "Costa Rican Colon"),
    CUP(192, "Cuban Peso"),
    IRR(364, "Iranian Rial"),
    ISK(352, "Icelandic Krona"),
    LKR(144, "Sri Lankan Rupee"),
    NPR(524, "Nepalese Rupee"),
    HRK(191, "Croatian Kuna"),
    SZL(748, "Swazi Lilangeni"),
    ETB(230, "Ethiopian Birr"),
    LBP(422, "Lebanese Pound"),
    MKD(807, "Macedonian Denar"),
    BHD(48, "Bahraini Dinar"),
    LYD(434, "Libyan Dinar"),
    JOD(400, "Jordanian Dinar"),
    UYU(858, "Uruguayan Peso"),
    UZS(860, "Uzbekistan Som"),
    GHS(936, "Ghanaian Cedi"),
    BWP(72, "Botswana Pula"),
    MNT(496, "Mongolian Tugrik");

    private final int numericCode;
    private final String currencyName;

    Currency(int numericCode, String currencyName) {
        this.numericCode = numericCode;
        this.currencyName = currencyName;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }


    @Override
    public Integer getId() {
        return numericCode;
    }
}
