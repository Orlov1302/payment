package user;

import lombok.Getter;
import lombok.Setter;
import my_exception.PhoneException;
import payment.*;
import phone.FuncTestPhone;
import phone.FuncTestPhone_Strong;
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

    public String testPhone(){
        return testPhone(null);
    }

    public String testPhone(FuncTestPhone testFunc){
        TestCorrectPhone<Phone> testCorrectPhone;
        try{
            testCorrectPhone = new TestCorrectPhone<>(phone);
            if( testFunc != null ){
                testCorrectPhone.setFuncTestPhone(FuncTestPhone_Strong::func); //Замена стандартной функции тестировани
            }
            testCorrectPhone.testCorrectNumberPhone(); // Тест корректности номера телефона
        }
        catch(PhoneException p_ex){
            return "Иcключeниe: " + p_ex.getMessage() + "\n" + "Номер телефона: " + p_ex.getPhone() + "\n";
        }
        catch(Exception ex){
            return "Иcключeниe: " + ex.getMessage() + "\n";
        }
        return "Телефон "+ phone.getNumberPhone() + " соответсвует формату " + phone.formatNumberPhone() + "\n";
    }


    public ParametersPayment getParametersPayment(Date date, long summa ){
        return new ParametersPayment(date, numberAccount, phone.getNumberPhone(), summa);
    }

}

//
