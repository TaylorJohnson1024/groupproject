package groupproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

/*
 * Adaptor for changing JSONArrays into
 * ArrayLists, and vise versa.
 */
public class ReadingsAdaptor {

    ReadingsAdaptor()
    {

    }

    //==================================JSONToReading========================================

    /*
    * Converts a JSONArray into an Arraylist of Readings,
    * and returns the ArrayList of Readings.
    *
     */
    public ArrayList<Reading> switchJSONArrayToReadings(JSONArray patientReadings)
    {
        ArrayList<Reading> readingArrayList = new ArrayList<Reading>();
        String clinic_id = null;
        String patient_id = null;
        String type = null;
        String reading_id = null;
        String value = null;
        String date = null;

        for(Object rawReading: patientReadings)
        {
            JSONObject reading = (JSONObject) rawReading;
            Reading thisReading = switchJSONObjectToReading((JSONObject) rawReading);
            readingArrayList.add(thisReading);
        }
        return readingArrayList;
    }

    /*
     * Converts a JSONObject into a Reading,
     * and returns Reading.
     *
     */
    public Reading switchJSONObjectToReading(JSONObject reading)
    {
        String clinic_id = (String) reading.get("clinic_id");
        String patient_id = (String) reading.get("patient_id");
        String type = (String) reading.get("reading_type");
        String reading_id = (String) reading.get("reading_type");
        String value = (String) reading.get("reading_type");
        String date = (String) reading.get("reading_type");

        Reading thisReading = new  Reading(patient_id, clinic_id, type, reading_id, value, date);
        return thisReading;
    }

    //=================================XMLToReading=============================================

    /*
     * Converts an XML into an Arraylist of Readings,
     * and returns the ArrayList of Readings.
     *
     */
    public ArrayList<Reading> switchXMLToReadings(Object patientReadings)
    {
        ArrayList<Reading> readingArrayList = new ArrayList<Reading>();
        String type = null;
        String id = null;
        String value = null;
        String date = null;

        return readingArrayList;
    }

    //========================================ReadingToJSON==================================================

    /*
     * Converts an Arraylist of Readings into a JSONArray,
     * and returns the JSONArray.
     *
     */
    public JSONArray readingArrayListToJSONArray(ArrayList<Reading> readingArrayList)
    {
        JSONArray readings = new JSONArray();


        for(Reading readingObject: readingArrayList)
        {
            JSONObject thisReading = readingToJSONObject(readingObject);

            readings.add(thisReading);
        }

        return readings;
    }

    /*
     * Converts a Reading into a JSONObject,
     * and returns the JSONObject.
     *
     */
    public JSONObject readingToJSONObject(Reading readingObject)
    {
        JSONObject thisReading = new JSONObject();

        thisReading.put("clinic_id", readingObject.getClinic());
        thisReading.put("patient_id", readingObject.getPatientID());
        thisReading.put("reading_type", readingObject.getRType());
        thisReading.put("reading_id", readingObject.getRId());
        thisReading.put("reading_value", readingObject.getRValue());
        thisReading.put("reading_date", readingObject.getRDate().getTime());

        return thisReading;
    }


}
