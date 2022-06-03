package hac;

import hac.exceptions.BadURL;
import hac.exceptions.Error;
import hac.exceptions.InvalidCommand;
import hac.library.OptionReader;
import hac.library.OptionReaderFactory;
import hac.uses_factory.Image;
import hac.uses_factory.Link;
import hac.uses_factory.Title;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * The main class that runs the program
 */
public class AppDriver {
    /** To build link option command */
    private static final String LINK_OPTION = "a";
    /** To build image option command */
    private static final String IMAGE_OPTION = "i";
    /** To build h1 option command */
    private static final String TITLE_OPTION = "h";

    /** to put at the end of the filename sent */
    private static final String EXTENSION = ".txt";

    /**
     * Main loop function that run all program
     * @param args - The arguments' sen to the program (command options, URL, filename)
     * @throws IOException - Throw error if cannot close the BufferWriter to Main (rest of exceptions handled
     * in that function).
     * @throws Error - Same
     */
    public void runApp(String[] args) throws IOException, Error {
        BufferedWriter writer = null;
        try {
            if (args.length < 3 || args[0].charAt(0) != '-')
                throw new InvalidCommand();

            registerAll();

            ArrayList<OptionReader> optionsList = createOptionsList(args[0]); // array of Interface with the options
            Document document = loadDocument(args[1]); // Singleton load once

            writer = BufferedWriterSingleton.Singleton(args[2] + EXTENSION).getBufferedWriter();// create writer
            new WriteToFile().writeInFile(writer, document, optionsList); // extract and write to the file
            writer.close();
        }
        catch (InvalidCommand | BadURL | Error e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
           System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
           if (writer != null)
               writer.close() ;
        }
    }
    //-----------------------------
    /**
     * This function is called only once in order to load the Document that I will use to extract data from html
     * @param url - The URL to load to the document
     * @return The Document created
     * @throws BadURL - If the URL is invalid (or malformed syntax or the URL doesn't consist html,or doesnt exist
     * @throws Error - The address is fine, but all errors that can occurs for example during reading etc.
     */
    private Document loadDocument(String url) throws BadURL, Error {
        try {
            return DocumentSingleton.Singleton(url).getDocument(); // call Singleton class that creates the doc
        }
        catch (MalformedURLException | UnknownHostException e){
            throw new  BadURL();
        }
         catch (IOException e) {
            throw new  Error();
        }
        catch (Exception e) {
            throw new Error();
        }
    }
    //------------------------------------
    /**
     * Create an array of interface of options according to the type commands given - using Factory.
     * @param typeCommands - The type of commands that were given
     * @return - List of OptionReader (interface)
     * @throws InvalidCommand - Command invalid (bad syntax, missing arguments, to many args etc.)
     */
    private ArrayList<OptionReader> createOptionsList(String typeCommands) throws InvalidCommand {
        ArrayList<OptionReader> optionsList = new ArrayList<>();
        typeCommands = typeCommands.substring(1); // erasing the first character which is '-'
        for (char type : typeCommands.toCharArray()) {
            OptionReader option = OptionReaderFactory.produceReader(String.valueOf(type));
            // create new option using factory (if exist, else exception is thrown)
            optionsList.add(option);
        }
        return optionsList;
    }
    //-------------------------------
    /**
     * A function that register all basic options (if we want to add a new option, for example "p", we need
     * to create a class "Paragraph" that implements "OptionReader" and add the line here:
     * "Paragraph.register("p")"
     */
    private void registerAll() {
        Link.register(LINK_OPTION); // "a"
        Image.register(IMAGE_OPTION); // "i"
        Title.register(TITLE_OPTION); // "h"
    }
}


// String typeCommands = args[0];
// String urlString = args[1];
//String filename = args[2] + EXTENSION;
