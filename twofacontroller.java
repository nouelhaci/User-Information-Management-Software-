package sample;
// this is for the extra credits but it didn't work bc there was a problem with the compiler library
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.fxml.Initializable;
import java.net.URL;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import javafx.event.ActionEvent;









public class twofacontroller {



    @FXML
    private Button Logincancelbutton;

    @FXML
    private Button Loginbutton;

    @FXML
    private Button sendcode;






    @FXML
    private TextField loginusername;



































    public void sendcodeononAction(javafx.event.ActionEvent actionEvent) throws Exception{

















    }













    public void LoginbuttononAction(javafx.event.ActionEvent actionEvent) throws Exception{

















    }



    public void LogincancelbuttonAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage) Logincancelbutton.getScene().getWindow();
        stage.close();
    }



}
