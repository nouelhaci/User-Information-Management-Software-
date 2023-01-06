package sample;
//This controls the Log in interface
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


public class LoginController implements Initializable{

    //Displaying my variables
    @FXML
    private Button Logincancelbutton;

    @FXML
    private Button Loginbutton;

    @FXML
    private Button creataccountbutton;

    @FXML
    private Button loginpassvisible;


    @FXML
    private Label LoginMessage;

    @FXML
    private Label logincreataccount;

    @FXML
    private TextField loginusername;

    @FXML
    private PasswordField loginpassword;
    @FXML
    private TextField logingpasstextfield;
    @FXML
    private ImageView loginvisible;

    @FXML
    private ImageView loginnotvisible;
    @FXML
    private CheckBox twoFA;


    @Override
    public  void initialize(URL arg7, ResourceBundle arg8)
    {

//just for testing
       // loginnotvisible.setImage(myImage);
    }




















    // set see or not see functionality
    public void loginpassvisibleonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(loginnotvisible.isVisible())
        {
            loginnotvisible.setVisible(false);
            loginvisible.setVisible(true);
            logingpasstextfield.setText(loginpassword.getText());
            logingpasstextfield.setVisible(true);
            loginpassword.setVisible(false);
        }
        else
        {
            loginnotvisible.setVisible(true);

            loginvisible.setVisible(false);
            loginpassword.setText(logingpasstextfield.getText());
            loginpassword.setVisible(true);
            logingpasstextfield.setVisible(false);
        }

    }









    //set create button functionality
    public void creataccountbuttononAction(ActionEvent actionEvent) throws Exception {
        //signup
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 740, 624));
        stageee.show();
        Stage stage=(Stage) creataccountbutton.getScene().getWindow();
        stage.close();

    }







    //set Log in button functionality
    public void LoginbuttononAction(javafx.event.ActionEvent actionEvent) throws Exception{

//taking the user input
         boolean datavalidation=false;
  String passwordvalidation=null;
        if(loginnotvisible.isVisible())
        {
            passwordvalidation= loginpassword.getText();

        }
        else
        {
            passwordvalidation= logingpasstextfield.getText();
        }
//read the file that contains the users passwords
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\email-pass.txt"));
            String line;
            String[] takedata = new String[2];
            while((line = reader.readLine()) != null) {
               takedata =line.split(",");
               if(takedata[0].equals(loginusername.getText())&&takedata[1].equals(passwordvalidation))
               {
                   datavalidation=true;
               }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



//check if the password matches our database
if(datavalidation==false)
{
    LoginMessage.setText("Invalid login. Please try again.");
}
//if it matches our database  access granted to the user
        if(datavalidation==true)
        {

            //created  the necessary documents and files to save the user input
            Path path = Paths.get("src\\main\\"+loginusername.getText());
            Files.createDirectories(path);
            Path pathone = Paths.get("src\\main\\"+loginusername.getText()+"\\All");
            Files.createDirectories(pathone);
            Path pathtwo = Paths.get("src\\main\\"+loginusername.getText()+"\\Favorites");
            Files.createDirectories(pathtwo);
            Path paththree = Paths.get("src\\main\\"+loginusername.getText()+"\\Trash");
            Files.createDirectories(paththree);


//checking if the files were created
            try {
                File myObj = new File("src\\main\\"+loginusername.getText()+"\\track.txt");
                if (myObj.createNewFile()) {
                   // System.out.println("File created: " + myObj.getName());
                } else {
                    //System.out.println("File already exists.");
                }
            } catch (IOException e) {
               // System.out.println("An error occurred.");
                e.printStackTrace();
            }
            File file = new File("src\\main\\user.txt");
            if (file.delete()) {
                System.out.println("File deleted successfully");
            }
            else {
                System.out.println("Failed to delete the file");
            }

            try {
                File myObj = new File("src\\main\\user.txt");
                FileWriter writer = new FileWriter("src\\main\\user.txt", true);




                if (myObj.createNewFile()) {
                    // System.out.println("File created: " + myObj.getName());
                } else {
                    //System.out.println("File already exists.");
                }


                writer.write(loginusername.getText());
                writer.close();

            } catch (IOException e) {
                // System.out.println("An error occurred.");
                e.printStackTrace();
            }









// this is for the extra credits but it didn't work bc there was a problem with the compiler library
            if(twoFA.isSelected())
            {


               /* SendEmail firstemail=new SendEmail();

                firstemail.envoyer();
*/
                Mail mail = new Mail();

                mail.setupServerProperties();
                mail.draftEmail();
                mail.sendEmail();

                Stage stageee = new Stage();
                Parent roottt = FXMLLoader.load(getClass().getResource("2FA.fxml"));
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 536, 452));
                stageee.show();
                Stage stage=(Stage) Loginbutton.getScene().getWindow();
                stage.close();
            }
            else
            {
                Stage stageee = new Stage();
                Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 1000, 800));
                stageee.show();
                Stage stage=(Stage) Loginbutton.getScene().getWindow();
                stage.close();

            }



        }










    }


    //set cancel button functionality
    public void LogincancelbuttonAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage) Logincancelbutton.getScene().getWindow();
        stage.close();
    }


}