import payment.ParametersPayment;
import phone.FuncTestPhone_Strong;
import phone.PhoneOnlyDigit;
import phone.PhonePlus;
import putting.QueuePutting;
import taking.QueueTaking;
import user.*;
import server.*;
import javax.swing.*;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Date date;
        User user1 = new User( 12345, "Иванов иван Иванович");

        user1.setNumberAccount("1234500001");
        user1.setPhone(new PhoneOnlyDigit("9O57770377"));
        System.out.println( user1.testPhone() );

        user1.setPhone(new PhonePlus("+89057770377"));
        System.out.println( user1.testPhone() );
        System.out.println( user1.testPhone(FuncTestPhone_Strong::func) );

        user1.setPhone(new PhonePlus("+79057770555"));
        System.out.println( user1.testPhone(FuncTestPhone_Strong::func) );

        //Запуск потока принимающего платежи
        BlockingQueue<ParametersPayment> queue1 = new LinkedBlockingQueue<>();
        QueuePutting queuePutting1 = new QueuePutting(queue1);
        QueueTaking queueTaking1 = new QueueTaking(queue1);
        Server server1 = new Server(queueTaking1);

        date = new Date();
        ParametersPayment parametersPayment1;
        parametersPayment1 = user1.getParametersPayment(date, 400 );
        queuePutting1.putPayment( parametersPayment1 );
        queuePutting1.putPayment( parametersPayment1 );



        //startShowUser( user1, paymantPhone1 ); //Проверка работы графического инструмента
        System.out.println("========================================= ");
        sleep(3000);
        server1.stopServer();
    }

    public static void startShowUser( User user ){
        // создать фрейм в потоке диспетчеризации событий
        //SwingUtilities.invokeLater(() -> new ShowUser(user, Putting putting));
        /* То же самое записанное в старом стиле:
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){ new ShowUser(user); }
        }); */
    }
}
