package payment;

import my_exception.PhoneException;

public interface Payment {
    void pay( Account account, Phone phone ) throws PhoneException;
}
