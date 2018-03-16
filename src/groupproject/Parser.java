package groupproject;

import java.io.File;

/**
 * An abstract class with a focus on parsing objects
 * into a usable format.
 */
abstract public class Parser {
    private File inFile;

    /**
     * All parsing class will have a method which parses
     * an object.
     */
    abstract void parseObject();

    public void setInFile(File f) {
        this.inFile = f;
    }

    public File getInFile() {
        return inFile;
    }
}
