package user;

import lombok.Getter;
import lombok.Setter;
import my_exception.PhoneException;
import payment.*;

import java.util.ArrayList;

public class User {
    @Setter @Getter public long numberUser;
    @Setter @Getter public String stringFIO;
    @Getter public ArrayList<Account> accounts;
    @Getter public ArrayList<Phone> phones;

    public User( long numberUser, String stringFIO ){
        this.numberUser = numberUser;
        this.stringFIO = stringFIO;
        accounts = new ArrayList<Account>();
        phones = new ArrayList<Phone>();
    }

    public String payPhone( boolean first, PaymantPhone paymantPhone, int nAccount, int nPhone, long summa ){
        String strReturn;
        strReturn = "------- Начало попытки платежа на сервер " + paymantPhone.getServerName() + " (порт " + paymantPhone.getPort() + ") -------\n";
        try{
            strReturn += paymantPhone.sendPay(first, accounts.get(nAccount).getNumberAccount(), phones.get(nPhone).getNumberPhone(), summa);
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

    public String payPhoneMulti( boolean first, PaymantPhone paymantPhone, int nAccount, int nPhone, long summa ){
        String strReturn;
        strReturn = "------- Начало попытки платежа на сервер " + paymantPhone.getServerName() + " (порт " + paymantPhone.getPort() + ") -------\n";
        try{
            strReturn += paymantPhone.sendPayMulti(first, accounts.get(nAccount).getNumberAccount(), phones.get(nPhone).getNumberPhone(), summa);
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
