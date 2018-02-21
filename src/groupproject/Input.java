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
 * Call the class and the file chooser should open, once a JSON file is chosen
 * the file is read and parsed into a JSONObject. Call the get method to return
 * the JSONObject or JSONArray.
 * 
 * @author Taylor Johnson
 * @see www.examples.javacodegeeks.com/core-java/json/java-json-parser-example/
 * @see www.geeksforgeeks.org/parse-json-java/
 */
public class Input {
	private File inFile;

	/**
	 * Constructor method for Input. Creates the JFileChooser and stores the selected file.
	 */
	public Input() {
		// Create and open JFileChooser
		// Sets path of JSON file
		JFileChooser fc = new JFileChooser();
		// forces filechooser to use the user directory that launched the chooser
		fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fc.showOpenDialog(null);

		this.inFile = fc.getSelectedFile();

		// if there is no file selected, then exit gracefully
		if (inFile == null)
			System.exit(0);
	}

	public File getFile() {
		return inFile;
	}
}