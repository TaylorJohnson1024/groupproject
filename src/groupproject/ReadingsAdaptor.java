package groupproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

public class ReadingsAdaptor {

    ReadingsAdaptor()
    {

    }

    /*
    * Converts a JSONArray into an Arraylist of Readings,
    * and returns the ArrayList of Readings.
    *
     */
    public ArrayList<Reading> JSONArrayToReadings(JSONArray patientReadings)
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

            type = (String) reading.get("reading_type");
            reading_id = (String) reading.get("reading_type");
            value = (String) reading.get("reading_type");
            date = (String) reading.get("reading_type");

            Reading thisReading = new  Reading(type, reading_id, value, date);
            readingArrayList.add(thisReading);
        }
        return readingArrayList;
    }

    /*
     * Converts an XML into an Arraylist of Readings,
     * and returns the ArrayList of Readings.
     *
     */
    public ArrayList<Reading> XMLToReadings(Object patientReadings)
    {
        ArrayList<Reading> readingArrayList = new ArrayList<Reading>();
        String type = null;
        String id = null;
        String value = null;
        String date = null;

        return readingArrayList;
    }


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
            JSONObject thisReading = new JSONObject();
            thisReading.put("clinic_id", null);
            thisReading.put("patient_id", null);
            thisReading.put("reading_type", readingObject.getRtype());
            thisReading.put("reading_id", readingObject.getRId());
            thisReading.put("reading_value", readingObject.getRValue());
            thisReading.put("reading_date", readingObject.getRDate().getTime());

            readings.add(thisReading);
        }

        return readings;
    }


}
