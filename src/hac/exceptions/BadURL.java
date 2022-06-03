package hac.exceptions;

/**
 * Class exception - throwing when bad url sent
 */
public class BadURL extends Exception {

    /** Throw exception */
    public BadURL()  { super("bad url"); }
}
