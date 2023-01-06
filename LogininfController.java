package sample;
//This controls the Login form
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.fxml.Initializable;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.datatransfer.*;
import java.io.*;
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
//import java.awt.datatransfer.Clipboard;


import javafx.stage.StageStyle;

import java.awt.datatransfer.StringSelection;




















public class LogininfController implements Initializable {

    //Displaying my variables
    @FXML
    private Button loginsave;

    @FXML
    private Button logincancel;
    @FXML
    private Button loginfavrt;


    @FXML
    private Button loginusercopy;

    @FXML
    private Button loginpasssee;
    @FXML
    private Button loginpasscopy;
    @FXML
    private Button usersee;
    @FXML
    private Button loginurlcopy;
    @FXML
    private ChoiceBox loginitemtype;

    @FXML
    private ChoiceBox loginfolder;

    @FXML
    private ChoiceBox loginmatch;

    @FXML
    private TextField loginname;

    @FXML
    private TextArea logintextarea;

    @FXML
    private TextField loginusername;

    @FXML
    private TextField loginurl;

    @FXML
    private PasswordField loginpass;


    @FXML
    private PasswordField usermask;
    @FXML
    private TextField logininfpasstextfield;

    @FXML
    private ImageView logininfpassnotvisbleimg;
    @FXML
    private ImageView logininfpassvisibleimg;

    @FXML
    private ImageView starnotvisible;
    @FXML
    private ImageView starvisible;
    @FXML
    private ImageView logininfusernotvisbleimg;
    @FXML
    private ImageView logininfuservisibleimg;

    Timer timer = new Timer();

    @FXML
    void stop(MouseEvent event) {




    }



    private String[] itemtype={"Login", "Card", "Identity", "Secure Note"};
    private String[] folder={"No Folder"};

    private String[] match={"Default match detection", "Base domain", "Host ", "Starts with", "Reguler expression", "Exact",
            "Never"};

