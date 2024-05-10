package ua.bielskyi.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CryptoData {
    protected LocalDate date;
    protected Double open;
    protected Double close;
    protected Double low;
    protected Double high;
}
