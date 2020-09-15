package phone;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneOnlyDigit extends Phone {
    public PhoneOnlyDigit(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String formatNumberPhone() {
        return "1234567890";
    }
}
