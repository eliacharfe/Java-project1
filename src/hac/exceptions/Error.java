package hac.exceptions;

/**
 * Class exception - throwing when errors occur (not invalid command / bad url)
 */
public class Error extends Exception{

    /** Throw exception */
    public Error()
    {
        super("error");
    }
}
