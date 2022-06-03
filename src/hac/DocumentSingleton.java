package hac;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.net.URL;

/**
 * Singleton class handling the Document
 */
class DocumentSingleton {
    /** Singleton instance */
    private static DocumentSingleton single_instance = null;
    /** Document */
    private Document document;

    /** @return - return the Document */
    public Document getDocument(){
        return this.document;
    }
    //---------------------------------------
    /**
     * Create new url and load it to the document
     * @param url - The url passed in args
     * @throws Exception - any exception (url exceptions, load url to document) - handled in AppDriver
     */
    private DocumentSingleton(String url) throws Exception { // just happens once
        new URL(url).toURI();
        document = Jsoup.connect(url).get(); // load url to the document
    }
    //--------------------------
    /**
     * Create singleton instance
     * @param url - The url to send to the private constructor
     * @return - instance of singleton
     * @throws Exception - any exceptions
     */
    public static DocumentSingleton Singleton(String url) throws Exception {
        if (single_instance == null) {
            single_instance = new DocumentSingleton(url);
        }
        return single_instance;
    }
}