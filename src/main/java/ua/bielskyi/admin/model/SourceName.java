package ua.bielskyi.admin.model;

import lombok.Getter;

public enum SourceName {
    MONOBANK(1),
    PRIVATBANK(2),
    OPEN_DATA(3);

    @Getter
    private int value;

    SourceName(int value) {
        this.value = value;
    }
}
