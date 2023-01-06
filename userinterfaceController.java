package sample;
//This controls the primary user interface
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;






public class userinterfaceController {
    //Displaying my variables
    @FXML
    private Button usersignin;

    @FXML
    private Button usersignup;
    @FXML
    private Button cancelbutton;
    @FXML
    private Button maximizebutton;
    @FXML
    private Button minimizebutton;

    @FXML
            private Pane myPane;


Stage stage =null;
    //set min button functionality
    @FXML
    public void minonAction(ActionEvent actionEvent) throws Exception{
        //signin
        stage=(Stage) myPane.getScene().getWindow();
        stage.setIconified(true);
    }

    //set max button functionality
    @FXML
    public void maxonAction(ActionEvent actionEvent) throws Exception{
        //signin
        stage=(Stage) myPane.getScene().getWindow();
        if(stage.isMaximized())
            stage.setMaximized(false);
        else
            stage.setMaximized(true);
    }

    //set sign in button functionality
    public void usersigninonAction(ActionEvent actionEvent) throws Exception{

        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("login.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 536, 452));
        stageee.show();
        Stage stage=(Stage) usersignin.getScene().getWindow();
        stage.close();
    }


    //set sign up button functionality
    public void usersignuponAction(ActionEvent actionEvent) throws Exception {
        //signup
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("SignUptwo.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 740, 745));
        stageee.show();
        Stage stage=(Stage) usersignup.getScene().getWindow();
        stage.close();

    }











    //set cancel button functionality
    public void cancelbuttononAction(ActionEvent actionEvent) {
        Stage stage=(Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }


}