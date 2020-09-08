package user;

import my_exception.PhoneException;
import payment.*;

import java.util.ArrayList;

public class User {
    public long numberUser;
    public String stringFIO;
    public ArrayList<Account> accounts;
    public ArrayList<Phone> phones;

    public void addNumberAccount( String numberAccount ){
        accounts.add(new Account(numberAccount));
    }
    public Account getAccount(int n) {
        return accounts.get(n);
    }
    public int sizeAccounts() { return accounts.size(); }

    public void addNumberPhone( String numberPhone ){
        phones.add(new Phone(numberPhone));
    }
    public void setNumberPhone( int n, String numberPhone ){
        phones.set(n, new Phone(numberPhone));
    }
    public Phone getPhone(int n) {
        return phones.get(n);
    }
    public int sizePhones() {
        return phones.size();
    }

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
