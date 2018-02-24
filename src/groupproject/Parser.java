package groupproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private File inFile;
    private String fileType;
    private FileReader reader;
    private JSONParser jsonParser;
    private JSONObject selectedJSONObject;
    private Document selectedXMLDocument;

    /**
     *  Constructor for Parser.
     *  This constructor method is intended to be used in conjunction with Input.
     *
     * @param f File received from input
     */
    public Parser(File f) {
        this.inFile = f;
        this.fileType = parseFileType();

        switch (fileType) {
            case "json":
                parseJSONInput();
            case "xml":
                parseXMLInput();
            default:
                System.out.println("File type " + fileType + " not supported by parser.");
        }
    }

    public Parser() {

    }

    /**
     *  Parses the file into a JSONObject, which allows the use of
     *  either getJSONObject or getJSONArray.
     */
    private void parseJSONInput() {
        // Reads and parses the file
        try {
            this.reader = new FileReader(inFile);
            this.jsonParser = new JSONParser();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Turns contents of JSON file into a JSONObject
        try {
            this.selectedJSONObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *  Parses the file into an XML object called Document.
     *
     *  @see "https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/"
     */
    private void parseXMLInput() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inFile);

            // See link for normalization process
            // https://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            this.selectedXMLDocument = doc;
        }
        catch (Exception ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get the JSONObject from the file selected.
     *
     * @return JSONObject from file selected
     */
    public JSONObject getJSONObject() {
        return selectedJSONObject;
    }

    /**
     * Get the main JSONArray from the file selected.
     *
     * @return JSONArray from file selected
     */
    public JSONArray getJSONArray(String nameOfArray) {
        JSONArray selectedJSONArray;
        selectedJSONArray = (JSONArray) selectedJSONObject.get(nameOfArray);
        return selectedJSONArray;
    }

    /**
     * Get the XML Document from the file selected.
     *
     * @return Document from the file selected
     */
    public Document getXMLDocument() {
        return selectedXMLDocument;
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
     * Returns the file type of the inputted file.
     * Ex. file named foobar.txt would return "txt"
     *
     * @return String of the fileType
     */
    public String getFileType() {
        return fileType;
    }
}
