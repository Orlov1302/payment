package phone;

import my_exception.PhoneException;

public class TestCorrectPhone<T extends Phone> {
    private T t;

    public TestCorrectPhone(T t) {
        this.t = t;
    }

    public String errorInNumberPhone() {
        String strReturn;
        if( t.numberPhone.isEmpty() ) {
            return "Номер телефона пуст.";
        }else {
            String formatNumberPhone = t.formatNumberPhone();
            if (!formatNumberPhone.isEmpty()) {
                boolean errorFormat = false;
                if (t.numberPhone.length() != formatNumberPhone.length()) {
                    errorFormat = true;
                } else {
                    for (int x = 0; x < formatNumberPhone.length(); ++x) {
                        char cF = formatNumberPhone.charAt(x);
                        char cN = t.numberPhone.charAt(x);
                        if ('0' <= cF && cF <= '9') {
                            if (!('0' <= cN && cN <= '9')) {
                                errorFormat = true;
                                break;
                            }
                        } else if (cN != cF) {
                            errorFormat = true;
                            break;
                        }
                    }
                }
                if (errorFormat) {
                    return "Телефонный номер должен быть формата " + formatNumberPhone;
                }
            }
        }
        return "";
    }

    public void testCorrectNumberPhone() throws PhoneException {
        String error = errorInNumberPhone();
        if( error == null ){
            error = "Исключение NULL при проверке телефона.";
        }
        if( !error.equals("") ){
            throw new PhoneException(error, t.numberPhone);
        }
    }

}
