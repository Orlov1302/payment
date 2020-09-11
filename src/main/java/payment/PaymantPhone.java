package payment;

import lombok.Getter;
import my_exception.*;
import user.Account;
import user.Phone;

import java.util.Date;


public class PaymantPhone implements Payment {
    @Getter private String serverName;
    @Getter private String port;
    private Server server;
    private Date oldDate;

    public PaymantPhone( String serverName, String port ){
        this.serverName = serverName;
        this.port = port;
        server = new Server();
    }

    @Override
    public String sendPay(boolean first, String numberAccount, String numberPhone, long summa) throws PhoneException {
        Date date;
        Phone.exceptionCorrectPhone( numberPhone );
        if( first ){
            date = new Date();
            oldDate = date;
        }else{
            date = oldDate;
        }
        return server.getPay(date, numberAccount, numberPhone, summa);
    }

    public String sendPayMulti(boolean first, String numberAccount, String numberPhone, long summa) throws PhoneException {
        Date date;
        Phone.exceptionCorrectPhone( numberPhone );
        if( first ){
            date = new Date();
            oldDate = date;
        }else{
            date = oldDate;
        }
        return server.getPayMulti(date, numberAccount, numberPhone, summa);
    }

}
