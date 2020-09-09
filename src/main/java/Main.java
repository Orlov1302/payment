import user.*;
import payment.*;
import my_exception.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        PaymantPhone paymantPhone1 = new PaymantPhone("sbol.sbrf.ru", "123" );
        User user1 = new User( 12345, "Иванов иван Иванович");

        user1.getAccounts().add(new Account("1234500001"));
        user1.getAccounts().add(new Account("1234500002"));
        user1.getAccounts().add(new Account("1234500003"));
        user1.payPhone(paymantPhone1,0,0);

        user1.getPhones().add(new Phone("89O5777O356"));
        user1.payPhone(paymantPhone1,0,0);

        user1.getPhones().add(new Phone("9O5777O356"));
        user1.payPhone(paymantPhone1,0,1);

        user1.getPhones().set(1, new Phone("9057770356"));
        user1.payPhone(paymantPhone1,0,1);

        startShowUser( user1 );
        System.out.println("========================================= ");
    }

    public static void startShowUser( User user ){
        // создать фрейм в потоке диспетчеризации событий
        SwingUtilities.invokeLater(() -> new ShowUser(user));
        /* То же самое записанное в старом стиле:
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){ new ShowUser(user); }
        }); */
    }
}
