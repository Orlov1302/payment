package phone;

import lombok.Setter;
import my_exception.PhoneException;

public class TestCorrectPhone<T extends Phone>{
    private T tPhone;
    @Setter private FuncTestPhone funcTestPhone; //Внешняя функция для проверки соответствия телефонного номера некоторому формату

    public TestCorrectPhone() {
        funcTestPhone = FuncTestPhone_Standart::func;
    }
    public TestCorrectPhone(T t) {
        this();
        tPhone = t;
    }

    //Проверка соответствия телефонного номера некоторому формату с использованием внешней функции
    public void testCorrectNumberPhone() throws PhoneException {
        if( funcTestPhone != null && tPhone != null ){
            String error = funcTestPhone.func(tPhone); //Вызов внешней функции
            if( error == null ){ //Функция не должна возращать null
                error = "Исключение NULL при проверке телефона.";
            }
            if( !error.equals("") ){
                throw new PhoneException(error, tPhone.numberPhone);
            }
        }
    }
}

////