package phone;

public class PhonePlus extends Phone {
    public PhonePlus(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String formatNumberPhone() {
        return "+71234567890";
    }

}
