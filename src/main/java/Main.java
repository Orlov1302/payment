import phone.FuncTestPhone_Strong;
import phone.PhoneOnlyDigit;
import phone.PhonePlus;
import user.*;
import payment.*;
import javax.swing.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long milisec;
        Date date;
        PaymantPhone paymantPhone1 = new PaymantPhone("sbol.sbrf.ru", "123" );
        User user1 = new User( 12345, "Иванов иван Иванович");
        int n, maxN = 100;
        // Тест работы
        user1.setNumberAccount("1234500001");
        user1.setPhone(new PhoneOnlyDigit("9O57770377"));
        System.out.println( user1.testPhone() );

        user1.setPhone(new PhonePlus("+89057770377"));
        System.out.println( user1.testPhone() );
        System.out.println( user1.testPhone(FuncTestPhone_Strong::func) );

        date = new Date();
        System.out.println( user1.payPhone(date, paymantPhone1,400) );
        System.out.println( user1.payPhone(date, paymantPhone1,400) );

        System.out.println("====== Тест быстродействия защиты от повторных запросов ===== ");
        System.out.print("На HashSet<ClassParametersBig> ");
        milisec = System.currentTimeMillis();
        for( n=1; n < maxN; ++n) {
            date = new Date();
            user1.payPhone(date, paymantPhone1, n);
            user1.payPhone(date, paymantPhone1, n);
        }
        milisec = System.currentTimeMillis() - milisec;
        System.out.println("заняло времени, мс: " + milisec);

        startShowUser( user1, paymantPhone1 ); //Проверка работы графического инстру
        System.out.println("========================================= ");
    }

    public static void startShowUser( User user, PaymantPhone paymantPhone ){
        // создать фрейм в потоке диспетчеризации событий
        SwingUtilities.invokeLater(() -> new ShowUser(user, paymantPhone));
        /* То же самое записанное в старом стиле:
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){ new ShowUser(user); }
        }); */
    }
}
