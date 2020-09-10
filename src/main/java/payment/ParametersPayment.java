package payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class ParametersPayment {
    private String numberAccount;
    private String numberPhone;
    private long summa;
/*  МОЙ МЕТОД НЕ РАБОТАЕТ. ПОЧЕМУ НЕ РАБОТАЕТ - НЕ ПОНИМАЮ
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }else if( (((ParametersPayment)obj).numberAccount.equals(numberAccount) ) &&
                  (((ParametersPayment)obj).numberPhone.equals(numberPhone) ) &&
                  (((ParametersPayment)obj).summa == summa) ) {
            return true;
        }else {
            return false;
        }
    }
*/
}

//
