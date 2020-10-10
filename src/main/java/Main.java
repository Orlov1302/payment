import payment.Currency;
import payment.PaymentParameters;
import phone.Phone;
import phone.ValidationFuncOfPhone_Strong;
import phone.Phone_OnlyDigits;
import phone.Phone_PlusAndDigits;
import putting.QueuePutting;
import taking.QueueTaking;
import user.*;
import server.*;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User( 12345, "Иванов иван Иванович");
        user1.setNumberAccount("1234500001");

        user1.setPhone(new Phone_OnlyDigits("9O57770377"));
        System.out.println( user1.validationPhone() );
        System.out.println( "[" + user1.validationPhone().substring(0,10) + "]");

        user1.setPhone(new Phone_PlusAndDigits("+89057770377"));
        System.out.println( user1.validationPhone() );
        System.out.println( user1.validationPhone(ValidationFuncOfPhone_Strong::func) );

        user1.setPhone(new Phone_PlusAndDigits("+79057770555"));
        System.out.println( user1.validationPhone(ValidationFuncOfPhone_Strong::func) );
        System.out.println( user1.validationPhone((Phone t)->"Все номера телефонов плохие"));

        //Запуск потока принимающего платежи
        BlockingQueue<PaymentParameters> queue1 = new LinkedBlockingQueue<>();
        QueuePutting queuePutting1 = new QueuePutting(queue1);
        QueueTaking queueTaking1 = new QueueTaking(queue1);
        Server server1 = new Server(queueTaking1);

        Date date = new Date();
        PaymentParameters paymentParameters1 = user1.getParametersPayment(date, 400, Currency.RUB );
        queuePutting1.putPayment(paymentParameters1);
        queuePutting1.putPayment(paymentParameters1);

        System.out.println("========================================= ");
        sleep(3000);
        server1.stopServer();
    }
}

////