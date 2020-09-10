package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import my_exception.PhoneException;

@AllArgsConstructor
@Setter
@Getter
public class Phone {
    private String numberPhone;

    public static String errorNumberPhone( String numPhone ){
        String strReturn = "";
        for(int x=0 ; x<numPhone.length() ; ++x){
            char c = numPhone.charAt(x);
            if ( !('0' <= c && c <= '9') ){
                strReturn += "Телефонный номер должен быть только из цифр. ";
                break;
            }
        }
        if(numPhone.length() != 10){
            strReturn += "Телефонный номер должен быть из 10 цифр. ";
        }
        return strReturn;
    }

    public static void exceptionCorrectPhone( String numPhone ) throws PhoneException {
        String error = errorNumberPhone( numPhone );
        if( error != "" ) {
            throw new PhoneException(error, numPhone);
        }
    }

}

//