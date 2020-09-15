package payment;

import com.google.common.collect.HashMultimap;

import java.util.Date;
import java.util.HashSet;

public class Server {
    private HashSet<ParametersPayment> oldPayments; // Здесь храняться старые запросы

    public Server(){
        oldPayments = new HashSet<>();
    }

    public String getPay(Date date, String numberAccount, String numberPhone, long summa ){
        ParametersPayment parametersTest = new ParametersPayment(date, numberAccount, numberPhone, summa);
        if( oldPayments.contains(parametersTest) ){
            return "Запрос поступил повторно !!!!!!!!!!!!!\n";
        }
        oldPayments.add(parametersTest);
        return "Оплата произведена успешно со счета " + numberAccount + " для телефона " + numberPhone + "\n";
    }
}
