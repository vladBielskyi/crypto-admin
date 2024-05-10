package ua.bielskyi.admin.model;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JmixEntity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiatGrowth {
    private String date;
    private Double monoValue = 0.0;
    private Double privatValue = 0.0;
    private Double openDataValue = 0.0;
}
