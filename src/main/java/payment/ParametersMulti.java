package payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ParametersMulti {
    private String numberAccount;
    private String numberPhone;
    private long summa;
}
