package sample;
//this will launch the primary user interface
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
import java.util.Timer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javafx.stage.Stage;

//import java.io.IOException;


public class main extends Application {
    @Override
    public void start(Stage primaarystage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("UserInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        primaarystage.initStyle(StageStyle.UNDECORATED);
        primaarystage.setScene(scene);
        primaarystage.show();






    }

    public static void main(String[] args) {
        launch(args);

    }
}