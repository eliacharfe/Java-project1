package hac.uses_factory;
import hac.library.OptionReader;
import hac.library.OptionReaderFactory;

/**
 * Class that construct an option of "links"
 */
public class Link implements OptionReader {
    /** The type of option */
    private final String type;
    /** A string to put in element's attribute */
    private final String jsoupRead;

    /**
     * Constructor gets a type and save it, as well, save a return type for the Document
     * @param type - A char representing the option
     */
    public Link(String type){
        this.type = type; // "a"
        this.jsoupRead = "abs:href"; // return string to the Document to extract
    }
    //-----------------------------------
    /**
     * Return a string to put in the Element attribute to extract
     * @return - "abs::href"
     */
    @Override
    public String getAttribute() {
        return jsoupRead;
    }
    //--------------------------------------------
    /**
     * Return a string that specifies the type of elements  to extract from the html
     * @return - The type sent at build
     */
    @Override
    public String getType() {
        return type;
    }
    //--------------------------------
    /**
     * Register an option command in the Factory
     * @param type - type of option
     */
    public static void register(String type) {
        OptionReaderFactory.register(type, args -> new Link(type));
    }
    //---------------------------------
}
