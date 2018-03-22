package groupproject;

/*Author: Jacob Fulton

    Sets up and Manages the GUI
    contains ReadingList of all added readings

 */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.sql.Date;

import static groupproject.ClinicApplication.getInputAndExportAllReadings;


public class ClinicApplicationController {

    //===============Labels=========
    @FXML
    private Label statusLabel;

    //================Table Setup============
    @FXML
    private TableView<Reading> table;
    @FXML
    private TableColumn<Reading, String> patientIDColumn;
    @FXML
    private TableColumn<Reading, String> readingColumn;
    @FXML
    private TableColumn<Reading, String> valueColumn;
    @FXML
    private TableColumn<Reading, String> clinicColumn;
    @FXML
    private TableColumn<Reading, Date> dateColumn;
    @FXML
    private TableColumn<Reading, String> readingIDColumn;

   //===============TextFields===================
    @FXML
    private TextField clinicField;
    @FXML
    private TextField patientIDField;
    @FXML
    private TextField readingValueField;


    //==============Radio Buttons===========
    @FXML
    RadioButton bloodPressureRButton;
    @FXML
    RadioButton stepsRButton;
    @FXML
    RadioButton weightRButton;
    @FXML
    RadioButton temperatureRButton;

    private ToggleGroup readingValueGroup = new ToggleGroup();

    //Creates a ReadingList object to populate the Table
    ReadingList readingList = new ReadingList();

    public ReadingList getReadingList(){
        return readingList;
    }

    public void initialize(){

        bloodPressureRButton.setToggleGroup(readingValueGroup);
        stepsRButton.setToggleGroup(readingValueGroup);
        weightRButton.setToggleGroup(readingValueGroup);
        temperatureRButton.setToggleGroup(readingValueGroup);

      /*  try {
            getInputAndExportAllReadings();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      */  //statemens that set what kind of data go into each column in the GUI's Table.
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("patientID"));
        readingIDColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("rId"));
        readingColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("rType"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("rValue"));
        clinicColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("clinic"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Reading, Date>("rDate"));
        table.setItems(readingList.getReadings());

    }

    public void handleAddReadingButton(){
        boolean isValid = true;
        String clinic = "";
        String patientID = "";
        String readingValue = "";
        String readingType = "";
        Date date = new Date(System.currentTimeMillis());

        //Makes sure that all data fields are populated.
        //If all data fields are populated, the values are set to the variables.
        if(clinicField.getText().isEmpty()){
            isValid = false;
        }else if(patientIDField.getText().isEmpty()){
            isValid = false;
        }else if(readingValueField.getText().isEmpty()){
            isValid = false;
        }else {

            clinic = clinicField.getText();
            patientID = patientIDField.getText();
            readingValue = readingValueField.getText();

            if (bloodPressureRButton.isSelected() == true) {
                readingType = "Blood Pressure";
            } else if (stepsRButton.isSelected() == true) {
                readingType = "Steps";
            } else if (weightRButton.isSelected() == true) {
                readingType = "Weight";
            } else if (temperatureRButton.isSelected() == true) {
                readingType = "temperatue";
            } else {
                isValid = false;
            }
        }

        //only adds a new reading object & refreshes table if all data fields are populated.
        if(isValid == true){
            readingList.addReading(new Reading(patientID, clinic, readingType, readingValue, date ));
            table.setItems(readingList.getReadings());
            statusLabel.setText("Reading Added");
        }else{
            statusLabel.setText("Missing Data");
        }

    }

    public void refreshTable(){
        table.setItems(readingList.getReadings());
    }




}
