package hac;
import hac.exceptions.Error;
import hac.library.OptionReader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to handling output of the program
 */
public class WriteToFile {
    /**
     * A function that do the extraction from the html via the Document according to list of options created,
     * and write to the file through the BufferedWriter sent.
     * @param writer - The buffered writer that was opening the file.
     * @param document - The document which will extract data from the URL that loaded to it and the options list
     * @param optionsList - The list of Interface options created
     * @throws Error - The address is fine, but all rest errors that can occurs for example during reading data etc.
     */
    public void writeInFile(BufferedWriter writer, Document document, ArrayList<OptionReader> optionsList) throws Error{
        try {
            for (OptionReader option : optionsList) {
                Elements elements = document.select(option.getType());
                for (Element element : elements) {
                    String line = element.attr(option.getAttribute());
                    if (!line.isEmpty()) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch(IOException e){
            throw new Error();
        }
    }
}





 // System.out.println(line);