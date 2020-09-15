package phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Phone {
    protected String numberPhone;

    public String formatNumberPhone() {
        return "";
    }
}
