import user.*;
import payment.*;

import javax.swing.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long milisec;
        PaymantPhone paymantPhone1 = new PaymantPhone("sbol.sbrf.ru", "123" );
        User user1 = new User( 12345, "Иванов иван Иванович");
        int n, maxN = 1000000;
        // Тест работы
        user1.getAccounts().add(new Account("1234500001"));
        user1.getAccounts().add(new Account("1234500002"));
        user1.getAccounts().add(new Account("1234500003"));
        System.out.println( user1.payPhone(true, paymantPhone1,0,0, 100) );

        user1.getPhones().add(new Phone("89O5777O356"));
        System.out.println( user1.payPhone(true, paymantPhone1,0,0, 200) );

        user1.getPhones().add(new Phone("9O5777O356"));
        System.out.println( user1.payPhone(true, paymantPhone1,0,1, 300) );

        user1.getPhones().set(0, new Phone("9057770377"));
        user1.getPhones().set(1, new Phone("9057770356"));
        System.out.println( user1.payPhone(true, paymantPhone1,0,1, 400) );
        System.out.println( user1.payPhone(false, paymantPhone1,0,1, 400) );

        System.out.println("====== Тест быстродействия защиты от повторных запросов ===== ");

        System.out.print("На HashSet<ClassParametersBig> ");
        milisec = System.currentTimeMillis();
        for( n=1; n < maxN; ++n) {
            user1.payPhone(true, paymantPhone1, 0, 0, n);
            user1.payPhone(false, paymantPhone1, 0, 0, n);
        }
        milisec = System.currentTimeMillis() - milisec;
        System.out.println("заняло времени, мс: " + milisec);

        System.out.print("На HashMultimap<Date,ClassParametersSmall> ");
        milisec = System.currentTimeMillis();
        for( n=1; n < maxN; ++n) {
            user1.payPhoneMulti(true, paymantPhone1, 0, 0, n);
            user1.payPhoneMulti(false, paymantPhone1, 0, 0, n);
        }
        milisec = System.currentTimeMillis() - milisec;
        System.out.println("заняло времени, мс: " + milisec);

        //startShowUser( user1 ); //Проверка работы графического инстру
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
