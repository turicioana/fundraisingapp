package fundraisingapp.Base.CustomException;

public class EmailExistingException extends Exception {

    public EmailExistingException()
    {

    }

    public EmailExistingException(String message)
    {
        super(message);
    }
}
