package payment;

import my_exception.PhoneException;

import java.util.Date;

public interface Payment {
    abstract String sendPay(Date date, String numberAccount, String numberPhone, long summa) throws PhoneException;
}
