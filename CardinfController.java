package sample;
//This controls the card form
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.StageStyle;

import java.util.TimerTask;


public class CardinfController implements Initializable {



//Displaying my variables
    @FXML
    private Button cardsave;

    @FXML
    private Button cardcancel;
    @FXML
    private Button cardfavrt;


    @FXML
    private Button cardcvvcopy;

    @FXML
    private Button cardnumbersee;
    @FXML
    private Button cardnumbercopy;
    @FXML
    private Button cardcvvsee;

    @FXML
    private ChoiceBox carditemtype;





    @FXML
    private ChoiceBox cardfolder;


    @FXML
    private ChoiceBox cardexpmonth;


    @FXML
    private ChoiceBox cardbrand;
    @FXML
    private TextField cardname;

    @FXML
    private TextField cardholdername;

    @FXML
    private TextField cardeexpyear;

    @FXML
    private TextArea cardnote;

    @FXML
    private PasswordField cardnumber;
    @FXML
    private TextField cardnametextfield;
    @FXML
    private ImageView cardnumbernotseeimg;
    @FXML
    private ImageView cardnumberseeimg;

    @FXML
    private PasswordField cardcvv;
    @FXML
    private TextField cardcvvtextfield;
    @FXML
    private ImageView cardcvvnotseeimg;
    @FXML
    private ImageView cardcvvseeimg;



    @FXML
    private ImageView favnotvisible;
    @FXML
    private ImageView favvisible;
    Timer timer = new Timer();
    @FXML
    void stop(MouseEvent event) {







}








    private String[] itemtype={"Login", "Card", "Identity", "Secure Note"};
    private String[] folder={"No Folder"};
    private String[] months={"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private String[] brand={"Visa", "Mastercard", "American Express", "Discover", "Diners Club", "JCB",
            "Maestro", "UnionPay", "RuPay", "Mir", "Other"};
    String userName = null;

