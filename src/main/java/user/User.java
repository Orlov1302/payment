package user;

import lombok.Getter;
import lombok.Setter;
import my_exception.PhoneException;
import payment.*;
import phone.Phone;
import phone.TestCorrectPhone;

import java.util.Date;

@Setter
@Getter
public class User {
    public long numberUser;
    public String stringFIO;
    String numberAccount;
    Phone phone;

    public User( long numberUser, String stringFIO ){
        this.numberUser = numberUser;
        this.stringFIO = stringFIO;
    }

    public String payPhone(Date date, PaymantPhone paymantPhone, long summa ){
        String strReturn;
        strReturn = "------- Начало попытки платежа на сервер " + paymantPhone.getServerName() + " (порт " + paymantPhone.getPort() + ") -------\n";
        try{
            (new TestCorrectPhone<>(phone)).testCorrectNumberPhone();
            strReturn += paymantPhone.sendPay(date, numberAccount, phone.getNumberPhone(), summa);
        }
        catch(PhoneException p_ex){
            strReturn += "Иcключeниe: " + p_ex.getMessage() + "\n" + "Номер телефона: " + p_ex.getPhone() + "\n";
        }
        catch(Exception ex){
            strReturn += "Иcключeниe: " + ex.getMessage() + "\n";
        }
        finally {
            strReturn += "======= Окончание попытки платежа ======= \n";
        }
        return strReturn;
    }

}
