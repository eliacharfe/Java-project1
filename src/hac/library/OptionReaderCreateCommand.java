package hac.library;
import hac.exceptions.InvalidCommand;

/** Interface that creates a new option according to what sent */
public interface OptionReaderCreateCommand {
    /**
     * Produce option
     * @param args - create option according to arguments passed
     * @return - new option command
     * @throws InvalidCommand - Command invalid (bad syntax, missing arguments, to many args etc.)
     */
    OptionReader create(String... args) throws InvalidCommand;
}
