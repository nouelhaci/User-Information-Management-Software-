package sample;
//This controls the Identity form
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class IdentityinfController implements Initializable{

    //Displaying my variables
    @FXML
    private ChoiceBox itemtype;
    @FXML
    private ChoiceBox identityfolder;
    @FXML
    private ChoiceBox identitytitle;




    @FXML
    private Button cancelbutton;
    @FXML
    private Button identitysave;
    @FXML
    private Button favrtbutton;

    @FXML
    private ImageView userimagnotsee;
    @FXML
    private ImageView ssnimagnotsee;
    @FXML
    private ImageView starnotvisible;
    @FXML
    private ImageView starvisible;


    @FXML
    private ImageView pasportnotsee;
    @FXML
    private ImageView licensenotsee;


    @FXML
    private ImageView userimagesee;
    @FXML
    private ImageView ssnimagsee;

    @FXML
    private ImageView pasportsee;
    @FXML
    private ImageView licensimgsee;





    @FXML
    private Button userwatch;
    @FXML
    private Button ssnwatch;
    @FXML
    private Button passportwatch;
    @FXML
    private Button licensewatch;



    @FXML
    private TextField usertxt;

    @FXML
    private TextField ssntxt;

    @FXML
    private TextField passporttext;

    @FXML
    private TextField licensetext;



    @FXML
    private TextField identityname;

    @FXML
    private TextField identityfirstname;

    @FXML
    private TextField identitymiddlename;

    @FXML
    private TextField identitylastname;
    @FXML
    private TextField identitycompany;

    @FXML
    private TextField identityemail;

    @FXML
    private TextField identityphone;

    @FXML
    private TextField identityaddressone;
    @FXML
    private TextField identityaddresstwo;

    @FXML
    private TextField identityaddressthree;

    @FXML
    private TextField identitycity;

    @FXML
    private TextField identitystate;
    @FXML
    private TextField identityzip;

    @FXML
    private TextField identitycountry;

   @FXML
    private PasswordField usermask;

    @FXML
    private PasswordField ssnmask;
    @FXML
    private PasswordField passportmask;

    @FXML
    private PasswordField licensmask;

    @FXML
    private TextArea identitynote;














    private String[] itemtypee={"Login", "Card", "Identity", "Secure Note"};
    private String[] folder={"No Folder"};

    private String[] title={"Mr", "Mrs", "Ms", "Dr"};



    String userName = null;
    //initializing my variables and the form data
    @Override
    public  void initialize(URL arg3, ResourceBundle arg4)
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






        identitytitle.getItems().addAll(title);
        identitytitle.setValue("--Select--");
        // open the file to read
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\readidentity.txt"));
            String line;
            String[] takedata = new String[20];

            while ((line = reader.readLine()) != null) {

                takedata=line.split("#");
               identityname.setText(takedata[1]);
if(!takedata[2].isBlank())
{
    identitytitle.setValue(takedata[2]);
}
      else
{

    identitytitle.setValue("--Select--");
}





                identityfirstname.setText(takedata[3]);

                identitymiddlename.setText(takedata[4]);


                identitylastname.setText(takedata[5]);

                usermask.setText(takedata[6]);
                usertxt.setText(takedata[6]);

                identitycompany.setText(takedata[7]);


                ssnmask.setText(takedata[8]);
                ssntxt.setText(takedata[8]);

                passportmask.setText(takedata[9]);
                passporttext.setText(takedata[9]);

                licensmask.setText(takedata[10]);
                licensetext.setText(takedata[10]);


                identityemail.setText(takedata[11]);
                identityphone.setText(takedata[12]);
                identityaddressone.setText(takedata[13]);
                identityaddresstwo.setText(takedata[14]);
                identityaddressthree.setText(takedata[15]);
                identitycity.setText(takedata[16]);
                identitystate.setText(takedata[17]);
                identityzip.setText(takedata[18]);
                identitycountry.setText(takedata[19]);

                identitynote.setText(takedata[20]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }












        itemtype.getItems().addAll(itemtypee);
        itemtype.setValue("Identity");
        identityfolder.getItems().addAll(folder);
        identityfolder.setValue("No Folder");


//set ChoiceBox functionalities to show a new form everytime we change the data
        itemtype.setOnAction(event -> {
            if(itemtype.getValue().toString().equals("Login"))
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
                Stage stage=(Stage) itemtype.getScene().getWindow();
                stage.close();
            }

            else if(itemtype.getValue().toString().equals("Card"))
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
                Stage stage=(Stage) itemtype.getScene().getWindow();
                stage.close();
            }
            else   if(itemtype.getValue().toString().equals("Secure Note"))
            {
                Stage stageee = new Stage();
                Parent roottt = null;
                try {
                    roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stageee.initStyle(StageStyle.UNDECORATED);

                stageee.setScene(new Scene(roottt, 909, 641));
                stageee.show();
                Stage stage=(Stage) itemtype.getScene().getWindow();
                stage.close();
            }
        });






    }


    // set the function to show button if it is clicked when we add the input to favorite file
    public void identityfavrtonAction(ActionEvent actionEvent) throws Exception {
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
    // set the function to show button if it is clicked when we add the input to favorite file
    public void userwatchonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(userimagnotsee.isVisible())
        {
            userimagnotsee.setVisible(false);
            userimagesee.setVisible(true);
            usertxt.setText(usermask.getText());
            usertxt.setVisible(true);
            usermask.setVisible(false);
        }
        else
        {
            userimagnotsee.setVisible(true);

            userimagesee.setVisible(false);
            usermask.setText(usertxt.getText());
            usermask.setVisible(true);
            usertxt.setVisible(false);
        }


    }


    // set the function to show button if it is clicked when we add the input to favorite file
    public void ssnwatchonAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(ssnimagnotsee.isVisible())
        {
            ssnimagnotsee.setVisible(false);
            ssnimagsee.setVisible(true);
            ssntxt.setText(ssnmask.getText());
            ssntxt.setVisible(true);
            ssnmask.setVisible(false);
        }
        else
        {
            ssnimagnotsee.setVisible(true);

            ssnimagsee.setVisible(false);
            ssnmask.setText(ssntxt.getText());
            ssnmask.setVisible(true);
            ssntxt.setVisible(false);
        }


    }


    // set the function to show button if it is clicked when we add the input to favorite file
    public void passportwatchAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(pasportnotsee.isVisible())
        {
            pasportnotsee.setVisible(false);
            pasportsee.setVisible(true);
            passporttext.setText(passportmask.getText());
            passporttext.setVisible(true);
            passportmask.setVisible(false);
        }
        else
        {
            pasportnotsee.setVisible(true);

            pasportsee.setVisible(false);
            passportmask.setText(passporttext.getText());
            passportmask.setVisible(true);
            passporttext.setVisible(false);
        }


    }


    // set the function to show button if it is clicked when we add the input to favorite file
    public void licensewatchAction(ActionEvent actionEvent) throws Exception {
        //signup
        if(licensenotsee.isVisible())
        {
            licensenotsee.setVisible(false);
            licensimgsee.setVisible(true);
            licensetext.setText(licensmask.getText());
            licensetext.setVisible(true);
            licensmask.setVisible(false);
        }
        else
        {
            licensenotsee.setVisible(true);

            licensimgsee.setVisible(false);
            licensmask.setText(licensetext.getText());
            licensmask.setVisible(true);
            licensetext.setVisible(false);
        }


    }

    //set cancel button functionality
    public void cancelbuttononAction(ActionEvent actionEvent) throws IOException {

        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 1000, 800));
        stageee.show();

        Stage stage=(Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }


    public void cardsaveonAction(ActionEvent actionEvent) throws Exception {

        //saving the data in the right file
        if(!identityname.getText().isBlank()) {
            try {
                File myObj = new File("src\\main\\"+userName+"\\All\\Identity," + identityname.getText() + ".txt");

                FileWriter writer = new FileWriter("src\\main\\"+userName+"\\All\\Identity," + identityname.getText() + ".txt", true);

              writer.write(itemtype.getValue().toString());
                writer.write('#');
                writer.write(identityname.getText());
                writer.write('#');



                writer.write(identitytitle.getValue().toString());

                writer.write('#');
                writer.write(identityfirstname.getText());
                writer.write('#');
                writer.write(identitymiddlename.getText());
                writer.write('#');
                writer.write(identitylastname.getText());
                writer.write('#');


                String username = null;
                if (userimagnotsee.isVisible()) {
                    username = usermask.getText();

                } else {
                    username = usertxt.getText();
                }
                writer.write(username);
                writer.write('#');
                writer.write(identitycompany.getText());


                writer.write('#');
                String ssn = null;
                if (ssnimagnotsee.isVisible()) {
                    ssn = ssnmask.getText();

                } else {
                    ssn = ssntxt.getText();
                }
                writer.write(ssn);


                writer.write('#');
                String pasport = null;
                if (pasportnotsee.isVisible()) {
                    pasport = passportmask.getText();

                } else {
                    pasport = passporttext.getText();
                }
                writer.write(pasport);


                writer.write('#');
                String license = null;
                if (licensenotsee.isVisible()) {
                    license = licensmask.getText();

                } else {
                    license = licensetext.getText();
                }
                writer.write(license);


                writer.write('#');
                writer.write(identityemail.getText());
                writer.write('#');
                writer.write(identityphone.getText());

                writer.write('#');
                writer.write(identityaddressone.getText());
                writer.write('#');
                writer.write(identityaddresstwo.getText());

                writer.write('#');
                writer.write(identityaddressthree.getText());
                writer.write('#');
                writer.write(identitycity.getText());

                writer.write('#');
                writer.write(identitystate.getText());
                writer.write('#');
                writer.write(identityzip.getText());
                writer.write('#');
                writer.write(identitycountry.getText());
                writer.write('#');
                writer.write(identitynote.getText());

                writer.close();
//if the user clicked on add to favorite we will write the data into the right file in the right document
                if (starvisible.isVisible()) {

                    File myObjj = new File("src\\main\\"+userName+"\\Favorites\\Identity," + identityname.getText() + ".txt");
                    FileWriter writerf = new FileWriter("src\\main\\"+userName+"\\Favorites\\Identity," + identityname.getText() + ".txt", true);
                    writerf.write(itemtype.getValue().toString());
                    writerf.write('#');
                    writerf.write(identityname.getText());
                    writerf.write('#');
                    writerf.write(identitytitle.getValue().toString());

                    writerf.write('#');
                    writerf.write(identityfirstname.getText());
                    writerf.write('#');
                    writerf.write(identitymiddlename.getText());
                    writerf.write('#');
                    writerf.write(identitylastname.getText());
                    writerf.write('#');


                    writerf.write(username);
                    writerf.write('#');
                    writerf.write(identitycompany.getText());


                    writerf.write('#');

                    writerf.write(ssn);


                    writerf.write('#');

                    writerf.write(pasport);


                    writerf.write('#');

                    writerf.write(license);


                    writerf.write('#');
                    writerf.write(identityemail.getText());
                    writerf.write('#');
                    writerf.write(identityphone.getText());

                    writerf.write('#');
                    writerf.write(identityaddressone.getText());
                    writerf.write('#');
                    writerf.write(identityaddresstwo.getText());

                    writerf.write('#');
                    writerf.write(identityaddressthree.getText());
                    writerf.write('#');
                    writerf.write(identitycity.getText());

                    writerf.write('#');
                    writerf.write(identitystate.getText());
                    writerf.write('#');
                    writerf.write(identityzip.getText());
                    writerf.write('#');
                    writerf.write(identitycountry.getText());
                    writerf.write('#');
                    writerf.write(identitynote.getText());


                    //writer.write('\n');
                    writerf.close();
                }

// this is used to keep track of users
                FileWriter writertwo = new FileWriter("src\\main\\"+userName+"\\track.txt", true);
                writertwo.write("Identity");
                writertwo.write('#');
                writertwo.write(identityname.getText());
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
        Stage stage=(Stage) identitysave.getScene().getWindow();
        stage.close();

    }

}