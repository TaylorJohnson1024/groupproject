package groupproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Object intended for retrieving a file.
 *
 * @author Taylor Johnson
 * @see //www.examples.javacodegeeks.com/core-java/json/java-json-parser-example/
 * @see //www.geeksforgeeks.org/parse-json-java/
 * @see //www.stackoverflow.com/questions/10739128/how-to-create-multiple-directories-given-the-folder-names
 */
public class Input {
    private File inFile;
    private String fileType;

    /**
     * Constructor method for Input.
     */
    public Input() {

    }

    /**
     * Creates the JFileChooser and stores the selected file.
     */
    public void fileChooser() {
        // Create and open JFileChooser
        // Sets path of JSON file
        JFileChooser fc = new JFileChooser();
        // Forces filechooser to use the user directory that launched the chooser
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fc.showOpenDialog(null);

        this.inFile = fc.getSelectedFile();

        // If there is no file selected, then exit gracefully
        if (inFile == null)
            System.exit(0);

        // If there is a file selected, then the file type is determined
        if (!(inFile == null))
            parseFileType();
    }

    /**
     * Parses inFile to retrieve the file type.
     * Ex. file named foobar.txt would return "txt"
     *
     * @see "https://stackoverflow.com/questions/3571223/how-do-i-get-the-file-extension-of-a-file-in-java/21974043"
     * @return String of the fileType
     */
    private String parseFileType() {
        String name = inFile.getName();
        try {
            this.fileType = name.substring(name.lastIndexOf(".") + 1);
            return fileType;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Gets the save file from an already completed session of this application.
     * If the filepath provided does not yield a file, then the directories are made instead
     * and an error is thrown.
     *
     * @param filePath path of the saved file
     * @return the saved file
     */
   static public File getSaveFile(String filePath) {
        try {
            File f = new File(filePath);
            return f;
        }
        catch (Exception e) {
            File f = new File(filePath);
            File directory = new File(f.getParent());
            directory.mkdirs();

            throw e;
        }
    }

    public File getFile() {
        return inFile;
    }

    public String getFileType() {
        return fileType;
    }
}