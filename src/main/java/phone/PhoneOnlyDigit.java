package phone;

public class PhoneOnlyDigit extends Phone {
    public PhoneOnlyDigit(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String formatNumberPhone() {
        return "9999999999";
    }
}

////