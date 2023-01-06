package sample;


//This class is used to show the right data in  the table view in the main interface
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
public class Person {

CheckBox select;
Button edit;
Button delete;
    String name,type,brand;


//constructor
    public Person( String select ,String name, String type, String brand, Button edit, Button delete) {


        this.select=new CheckBox();

        this.name = name;
        this.type = type;
        this.brand = brand;

        this.edit=edit;
        this.edit.setText("Edit");


        this.delete=delete;
        this.delete.setText("Delete");



    }


//set functions
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }




// get functions
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public CheckBox getSelect() {
        return select;
    }

    public Button getEdit() {
        return edit;
    }
    public Button getDelete() {
        return delete;
    }

}

