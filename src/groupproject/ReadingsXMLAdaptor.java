package groupproject;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ReadingsXMLAdaptor {

    private ArrayList<Reading> readingArrayList;
    private Reading thisReading;

    private String clinic_id;
    private String patient_id;
    private String type;
    private String reading_id;
    private String value;
    private String date;

    public ReadingsXMLAdaptor()
    {

    }


    /*
     * Converts an XML into an Arraylist of Readings,
     * and returns the ArrayList of Readings.
     *
     */
    public ArrayList<Reading> switchXMLToReadings(Document patientReadings)
    {
        setAllDataNull();
        readingArrayList = new ArrayList<Reading>();

        NodeList nodeList =  patientReadings.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node data = nodeList.item(i);
            if (data.getNodeType() == Node.ELEMENT_NODE) {
                // do something with the current element

                switch(data.getNodeName())
                {
                    case "clinic id":
                        if(clinic_id == null)
                        {
                            clinic_id = data.getNodeValue();
                        }else
                        {
                            AddReadingToList();
                            clinic_id = data.getNodeName();
                        }
                        break;
                    case "Reading type":
                        if(type == null)
                        {
                            type = data.getNodeValue();
                        }else if(patient_id != null) //ensure there is a patient ID before adding a Reading.
                        {
                            AddReadingToList();
                            type = data.getNodeName();
                        }else
                        {
                            setAllDataNull();
                            type = data.getNodeName();
                        }
                        break;
                    case "Value unit":
                        if(value == null)
                        {
                            value = data.getNodeValue();
                        }else if(patient_id != null) //ensure there is a patient ID before adding a Reading.
                        {
                            AddReadingToList();
                            value = data.getNodeName();
                        }else
                        {
                            setAllDataNull();
                            value = data.getNodeName();
                        }
                        break;
                    case "Patient":
                        if(patient_id == null)
                        {
                            patient_id = data.getNodeValue();
                        }else
                        {
                            AddReadingToList();
                            patient_id = data.getNodeName();
                        }
                        break;
                }

            }
        }


        return readingArrayList;
    }

    /*
    * sets all Strings back to null
    * except for clinic_id.
     */
    private void setAllDataNull()
    {
        patient_id = null;
        type = null;
        reading_id = null;
        value = null;
        date = null;
    }

    /*
     * Inserts the data from all of the
     * Strings  into a new Reading Object,
     * adds that Reading to readingArrayList,
     * and resets all the strings except
     * clinic_id to null.
     */
    private void AddReadingToList()
    {
        thisReading = new  Reading(patient_id, clinic_id, type, reading_id, value, date);
        readingArrayList.add(thisReading);

        setAllDataNull();
    }

}
