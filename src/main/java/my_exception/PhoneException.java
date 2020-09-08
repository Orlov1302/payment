package my_exception;

public class PhoneException extends Exception{
    private String strPhone;
    public PhoneException( String message, String strPhone){
        super(message);
        this.strPhone = strPhone;
    }
    ////
    public String getPhone(){
        return strPhone;
    }
}
