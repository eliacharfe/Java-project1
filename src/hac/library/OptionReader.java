package hac.library;

/**
 * An interface that every "option class" need to implement
 */
public interface OptionReader  {
    /** Virtual function
     * @return - a string to put in the Element attribute to extract
     */
    String getAttribute();
    /** Virtual function
     * Return a string that specifies the type of elements to extract from the html
     * @return - The type sent at build
     */
    String getType();
}