    //initializing my variables and the form data
    @Override
    public  void initialize(URL arg1, ResourceBundle arg2)
    {


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







        cardbrand.getItems().addAll(brand);
        cardbrand.setValue("--Select--");
        cardexpmonth.getItems().addAll(months);
        cardexpmonth.setValue("--Select--");
       try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\readcard.txt"));
            String line;
            String[] takedata = new String[20];

            while ((line = reader.readLine()) != null) {

                takedata=line.split("#");
                cardname.setText(takedata[1]);
                cardholdername.setText(takedata[2]);


                if(!takedata[3].isBlank())
                {
                    cardbrand.setValue(takedata[3]);
                }
                else
                {
                    cardbrand.setValue("--Select--");
                }




                cardnumber.setText(takedata[4]);
                cardnametextfield.setText(takedata[4]);

                if(!takedata[5].isBlank())
                {
                    cardexpmonth.setValue(takedata[5]);
                }
                else
                {
                    cardexpmonth.setValue("--Select--");
                }




                cardeexpyear.setText(takedata[6]);

                cardcvv.setText(takedata[7]);
                cardcvvtextfield.setText(takedata[7]);

               cardnote.setText(takedata[8]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }







        carditemtype.getItems().addAll(itemtype);
        carditemtype.setValue("Card");
        cardfolder.getItems().addAll(folder);
        cardfolder.setValue("No Folder");



//set ChoiceBox functionalities to show a new form everytime we change the data
        carditemtype.setOnAction(event -> {
            if(carditemtype.getValue().toString().equals("Login"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("Logininf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 905, 839));
                stageee.show();
                Stage stage=(Stage) carditemtype.getScene().getWindow();
                stage.close();
            }

            else if(carditemtype.getValue().toString().equals("Secure Note"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 908, 641));
                stageee.show();
                Stage stage=(Stage) carditemtype.getScene().getWindow();
                stage.close();
            }
            else   if(carditemtype.getValue().toString().equals("Identity"))
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
                Stage stage=(Stage) carditemtype.getScene().getWindow();
                stage.close();
            }
        });






    }












// set the function to show button if it is clicked when we add the input to favorite file
    public void cardfavrtonAction(ActionEvent actionEvent) throws Exception {

        if(!favnotvisible.isVisible())
        {
            favnotvisible.setVisible(true);
        }
        else if(favnotvisible.isVisible())
        {
            favnotvisible.setVisible(false);

        }
        if(!favvisible.isVisible())
        {
            favvisible.setVisible(true);
        }
        else if(favvisible.isVisible())
        {
            favvisible.setVisible(false);

        }


    }

    //set save button functionalities
    public void cardsaveonAction(ActionEvent actionEvent) throws Exception {
        //signup

if(!cardname.getText().isBlank()) {

    //saving the data in the right file
    try {
        File myObj = new File("src\\main\\"+userName+"\\All\\Card," + cardname.getText() + ".txt");

        FileWriter writer = new FileWriter("src\\main\\"+userName+"\\All\\Card," + cardname.getText() + ".txt", true);

       writer.write(carditemtype.getValue().toString());
       System.out.println(carditemtype.getValue().toString());
       writer.write('#');
        writer.write(cardname.getText());
        System.out.println(cardname.getText());
        writer.write('#');
        writer.write(cardholdername.getText());
        System.out.println(cardholdername.getText());
        writer.write('#');
        writer.write(cardbrand.getValue().toString());
        System.out.println(cardbrand.getValue().toString());
        writer.write('#');


        String number = null;
        if (cardnumbernotseeimg.isVisible()) {
            number = cardnumber.getText();

        } else {
            number = cardnametextfield.getText();
        }


        writer.write(number);
        System.out.println(number);
        writer.write('#');
        writer.write(cardexpmonth.getValue().toString());
        System.out.println(cardexpmonth.getValue().toString());
        writer.write('#');
        writer.write(cardeexpyear.getText());
        System.out.println(cardeexpyear.getText());
        writer.write('#');

        String cvv = null;
        if (cardcvvnotseeimg.isVisible()) {
            cvv = cardcvv.getText();

        } else {
            cvv = cardcvvtextfield.getText();
        }


        writer.write(cvv);
        System.out.println(cvv);
        writer.write('#');
        writer.write(cardnote.getText());
        System.out.println(cardnote.getText());

        writer.close();






    } catch (
            IOException e) {

        e.printStackTrace();
    }
    //if the user clicked on add to favorite we will write the data into the right file in the right document
    if (favvisible.isVisible()) {
        try {
            File myObj = new File("src\\main\\"+userName+"\\Favorites\\Card," + cardname.getText() + ".txt");
       FileWriter writerf = new FileWriter("src\\main\\"+userName+"\\Favorites\\Card," + cardname.getText() + ".txt", true);
           writerf.write(carditemtype.getValue().toString());

            writerf.write('#');
            writerf.write(cardname.getText());
            System.out.println(cardname.getText());
            writerf.write('#');
            writerf.write(cardholdername.getText());
            System.out.println(cardholdername.getText());
            writerf.write('#');
            writerf.write(cardbrand.getValue().toString());
            System.out.println(cardbrand.getValue().toString());
            writerf.write('#');


            String number = null;
            if (cardnumbernotseeimg.isVisible()) {
                number = cardnumber.getText();

            } else {
                number = cardnametextfield.getText();
            }


            writerf.write(number);
            System.out.println(number);
            writerf.write('#');
            writerf.write(cardexpmonth.getValue().toString());
            System.out.println(cardexpmonth.getValue().toString());
            writerf.write('#');
            writerf.write(cardeexpyear.getText());
            System.out.println(cardeexpyear.getText());
            writerf.write('#');

            String cvv = null;
            if (cardcvvnotseeimg.isVisible()) {
                cvv = cardcvv.getText();

            } else {
                cvv = cardcvvtextfield.getText();
            }


            writerf.write(cvv);
            System.out.println(cvv);
            writerf.write('#');
            writerf.write(cardnote.getText());
            System.out.println(cardnote.getText());
            writerf.close();
        } catch (
                IOException e) {

            e.printStackTrace();
        }
    }
try
// this is used to keep track of users
{
    FileWriter writertwo = new FileWriter("src\\main\\"+userName+"\\track.txt", true);
    writertwo.write("Card");
    writertwo.write('#');
    writertwo.write(cardname.getText());
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
        Stage stage=(Stage) cardsave.getScene().getWindow();
        stage.close();

    }


//set cancel button functionality
    public void cardcancelonAction(ActionEvent actionEvent) throws Exception {

        //close the form interface and load the new one
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 1000, 800));
        stageee.show();
        Stage stage=(Stage) cardcancel.getScene().getWindow();
        stage.close();

    }


    //set copy button functionality
    public void cardcvvcopyonAction(ActionEvent actionEvent) throws Exception {

        String str=new String();
        if(cardcvvnotseeimg.isVisible())
        {
            str = cardcvv.getText();

        }
        else {
            str = cardcvvtextfield.getText();
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


// set see or not see functionality
    public void cardnumberseeonAction(ActionEvent actionEvent) throws Exception {

        if(cardnumbernotseeimg.isVisible())
        {
            cardnumbernotseeimg.setVisible(false);
            cardnumberseeimg.setVisible(true);
            cardnametextfield.setText(cardnumber.getText());
            cardnametextfield.setVisible(true);
            cardnumber.setVisible(false);
        }
        else
        {
            cardnumbernotseeimg.setVisible(true);

            cardnumberseeimg.setVisible(false);
            cardnumber.setText(cardnametextfield.getText());
            cardnumber.setVisible(true);
            cardnametextfield.setVisible(false);
        }


    }

  //set copy button functionality
    public void cardnumbercopyonAction(ActionEvent actionEvent) throws Exception {

        String str=new String();
        if(cardnumbernotseeimg.isVisible())
        {
            str = cardnumber.getText();

        }
        else {
            str = cardnametextfield.getText();
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

    // set see or not see functionality
    public void cardcvvseeonAction(ActionEvent actionEvent) throws Exception {

        if(cardcvvnotseeimg.isVisible())
        {
            cardcvvnotseeimg.setVisible(false);
            cardcvvseeimg.setVisible(true);
            cardcvvtextfield.setText(cardcvv.getText());
            cardcvvtextfield.setVisible(true);
            cardcvv.setVisible(false);
        }
        else
        {
            cardcvvnotseeimg.setVisible(true);

            cardcvvseeimg.setVisible(false);
            cardcvv.setText(cardcvvtextfield.getText());
            cardcvv.setVisible(true);
            cardcvvtextfield.setVisible(false);
        }


    }




}