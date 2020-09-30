package phone;

public class FuncTestPhone_Strong {
    public static String func(Phone t) {
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
                        if (cF == '9') {
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
}

////