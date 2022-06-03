package hac.library;
import hac.exceptions.InvalidCommand;
import java.util.HashMap;

/**
 * Factory class that creates the options
 */
public final class OptionReaderFactory {
    /** Hash map that save the option commands*/
    private static final HashMap<String,  OptionReaderCreateCommand> optionReaderProducers = new HashMap<>();

    /** Constructor */
    private OptionReaderFactory() { }

    /**
     * Add a new option command to the hash map
     * @param type - A char representing an option
     * @param producer - An interface that creates a new option
     */
    public static void register(String type, OptionReaderCreateCommand producer) {
        optionReaderProducers.put(type, producer);
    }
    //---------------------------------------------------------

    /**
     * Produce the option reader if the type sent is registered in the hash map else throw error
     * @param type - A key (in that case is a char) that represent an option ('a', 'i', 'h', etc.)
     * @return - new OptionReader according to the type (could be Link / Image / Title ...)
     * @throws InvalidCommand - Command invalid (bad syntax, missing arguments, to many args etc.)
     */
    public static OptionReader produceReader(String type) throws InvalidCommand {
        if (!optionReaderProducers.containsKey(type)) {
            throw new InvalidCommand();
        }
        return optionReaderProducers.get(type).create();
    }
    //------------------------
}


