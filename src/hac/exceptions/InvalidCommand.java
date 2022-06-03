package hac.exceptions;

/**
 * Class exception - throwing when the command sent are invalid
 */
public class InvalidCommand extends Exception{

    /** Throw exception */
    public InvalidCommand()
    {
        super("invalid command");
    }
}