    String userName = null;
    //initializing my variables and the form data
    @Override
    public  void initialize(URL arg1, ResourceBundle arg2)
    {
        //checking if this button was clicked
        loginurl.setOnMouseClicked(e -> {
            TextFields.bindAutoCompletion(loginurl,"check");;
            System.out.println("Clicked");
        });
        // open the file to read

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\user.txt"));
            String line;



            while ((line = reader.readLine()) != null) {

                userName=line;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(userName);

        // open the file to read
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\readlogin.txt"));
            String line;
            String[] takedata = new String[20];

            while ((line = reader.readLine()) != null) {


                takedata=line.split("#");
                System.out.println(takedata[1]);
                loginname.setText(takedata[1]);

                usermask.setText(takedata[2]);
                loginusername.setText(takedata[2]);

                System.out.println(takedata[2]);

                loginpass.setText(takedata[3]);
                logininfpasstextfield.setText(takedata[3]);
                System.out.println(takedata[3]);
                loginurl.setText(takedata[4]);

                loginmatch.setValue(takedata[5]);


                logintextarea.setText(takedata[6]);


            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        loginitemtype.getItems().addAll(itemtype);
        loginitemtype.setValue("Login");
        loginfolder.getItems().addAll(folder);
        loginfolder.setValue("No Folder");
        loginmatch.getItems().addAll(match);
        loginmatch.setValue("Default match detection");
//set ChoiceBox functionalities to show a new form everytime we change the data
        loginitemtype.setOnAction(event -> {
            if(loginitemtype.getValue().toString().equals("Secure Note"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 905, 641));
                stageee.show();
                Stage stage=(Stage) loginitemtype.getScene().getWindow();
                stage.close();
            }

            else if(loginitemtype.getValue().toString().equals("Card"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("Cardinf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 905, 839));
                stageee.show();
                Stage stage=(Stage) loginitemtype.getScene().getWindow();
                stage.close();
            }
            else   if(loginitemtype.getValue().toString().equals("Identity"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("Identityinf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 909, 800));
                stageee.show();
                Stage stage=(Stage) loginitemtype.getScene().getWindow();
                stage.close();
            }
        });


    }



    // set the function to show button if it is clicked when we add the input to favorite file
    public void loginfavrtonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(!starnotvisible.isVisible())
        {
            starnotvisible.setVisible(true);
        }
        else if(starnotvisible.isVisible())
        {
            starnotvisible.setVisible(false);

        }
        if(!starvisible.isVisible())
        {
            starvisible.setVisible(true);
        }
        else if(starvisible.isVisible())
        {
            starvisible.setVisible(false);

        }


    }
    //set save button functionalities
    public void loginsaveonAction(ActionEvent actionEvent) throws Exception {

        //saving the data in the right file
        if(!loginname.getText().isBlank()) {

            try {
                File myObj = new File("src\\main\\"+userName+"\\All\\Login," + loginname.getText() + ".txt");

                FileWriter writer = new FileWriter("src\\main\\"+userName+"\\All\\Login," + loginname.getText() + ".txt", true);
                writer.write(loginitemtype.getValue().toString());
                writer.write('#');

                writer.write(loginname.getText());
                writer.write('#');

                String username = null;
                if (logininfusernotvisbleimg.isVisible()) {
                    username = usermask.getText();

                } else {
                    username = loginusername.getText();
                }


                writer.write(username);
                writer.write('#');
                String password = null;
                if (logininfpassnotvisbleimg.isVisible()) {
                    password = loginpass.getText();

                } else {
                    password = logininfpasstextfield.getText();
                }


                writer.write(password);
                writer.write('#');

                writer.write(loginurl.getText());

                writer.write('#');

                writer.write(loginmatch.getValue().toString());


                writer.write('#');
                writer.write(logintextarea.getText());
                writer.write('#');

                writer.close();
//if the user clicked on add to favorite we will write the data into the right file in the right document
                if (starvisible.isVisible()) {
                    File myObjj = new File("src\\main\\"+userName+"\\Favorites\\Login," + loginname.getText() + ".txt");
                    FileWriter writerf = new FileWriter("src\\main\\"+userName+"\\Favorites\\Login," + loginname.getText() + ".txt", true);
                    writerf.write(loginitemtype.getValue().toString());
                    writerf.write('#');
                    writerf.write(loginname.getText());
                    writerf.write('#');


                    writerf.write(username);
                    writerf.write('#');


                    writerf.write(password);
                    writerf.write('#');

                    writerf.write(loginurl.getText());

                    writerf.write('#');

                    writerf.write(loginmatch.getValue().toString());


                    writerf.write('#');
                    writerf.write(logintextarea.getText());
                    writerf.write('#');

                    //writer.write('\n');
                    writerf.close();
                }

// this is used to keep track of users
                FileWriter writertwo = new FileWriter("src\\main\\"+userName+"\\track.txt", true);
                writertwo.write("Login");
                writertwo.write('#');
                writertwo.write(loginname.getText());
                writertwo.write('#');
                writertwo.write('\n');
                writertwo.close();

            } catch (
                    IOException e) {
                e.printStackTrace();
            }


        }
//load new main interface
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 1000, 800));
        stageee.show();


        Stage stage=(Stage) loginsave.getScene().getWindow();
        stage.close();

    }


    //set cancel button functionality
    public void logincancelonAction(ActionEvent actionEvent) throws Exception {
        //signup
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 1000, 800));
        stageee.show();
        Stage stage=(Stage) logincancel.getScene().getWindow();
        stage.close();

    }
    //set copy button functionality
    public void loginusercopyonAction(ActionEvent actionEvent) throws Exception {
        //signup
        String str=new String();
        if(logininfusernotvisbleimg.isVisible())
        {
            str = usermask.getText();

        }
        else {
            str = loginusername.getText();
        }

        Clipboard clip= Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(str);
        clip.setContent(content);
//set a timer to how long the input should be copied
        timer.cancel();
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Clipboard clip= Clipboard.getSystemClipboard();
                    clip.clear();
                    System.out.println("deleted");
                });
            }
        }, 10000, 500000000);

    }
    //set copy button functionality
    public void loginurlcopyonAction(ActionEvent actionEvent) throws Exception {
        //signup

        String str = loginurl.getText();
        Clipboard clip= Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(str);
        clip.setContent(content);
//set a timer to how long the input should be copied
        timer.cancel();
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Clipboard clip= Clipboard.getSystemClipboard();
                    clip.clear();
                    System.out.println("deleted");
                });
            }
        }, 10000, 500000000);
    }

    public void loginuserseeonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(logininfusernotvisbleimg.isVisible())
        {
            logininfusernotvisbleimg.setVisible(false);
            logininfuservisibleimg.setVisible(true);
            loginusername.setText(usermask.getText());
            loginusername.setVisible(true);
            usermask.setVisible(false);
        }
        else
        {
            logininfusernotvisbleimg.setVisible(true);

            logininfuservisibleimg.setVisible(false);
            usermask.setText(loginusername.getText());
            usermask.setVisible(true);
            loginusername.setVisible(false);
        }


    }
    // set see or not see functionality
    public void loginpassseeonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(logininfpassnotvisbleimg.isVisible())
        {
            logininfpassnotvisbleimg.setVisible(false);
            logininfpassvisibleimg.setVisible(true);
            logininfpasstextfield.setText(loginpass.getText());
            logininfpasstextfield.setVisible(true);
            loginpass.setVisible(false);
        }
        else
        {
            logininfpassnotvisbleimg.setVisible(true);

            logininfpassvisibleimg.setVisible(false);
            loginpass.setText(logininfpasstextfield.getText());
            loginpass.setVisible(true);
            logininfpasstextfield.setVisible(false);
        }


    }

    //set copy button functionality
    public void loginpasscopyonAction(ActionEvent actionEvent) throws Exception {
        //signup
        String str=new String();
        if(logininfpassnotvisbleimg.isVisible())
        {
             str = loginpass.getText();

        }
        else {
             str = logininfpasstextfield.getText();
        }

        Clipboard clip= Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(str);
        clip.setContent(content);
        //set a timer to how long the input should be copied
        timer.cancel();
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Clipboard clip= Clipboard.getSystemClipboard();
                    clip.clear();
                    System.out.println("deleted");
                });
            }
        }, 10000, 500000000);


    }
}