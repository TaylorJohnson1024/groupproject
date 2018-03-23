package groupproject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * This class is used for the patient object. 
 * This class allows for the setting and retrieving of a Patient's ID, and whether they're in a trial or not.
 * 
 * @author Jacob Fulton
 *
 */

class Patient 
{
    private int id;
    private boolean inTrial;
    private ArrayList<Reading> readings;
    private ReadingList readingsArray;

    public Patient(int id, boolean inTrial){
            readings = new ArrayList<Reading>();
            this.setId(id);
            this.setInTrial(inTrial);

    }




    //===============Setters=================
    public void setInTrial(boolean inTrial) {
        this.inTrial = inTrial;
    }

    public void setId(int id) {
            this.id = id;
    }


    //============Getters===============
    public int getId() {
        return id;
    }

    public boolean isInTrial() {
        return inTrial;
    }


    //Starts a patient's trial.===
    public void startTrial(){
            this.inTrial = true; 
    }


    //ends a patient's trial===
    public void endTrial(){
            this.inTrial = false;
    }


    public ArrayList<Reading> getReadings() {
            return readings;
    }


    public void setReadings(ArrayList<Reading> readings) {
            this.readings = readings;
    }


    //adds a Reading object to the ReadingList array if patient ID matches
    //returns "successful" if the object is added, and "patient id doesn't match" if unsuccessful
    public String addReading(Reading obj)
    {
        int patient_id;
        patient_id = Integer.parseInt((String) obj.getPatientID());
        if((patient_id == id)&&(inTrial == true))
        {
            readings.add(obj);
            return ("successful");
        }

        return("Patient ID doesn't match");
    }
}

	
