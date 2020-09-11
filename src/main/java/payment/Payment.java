package payment;

import my_exception.PhoneException;
import user.Account;
import user.Phone;

public interface Payment {
    abstract String sendPay(boolean first, String numberAccount, String numberPhone, long summa) throws PhoneException;
}
