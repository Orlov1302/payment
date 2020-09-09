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

    public void payPhone( PaymantPhone paymantPhone, int nAccount, int nPhone ){
        System.out.println("------- Начало попытки платежа на сервер " + paymantPhone.server + " (порт " + paymantPhone.port + ") -------");
        try{
            paymantPhone.pay(accounts.get(nAccount), phones.get(nPhone));
        }
        catch(PhoneException p_ex){
            System.out.println(p_ex.getMessage());
            System.out.println("Номер телефона: " + p_ex.getPhone());
        }
        catch(Exception ex){
            System.out.println("Иcключeниe: " + ex.getMessage());
        }
        finally {
            System.out.println("======= Окончание попытки платежа ======= ");
        }
    }
}
