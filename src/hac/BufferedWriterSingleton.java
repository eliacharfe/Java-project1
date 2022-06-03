package hac;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton class handling the BufferedWriter
 */
class BufferedWriterSingleton {
    /** Singleton instance */
    private static BufferedWriterSingleton single_instance = null;
    /** BufferedWriter */
    private BufferedWriter bufferedWriter ;

    /**
     * Create new BufferedWriter
     * @param filename - The name of file to load to the BufferedWriter
     * @throws IOException - Problem with create the BufferedWriter
     */
    private BufferedWriterSingleton(String filename) throws IOException{ // private
          bufferedWriter = new BufferedWriter(new FileWriter(filename)); // create according the name of file sent
    }
    //--------------------------

    /** @return - return the BufferedWriter */
    public BufferedWriter getBufferedWriter(){
        return this.bufferedWriter;
    }
    //------------------------------------------------------
    /**
     * Create singleton instance
     * @param filename - The name of file to send to the private constructor
     * @return - instance of singleton
     * @throws Exception - any exceptions
     */
    public static BufferedWriterSingleton Singleton(String filename) throws Exception {
        if (single_instance == null) {
            single_instance = new BufferedWriterSingleton(filename);
        }
        return single_instance;
    }
}