package ua.bielskyi.admin.model;

import io.jmix.core.metamodel.datatype.EnumClass;

public enum Crypto implements EnumClass<String> {
    BTC,
    ETH,
    XRP,
    LTC,
    BCH,
    ADA,
    DOT,
    LINK,
    BNB,
    XLM,
    BSV,
    USDC,
    XMR,
    TRX,
    EOS,
    XTZ,
    VET,
    ATOM,
    NEO,
    MIOTA;

    @Override
    public String getId() {
        return null;
    }
}
