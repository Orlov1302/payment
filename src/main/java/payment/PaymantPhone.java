package payment;

import my_exception.*;

public class PaymantPhone implements Payment {
    public String server;
    public String port;

    public PaymantPhone( String server, String port ){
        this.server = server;
        this.port = port;
    }
    ////
    @Override
    public void pay(Account account, Phone phone) throws PhoneException {
        phone.exceptionCorrectPhone();
        System.out.println("Оплата произведена успешно со счета " + account.numberAccount + " для телефона " + phone.numberPhone );
    }
}
