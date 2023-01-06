package sample;
//This controls the signup  form
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
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
import javafx.scene.Scene;
import javafx.stage.Stage;








abstract class Password
{
    public abstract String GetPass() ;
}



// Concrete Products for NonLetters
class Number extends Password
{
    public  String GetPass()
    {
        return "1234567890" ;
         } }
class Characters extends Password
{
    public String GetPass()
    { return "!@#$"; } }


// Concrete Products for Letters
class UpperLetters extends Password
{
    public String GetPass()
    { return "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; } }
class LowerLetters extends Password
{
    public String GetPass()
    { return "abcdefghijklmnopqrstuvwxyz"; } }


// Abstract Creator
abstract class Word
{
    //  ArrayList Pages = new Arraylist() ;
    public ArrayList<Password> Code = new ArrayList();
    // Constructor calls abstract Factory method
    public Word()
    {
        this.CreatePaasword();
    }

    public abstract void GetWordName() ;



    // Factory Method
    public abstract void CreatePaasword();
}

// First Concrete Creator
class NonLetters extends Word
{
    // Factory Method implementation
    @Override public  void CreatePaasword()
    {
        Code.add(new Number());
        Code.add(new Characters());

    }
    @Override public  void GetWordName()
    { System.out.print("NonLetters"); }
}



// Second Concrete Creator
class Letters extends Word
{
// Factory Method implementation

    @Override public  void CreatePaasword()
    {
        Code.add(new UpperLetters());
        Code.add(new LowerLetters());

    }
    @Override public  void GetWordName()
    { System.out.print("Letters") ;}
}



















public class signupController {

    //Displaying my variables

    @FXML
    private Button creatacount;

    @FXML
    private Button signupcancel;

    @FXML
    private Button signuppasssee;

    @FXML
    private Button signuprepasssee;

    @FXML
    private Button passsegest;

    @FXML
    private Button loginbutton;

    @FXML
    private TextField signupemail;

    @FXML
    private PasswordField signuppassword;
    @FXML
    private TextField signuppasstextfield;


    @FXML
    private TextField signupusername;

    @FXML
    private PasswordField signuprepassword;
    @FXML
    private TextField signuprepasstextfield;




    @FXML
    private Label loginlable;
    @FXML
    private Label repassalert;

    @FXML
    private ImageView passnotvisible;
    @FXML
    private ImageView passvisible;
    @FXML
    private ImageView repassnotvisible;
    @FXML
    private ImageView repassvisible;




    @FXML
    private Label length;
    @FXML
    private Label upper;
    @FXML
    private Label lower;
    @FXML
    private Label special;
    @FXML
    private Label number;


    @FXML
    private Label emailusealert;
    @FXML
    private Label usernameusealert;



//for testing
    public void timingaction(ActionEvent actionEvent) throws Exception{
        //signin


    }







//this function will generate our password using factory pattern
    private static String generatePassword(int length) {

        Word[] words = new Word[2];
        words[0] = new Letters();
        words[1] = new NonLetters();


       int x=0;
        String[] take=new String[4];
//storing the password parts in word string
        for ( Word word : words) {

           // word.GetWordName();
            System.out.println();
            for (Password pass : word.Code)
            {
                take[x]=pass.GetPass();
                System.out.println(pass.GetPass());
                x++;
            }
        }


//taking the stored data and split them by category
        String capitalCaseLetters =take[0]; //"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters =take[1]; //"abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = take[2];//"!@#$";
        String numbers = take[3];//"1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
// mix up the order  eof the password
        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
String pass="";
        for(int i = 0; i< length ; i++) {
           pass+= password[i] ;
        }
        //System.out.println("generatePassword(8)");
        return pass;
    }
  //set  generatePassword label functionality
    public void passsegestonaction(ActionEvent actionEvent) throws Exception{
        //signin

       System.out.println(generatePassword(8));
        signuppassword.setText(generatePassword(8));
        signuppasstextfield.setText(generatePassword(8));
        System.out.println("generatePassword(8)");
    }

    // set see or not see functionality
    public void signuppassseeonAction(ActionEvent actionEvent) throws Exception{


            if(passnotvisible.isVisible())
            {
                passnotvisible.setVisible(false);
                passvisible.setVisible(true);
                signuppasstextfield.setText(signuppassword.getText());
                signuppasstextfield.setVisible(true);
                signuppassword.setVisible(false);
            }
       else
        {
            passnotvisible.setVisible(true);

            passvisible.setVisible(false);
            signuppassword.setText(signuppasstextfield.getText());
            signuppassword.setVisible(true);
            signuppasstextfield.setVisible(false);
        }

    }
    // set see or not see functionality
    public void signuprepassseeonAction(ActionEvent actionEvent) throws Exception{
        if(repassnotvisible.isVisible())
        {
            repassnotvisible.setVisible(false);
           repassvisible.setVisible(true);
            signuprepasstextfield.setText(signuprepassword.getText());
            signuprepasstextfield.setVisible(true);
            signuprepassword.setVisible(false);
        }
        else
        {
            repassnotvisible.setVisible(true);

            repassvisible.setVisible(false);
            signuprepassword.setText(signuprepasstextfield.getText());
            signuprepassword.setVisible(true);
            signuprepasstextfield.setVisible(false);
        }

    }
    // set create account button  functionality
    public void creatacountonAction(ActionEvent actionEvent) throws Exception{

        String passwordvalidation=null;

// take the user password
        if(passnotvisible.isVisible())
        {
            passwordvalidation= signuppassword.getText();

        }
        else
        {
            passwordvalidation= signuppasstextfield.getText();
        }

        String repasswordvalidation=null;


        if(repassnotvisible.isVisible())
        {
            repasswordvalidation= signuprepassword.getText();

        }
        else
        {
            repasswordvalidation= signuprepasstextfield.getText();
        }










        boolean checklength=false;
        boolean checkuppercase=false;
        boolean checklowercase=false;
        boolean checkspecialchar=false;
        boolean checknumber=false;
        boolean all=false;
        int ascii;
       // validate the user input
        if(passwordvalidation.length()>=8)
        {
            checklength=true;
            //System.out.println("check");
        }

        for (int x = 0; x < passwordvalidation.length(); x++) {
            ascii = (int) passwordvalidation.charAt(x);
           // System.out.println(passwordvalidation.charAt(x));
            if (ascii >= 65 && ascii <= 90) {
                checkuppercase = true;
                //System.out.println("checku");
            }
            if (ascii >= 97 && ascii <= 122) {
                checklowercase = true;
               // System.out.println("check;");
            }
            if (ascii >= 33 && ascii <= 47 || ascii >= 58 && ascii <= 63 || ascii >= 123 && ascii <= 126) {
                checkspecialchar = true;
               // System.out.println("checkch");
            }
            if (ascii >= 48 && ascii <= 57) {
                checknumber = true;
               // System.out.println("checknum");
            }


        }

//set gui changes
        if (signupemail.getText().isBlank()==true) {
            emailusealert.setText("You'll use your email address to log in. Missing Email!");
        }
        else {
            emailusealert.setText("You'll use your email address to log in.");
        }if (signupusername.getText().isBlank()==true) {
            usernameusealert.setText("What should we call you? Missing Username!");
        }
        else {
            usernameusealert.setText("What should we call you?");
        }



        // validate the user input
        if (checklength==false) {
            length.setText("❎");
        }
        else {
            length.setText("✅");
        }

        if (checkuppercase==false) {
            upper.setText("❎");
        }
        else {
            upper.setText("✅");

        }
        if (checklowercase==false) {
            lower.setText("❎");        }
        else {
            lower.setText("✅");
        }
        if (checkspecialchar==false) {
            special.setText("❎");       }
        else {
            special.setText("✅");
        }
        if (checknumber==false) {
            number.setText("❎");
        }else {
            number.setText("✅");
        }


        // validate the user input
        if(!passwordvalidation.equals(repasswordvalidation))
        {
            repassalert.setText("Invalid re-entry of password! Try again");
        }
        else {
            repassalert.setText("");
        }

if(checklength==true&& checkuppercase == true&& checklowercase == true&& checkspecialchar == true&& checknumber == true&&signupemail.getText().isBlank()==false
        &&signupusername.getText().isBlank()==false&&passwordvalidation.equals(repasswordvalidation) ) {

    String[] names = {signupemail.getText(), passwordvalidation};
    //if the user input is valid his data will be saved
    try {
        //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\demo\\src\\main\\email-pass.txt"));
        // writer.write("Writing to a file.");
        //  writer.write("\nHere is another line.");
        FileWriter writer = new FileWriter("src\\main\\email-pass.txt", true);
        writer.write(names[0]);
        writer.write(',');
        writer.write(names[1]);
        //writer.write('\n');
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
// open a new stage
    Stage stageee = new Stage();
    Parent roottt = FXMLLoader.load(getClass().getResource("login.fxml"));
    stageee.initStyle(StageStyle.UNDECORATED);

    stageee.setScene(new Scene(roottt, 536, 452));
    stageee.show();
    Stage stage = (Stage) creatacount.getScene().getWindow();
    stage.close();
}


    }


    //set cancel button functionality
    public void signupcancelonAction(ActionEvent actionEvent) {
        Stage stage=(Stage) signupcancel.getScene().getWindow();
        stage.close();


    }
    //set log in button functionality
    public void loginlableonAction(ActionEvent actionEvent) throws Exception{

        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("login.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 536, 452));
        stageee.show();
        Stage stage=(Stage) loginbutton.getScene().getWindow();
        stage.close();
    }













}