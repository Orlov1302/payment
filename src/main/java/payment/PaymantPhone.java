package payment;

import lombok.Getter;
import my_exception.*;
import java.util.Date;

public class PaymantPhone implements Payment {
    @Getter private String serverName;
    @Getter private String port;
    private Server server;

    public PaymantPhone( String serverName, String port ){
        this.serverName = serverName;
        this.port = port;
        server = new Server();
    }

    @Override
    public String sendPay(Date date, String numberAccount, String numberPhone, long summa) throws PhoneException {
        return server.getPay(date, numberAccount, numberPhone, summa);
    }
}
