package payment;

import my_exception.PhoneException;
import user.Account;
import user.Phone;

public interface Payment {
    void sendPay(boolean first, String numberAccount, String numberPhone, long summa) throws PhoneException;
}

//
