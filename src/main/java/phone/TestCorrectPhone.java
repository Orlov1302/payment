package phone;

import lombok.Setter;
import my_exception.PhoneException;

public class TestCorrectPhone<T extends Phone>{
    private T tPhone;
    @Setter private FuncTestPhone funcTestPhone;

    public TestCorrectPhone() {
        funcTestPhone = FuncTestPhone_Standart::func;
    }
    public TestCorrectPhone(T t) {
        this();
        tPhone = t;
    }

    public void testCorrectNumberPhone() throws PhoneException {
        String error = funcTestPhone.func(tPhone);
        if( error == null ){
            error = "Исключение NULL при проверке телефона.";
        }
        if( !error.equals("") ){
            throw new PhoneException(error, tPhone.numberPhone);
        }
    }
}
