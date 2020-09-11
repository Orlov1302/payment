package payment;

import com.google.common.collect.HashMultimap;

import java.util.Date;
import java.util.HashSet;

public class Server {
    private HashSet<ParametersPayment> oldPayments; // Здесь храняться старые запросы
    private HashMultimap<Date, ParametersMulti> oldPaymentsMulti; // Здесь храняться старые запросы

    public Server(){
        oldPayments = new HashSet<>();
        oldPaymentsMulti = HashMultimap.create();
    }

    public String getPay(Date date, String numberAccount, String numberPhone, long summa ){
        ParametersPayment parametersTest = new ParametersPayment(date, numberAccount, numberPhone, summa);
        if( oldPayments.contains(parametersTest) ){
            return "Запрос поступил повторно !!!!!!!!!!!!!\n";
        }
        oldPayments.add(parametersTest);
        return "Оплата произведена успешно со счета " + numberAccount + " для телефона " + numberPhone + "\n";
    }

    public String getPayMulti(Date date, String numberAccount, String numberPhone, long summa ){
        ParametersMulti parametersMulti = new ParametersMulti(numberAccount, numberPhone, summa);
        if( oldPaymentsMulti.containsEntry(date, parametersMulti) ){
            return "Запрос поступил повторно !!!!!!!!!!!!!\n";
        }
        oldPaymentsMulti.put(date, parametersMulti);
        return "Оплата произведена успешно со счета " + numberAccount + " для телефона " + numberPhone + "\n";
    }
}
