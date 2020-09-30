package phone;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Phone {
    protected String numberPhone;
    public String formatNumberPhone() {
        return "";
    }
}

////