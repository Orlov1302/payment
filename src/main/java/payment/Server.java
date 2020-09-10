package payment;

import com.google.common.collect.HashMultimap;

import java.util.Date;

public class Server {
    private HashMultimap<Date, ParametersPayment> oldPayments; // Здесь храняться старые запросы

    public Server(){
        oldPayments = HashMultimap.create();
    }

    public String getPay(Date date, String numberAccount, String numberPhone, long summa ){
        ParametersPayment parametersPayment = new ParametersPayment(numberAccount, numberPhone, summa);
        if( oldPayments.containsEntry(date, parametersPayment) ){
            return "Запрос поступил поторно !!!!!!!!!!!!!";
        }
        oldPayments.put(date, parametersPayment);
        return "Оплата произведена успешно со счета " + numberAccount + " для телефона " + numberPhone;
    }
}
