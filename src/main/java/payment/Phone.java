package payment;

import my_exception.PhoneException;

public class Phone {
    public String numberPhone;

    public Phone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String errorNumberPhone() {
        String strReturn = "";
        for(int x=0 ; x<numberPhone.length() ; ++x){
            char c = numberPhone.charAt(x);
            if ( !('0' <= c && c <= '9') ){
                strReturn += "Телефонный номер должен быть только из цифр. ";
                break;
            }
        }
        if(numberPhone.length() != 10){
            strReturn += "Телефонный номер должен быть из 10 цифр. ";
        }
        return strReturn;
    }

    public void exceptionCorrectPhone() throws PhoneException {
        String error = errorNumberPhone();
        if( error != "" ) {
            throw new PhoneException(error, numberPhone);
        }
    }

}