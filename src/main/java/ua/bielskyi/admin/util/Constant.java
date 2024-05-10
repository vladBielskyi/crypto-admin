package ua.bielskyi.admin.util;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class Constant {

    public static final Map<Integer, String> CURRENCY_MAP;

    static {
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(36, "AUD"); // Australian Dollar
        tempMap.put(944, "AZN"); // Azerbaijani Manat
        tempMap.put(977, "BAM"); // Bosnia and Herzegovina Convertible Mark
        tempMap.put(52, "BBD"); // Barbadian Dollar
        tempMap.put(975, "BGN"); // Bulgarian Lev
        tempMap.put(48, "BMD"); // Bermudian Dollar
        tempMap.put(96, "BND"); // Brunei Dollar
        tempMap.put(44, "BSD"); // Bahamian Dollar
        tempMap.put(840, "USD"); // United States Dollar
        tempMap.put(978, "EUR"); // Euro
        tempMap.put(826, "GBP"); // British Pound Sterling
        tempMap.put(392, "JPY"); // Japanese Yen
        tempMap.put(578, "NOK"); // Norwegian Krone
        tempMap.put(710, "ZAR"); // South African Rand
        tempMap.put(156, "CNY"); // Chinese Yuan Renminbi
        tempMap.put(124, "CAD"); // Canadian Dollar
        tempMap.put(352, "ISK"); // Icelandic Krona
        tempMap.put(376, "ILS"); // Israeli Shekel
        tempMap.put(356, "INR"); // Indian Rupee
        tempMap.put(214, "DOP"); // Dominican Peso
        tempMap.put(971, "AFN"); // Afghan Afghani
        tempMap.put(8, "ALL"); // Albanian Lek
        tempMap.put(32, "ARS"); // Argentine Peso
        tempMap.put(51, "AMD"); // Armenian Dram
        tempMap.put(36, "AWG"); // Aruban Florin
        tempMap.put(48, "BHD"); // Bahraini Dinar
        tempMap.put(50, "BDT"); // Bangladeshi Taka
        tempMap.put(132, "CVE"); // Cape Verdean Escudo
        tempMap.put(116, "KHR"); // Cambodian Riel
        tempMap.put(950, "XAF"); // Central African CFA Franc BEAC
        tempMap.put(152, "CLP"); // Chilean Peso
        tempMap.put(170, "COP"); // Colombian Peso
        tempMap.put(188, "CRC"); // Costa Rican Colon
        tempMap.put(174, "KMF"); // Comorian Franc
        tempMap.put(132, "CDF"); // Congolese Franc
        tempMap.put(191, "HRK"); // Croatian Kuna
        tempMap.put(203, "CZK"); // Czech Koruna
        tempMap.put(208, "DKK"); // Danish Krone
        tempMap.put(262, "DJF"); // Djiboutian Franc
        tempMap.put(818, "EGP"); // Egyptian Pound
        tempMap.put(232, "ERN"); // Eritrean Nakfa
        tempMap.put(230, "ETB"); // Ethiopian Birr
        tempMap.put(238, "FKP"); // Falkland Islands Pound
        tempMap.put(952, "FJD"); // Fijian Dollar
        tempMap.put(953, "XPF"); // CFP Franc
        tempMap.put(981, "GEL"); // Georgian Lari
        tempMap.put(936, "GHS"); // Ghanaian Cedi
        tempMap.put(292, "GIP"); // Gibraltar Pound
        tempMap.put(320, "GTQ"); // Guatemalan Quetzal
        tempMap.put(328, "GYD"); // Guyanese Dollar
        tempMap.put(340, "HTG"); // Haitian Gourde
        tempMap.put(344, "HKD"); // Hong Kong Dollar
        tempMap.put(410, "KRW"); // South Korean Won
        tempMap.put(360, "IDR"); // Indonesian Rupiah
        tempMap.put(364, "IRR"); // Iranian Rial
        tempMap.put(368, "IQD"); // Iraqi Dinar
        tempMap.put(388, "JMD"); // Jamaican Dollar
        tempMap.put(398, "KZT"); // Kazakhstani Tenge
        tempMap.put(404, "KES"); // Kenyan Shilling
        tempMap.put(417, "KGS"); // Kyrgyzstani Som
        tempMap.put(418, "KHR"); // Cambodian Riel
        tempMap.put(422, "JOD"); // Jordanian Dinar
        tempMap.put(426, "KMF"); // Comorian Franc
        tempMap.put(430, "KPW"); // North Korean Won
        tempMap.put(434, "KWD"); // Kuwaiti Dinar
        tempMap.put(446, "MWK"); // Malawian Kwacha
        tempMap.put(458, "MYR"); // Malaysian Ringgit
        tempMap.put(462, "MVR"); // Maldivian Rufiyaa
        tempMap.put(478, "MNT"); // Mongolian Tugrik
        tempMap.put(480, "MZN"); // Mozambican Metical
        tempMap.put(484, "MAD"); // Moroccan Dirham
        tempMap.put(498, "MDL"); // Moldovan Leu
        tempMap.put(504, "MAD"); // Moroccan Dirham
        tempMap.put(512, "OMR"); // Omani Rial
        tempMap.put(516, "NAD"); // Namibian Dollar
        tempMap.put(524, "NPR"); // Nepalese Rupee
        tempMap.put(532, "ANG"); // Netherlands Antillean Guilder
        tempMap.put(533, "AWG"); // Aruban Florin
        tempMap.put(548, "VUV"); // Vanuatu Vatu
        tempMap.put(554, "NZD"); // New Zealand Dollar
        tempMap.put(558, "NIO"); // Nicaraguan Cordoba
        tempMap.put(566, "NGN"); // Nigerian Naira
        tempMap.put(578, "NOK"); // Norwegian Krone
        tempMap.put(586, "PKR"); // Pakistani Rupee
        tempMap.put(590, "PAB"); // Panamanian Balboa
        tempMap.put(598, "PGK"); // Papua New Guinean Kina
        tempMap.put(600, "PYG"); // Paraguayan Guarani
        tempMap.put(604, "PEN"); // Peruvian Nuevo Sol
        tempMap.put(608, "PHP"); // Philippine Peso
        tempMap.put(634, "QAR"); // Qatari Rial
        tempMap.put(643, "RUB"); // Russian Ruble
        tempMap.put(646, "RWF"); // Rwandan Franc
        tempMap.put(654, "SHP"); // Saint Helena Pound
        tempMap.put(682, "SAR"); // Saudi Riyal
        tempMap.put(690, "SCR"); // Seychellois Rupee
        tempMap.put(694, "SLL"); // Sierra Leonean Leone
        tempMap.put(702, "SGD"); // Singapore Dollar
        tempMap.put(704, "VND"); // Vietnamese Dong
        tempMap.put(706, "SOS"); // Somali Shilling
        tempMap.put(710, "ZAR"); // South African Rand
        tempMap.put(748, "SZL"); // Swazi Lilangeni
        tempMap.put(752, "SEK"); // Swedish Krona
        tempMap.put(756, "CHF"); // Swiss Franc
        tempMap.put(760, "SYP"); // Syrian Pound
        tempMap.put(764, "THB"); // Thai Baht
        tempMap.put(780, "TTD"); // Trinidad and Tobago Dollar
        tempMap.put(784, "AED"); // UAE Dirham
        tempMap.put(788, "TND"); // Tunisian Dinar
        tempMap.put(795, "TMT"); // Turkmenistani Manat
        tempMap.put(800, "UGX"); // Ugandan Shilling
        tempMap.put(807, "MKD"); // Macedonian Denar
        tempMap.put(818, "EGP"); // Egyptian Pound
        tempMap.put(826, "GBP"); // British Pound Sterling
        tempMap.put(834, "TZS"); // Tanzanian Shilling
        tempMap.put(840, "USD"); // United States Dollar
        tempMap.put(858, "UYU"); // Uruguayan Peso
        tempMap.put(860, "UZS"); // Uzbekistan Som
        tempMap.put(882, "WST"); // Samoan Tala
        tempMap.put(886, "YER"); // Yemeni Rial
        tempMap.put(901, "TWD"); // New Taiwan Dollar
        tempMap.put(920, "UYU"); // Uruguayan Peso
        tempMap.put(931, "CDF"); // Congolese Franc
        tempMap.put(932, "ZMK"); // Zambian Kwacha
        tempMap.put(933, "ZMW"); // Zambian Kwacha
        tempMap.put(934, "TMT"); // Turkmenistani Manat
        tempMap.put(936, "GHS"); // Ghanaian Cedi
        tempMap.put(937, "STD"); // Sao Tome and Principe Dobra
        tempMap.put(938, "SDG"); // Sudanese Pound
        tempMap.put(940, "UYI"); // Uruguay Peso en Unidades Indexadas
        tempMap.put(941, "RSD"); // Serbian Dinar
        tempMap.put(943, "MZN"); // Mozambican Metical
        tempMap.put(944, "AZN"); // Azerbaijani Manat
        tempMap.put(946, "RON"); // Romanian Leu
        tempMap.put(947, "CHE"); // WIR Euro
        tempMap.put(948, "CHW"); // WIR Franc
        tempMap.put(949, "TRY"); // Turkish Lira
        tempMap.put(950, "XAF"); // Central African CFA Franc BEAC
        tempMap.put(951, "XCD"); // East Caribbean Dollar
        tempMap.put(952, "XOF"); // West African CFA Franc
        tempMap.put(953, "XPF"); // CFP Franc
        tempMap.put(960, "XDR"); // Special Drawing Rights
        tempMap.put(961, "XAG"); // Silver Ounce
        tempMap.put(962, "XAU"); // Gold Ounce
        tempMap.put(963, "XPD"); // Palladium Ounce
        tempMap.put(964, "XPT"); // Platinum Ounce
        tempMap.put(965, "XSU"); // SDR (Special Drawing Right)
        tempMap.put(967, "ZMW"); // Zambian Kwacha
        tempMap.put(968, "BYN"); // Belarusian Ruble
        tempMap.put(969, "BND"); // Brunei Dollar
        tempMap.put(970, "MXV"); // Mexican Unidad de Inversion (UDI)
        tempMap.put(971, "BOV"); // Bolivian Mvdol
        tempMap.put(972, "CLF"); // Chilean Unidad de Fomento
        tempMap.put(973, "COU"); // Colombian Unidad de Valor Real
        tempMap.put(974, "NGN"); // Nigerian Naira
        tempMap.put(975, "BAM"); // Bosnia and Herzegovina Convertible Mark
        tempMap.put(976, "BGN"); // Bulgarian Lev
        tempMap.put(977, "BAM"); // Bosnia and Herzegovina Convertible Mark
        tempMap.put(978, "EUR"); // Euro
        tempMap.put(979, "EURO"); // Euro
        tempMap.put(980, "UAH"); // Ukrainian Hryvnia
        tempMap.put(981, "GEL"); // Georgian Lari
        tempMap.put(982, "USN"); // US Dollar (Next day)
        tempMap.put(983, "USS"); // US Dollar (Same day)
        tempMap.put(984, "ZAR"); // South African Rand
        tempMap.put(985, "BRL"); // Brazilian Real
        tempMap.put(986, "BRL"); // Brazilian Real
        tempMap.put(990, "CLP"); // Chilean Peso
        tempMap.put(994, "XPD"); // Palladium Ounce
        tempMap.put(997, "USN"); // US Dollar (Next day)
        tempMap.put(998, "USS"); // US Dollar (Same day)
        tempMap.put(999, "XXX"); // No currency

        CURRENCY_MAP = Collections.unmodifiableMap(tempMap);
    }
}
