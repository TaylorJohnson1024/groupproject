package groupproject;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;


public class ClinicApplicationController {


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

    ReadingList readingList = new ReadingList();

    public void initialize(){
        //statemens that set what kind of data go into each column in the GUI's Table.
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("patientID"));
        readingColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("rType"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("rValue"));
        clinicColumn.setCellValueFactory(new PropertyValueFactory<Reading, String>("clinic"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Reading, Date>("rDate"));

        table.setItems(readingList.getReading());

    }
       // Date date = new Date(System.currentTimeMillis());



}
