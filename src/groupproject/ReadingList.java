package groupproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

public class ReadingList {

    private ObservableList<Reading> readings;

    //Constructor
    public ReadingList(){
        readings = FXCollections.observableArrayList();
    }

    //method to return the Observable List
    public ObservableList<Reading> getReadings() {

        return readings;
    }

    //takes a reading as input, and adds it to the observable list
    public void addReading(Reading reading){
        readings.add(reading);
    }

}
