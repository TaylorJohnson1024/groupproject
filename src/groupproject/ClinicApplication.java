package groupproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import static javafx.application.Application.launch;


/**
 * Contains main. Gets the input from Input as a JSONArray,
 * and adds the given readings to the appropriate patient in 
 * the patientList ArrayList. New patients are added to patientList
 * if there is not already a patient with a matching id.
 * 
 * @GroupName:					The Lucky Seven
 * @MainClass Author:           Christopher Neuman
 * @Input Author: 				Taylor Johnson
 * @Patient Author: 			Jacob Fulton
 * @Output Author:              Zinet Kemal
 * 
 */
public class ClinicApplication extends Application{

    /*
     * Used to keep track of the patients in the trial.
     */
    static ArrayList<Patient> patientList = new ArrayList<Patient>();

    @Override
    public void start(Stage primaryStage) throws Exception{


            Parent root = FXMLLoader.load(getClass().getResource("ClinicApplication.fxml"));
            primaryStage.setScene(new Scene(root, 683, 473));
            primaryStage.show();


    }




    /**
     * 
     * main Class, calls getInput and setOutput.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {

    	//getInputAndExportAllReadings();
        launch(args);

    }

    /**
     * Instantiates new Input object,
     * sends file to parser and get
     * JSONArray object. Each JSON object in
     * the JSONArray is traversed and
     * passed to addReading.
     * finally call parseJSONAndExportAllReadings method to export all readings
     */
    public static void getInputAndExportAllReadings() throws FileNotFoundException
    {
    	Input in = new Input();
    	ReadingsJSONAdaptor adpt = new ReadingsJSONAdaptor();
    	in.fileChooser();
    	ParserJSON p = new ParserJSON(in.getFile());
    	ArrayList<Reading> patientReadings = adpt.switchJSONArrayToReadings(p.getJSONArray("patient_readings"));
    	
    	for(Reading reading: patientReadings)
    	{
            addReading(reading);
    	}
        
        //export all readings
        ArrayList<Reading> outReadings = new ArrayList<Reading>();
        for(Patient patient: patientList)
        {
            outReadings.addAll(patient.getReadings());
        }

        JSONArray out = adpt.readingArrayListToJSONArray(outReadings);
        Output output = new Output("output.json");
        output.parseJSONAndExportAllReadings(out);
        output.displayPatientReadings(out);
    }
    
    /**
     * Adds the given reading to the correct patient.
     * A new patient is added if none with the id from
     * the given Reading match any existing id in
     * patientList.
     * 
     * @param reading
     */
    public static void addReading(Reading reading)
    {
        int patient_id;
        patient_id = Integer.parseInt((String) reading.getPatientID());

    	/*
    	 * checks if the patientList is empty
    	 * if it is it adds a new patient to it
    	 * with the reading as its parameter.
    	 * Otherwise it cycles through patientList
    	 * looking for a patient with a matching ID.
    	 * If none is found with the same id it adds
    	 * a new patient. The patients are added with
    	 * there id's sorted from least to greatest. 
    	 */
    	if(patientList.isEmpty())
    	{
            addPatient(0, patient_id,  reading);
    	}
        else
    	{
            for(int i = 0; i < patientList.size(); i++)
            {
                if(patientList.get(i).getId() == patient_id)
                {
                        patientList.get(i).addReading(reading);
                        i = patientList.size();
                }
                else if(patientList.get(i).getId() < patient_id)
                {
                    addPatient(i,  patient_id, reading);
                    i = patientList.size();

                    /*
                     * adds a new patient to the end of 
                     * patientList if all of patientList
                     * has been checked and readings id 
                     * is greater than every other id in
                     * patientList.
                     */
                }
                else if(i == patientList.size()-1)
                {
                   addPatient(-1,  patient_id, reading);
                }
            }
    	}
    }
    
    /**
     * Adds a new patient with the Reading at the given index.
     * The new patient is added to the end of patientList if the
     * index is less than 0 (usually -1).
     * 
     * @param index
     * @param patient_id
     * @param reading
     */
    public static void addPatient(int index, int  patient_id, Reading reading)
    {
    	Patient newP = new Patient( patient_id, true);
    	newP.addReading(reading);
    	
    	if(index < 0)
    	{
            patientList.add(newP);
    	}else
    	{
            patientList.add(index, newP);
    	}
    	
    }
}