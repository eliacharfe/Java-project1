package hac;

import hac.exceptions.Error;
import java.io.IOException;

/**
 * Main class - call AppDriver to run the program
 */
public class Main {

    /**
     * Call AppDriver to run the program
     * @param args - The arguments sent to the program
     */
    public static void main(String[] args) {
        AppDriver driver = new AppDriver();
        try {
            driver.runApp(args);
        } catch (Error | IOException e) {
           System.out.println(new Error().getMessage()); // only if got exception by closing the file (from finally of runApp)
        }

    }
}