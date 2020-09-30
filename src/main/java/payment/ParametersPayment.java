package payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ParametersPayment {
    private Date date;
    private String numberAccount;
    private String numberPhone;
    private long summa;

    public ParametersPayment(){
        this(null,null,null,0);
    }
}

////
