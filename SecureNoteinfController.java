package sample;
//This controls the Secure Note  form
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class SecureNoteinfController implements Initializable {


    //Displaying my variables
    @FXML
    private Button notesavebutton;

    @FXML
    private Button notecancelbutton;
    @FXML
    private Button notefavrt;

    @FXML
    private ChoiceBox<String> notetypeofitem;

    private String[] itemtype={"Login", "Card", "Identity", "Secure Note"};






    @FXML
    private ChoiceBox<String>  notefolder;

    private String[] folder={"No Folder"};

    @FXML
    private TextField notename;

    @FXML
    private TextArea notetextarea;




    @FXML
    private ImageView starnotvisible;
    @FXML
    private ImageView starvisible;

    ObservableList<Person> listF;
    ObservableList<Person> getProductList(){
        ObservableList<Person> pers = FXCollections.observableArrayList();
        return pers;
    }





    String userName = null;

    //initializing my variables and the form data
     @Override
     public  void initialize(URL arg0, ResourceBundle arg1)
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
        // open the file to read
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\readnote.txt"));
            String line;
            String[] takedata = new String[20];

            while ((line = reader.readLine()) != null) {

                takedata=line.split("#");

                notename.setText(takedata[1]);

                notetextarea.setText(takedata[2]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }








        notetypeofitem.getItems().addAll(itemtype);
        notetypeofitem.setValue("Secure Note");
        notefolder.getItems().addAll(folder);
        notefolder.setValue("No Folder");
//set ChoiceBox functionalities to show a new form everytime we change the data
        notetypeofitem.setOnAction(event -> {
            if(notetypeofitem.getValue().toString().equals("Login"))
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
                Stage stage=(Stage) notetypeofitem.getScene().getWindow();
                stage.close();
            }

            else if(notetypeofitem.getValue().toString().equals("Card"))
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
                Stage stage=(Stage) notetypeofitem.getScene().getWindow();
                stage.close();
            }
            else   if(notetypeofitem.getValue().toString().equals("Identity"))
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
                Stage stage=(Stage) notetypeofitem.getScene().getWindow();
                stage.close();
            }
    });





    }

    // set the function to show button if it is clicked when we add the input to favorite file
    public void notefavrtonAction(ActionEvent actionEvent) throws Exception {
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
    //set cancel button functionality
     public void notecancelbuttononAction(ActionEvent actionEvent) throws Exception {
        //signup
         Stage stageee = new Stage();
         Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
         stageee.initStyle(StageStyle.UNDECORATED);

         stageee.setScene(new Scene(roottt, 1000, 800));
         stageee.show();

        Stage stage=(Stage) notecancelbutton.getScene().getWindow();
        stage.close();

    }


    //set save button functionalities
    public void notesavebuttononAction(ActionEvent actionEvent) throws Exception {

        //saving the data in the right file
        if(!notename.getText().isBlank()) {
            try {
               ;
                File myObj = new File("src\\main\\"+userName+"\\All\\Note," + notename.getText() + ".txt");

                FileWriter writer = new FileWriter("src\\main\\"+userName+"\\All\\Note," + notename.getText() + ".txt", true);

                writer.write(notetypeofitem.getValue().toString());
                writer.write('#');
                writer.write(notename.getText());
                writer.write('#');
                writer.write(notetextarea.getText());
                //writer.write('\n');
                writer.close();



//if the user clicked on add to favorite we will write the data into the right file in the right document
                if (starvisible.isVisible()) {
                    File myObjj = new File("src\\main\\"+userName+"\\Favorites\\Note," + notename.getText() + ".txt");
                    FileWriter writerf = new FileWriter("src\\main\\"+userName+"\\Favorites\\Note," + notename.getText() + ".txt", true);
                    writerf.write(notetypeofitem.getValue().toString());
                    writerf.write('#');
                    writerf.write(notename.getText());
                    writerf.write('#');
                    writerf.write(notetextarea.getText());
                    writerf.write('\n');
                    writerf.close();
                }

// this is used to keep track of users
                FileWriter writertwo = new FileWriter("src\\main\\"+userName+"\\track.txt", true);
                writertwo.write("Note");
                writertwo.write('#');
                writertwo.write(notename.getText());
                writertwo.write('\n');
                writertwo.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        //load new main interface
        Stage stageee = new Stage();
        Parent roottt = FXMLLoader.load(getClass().getResource("mainappInterface.fxml"));
        stageee.initStyle(StageStyle.UNDECORATED);

        stageee.setScene(new Scene(roottt, 1000, 800));
        stageee.show();

        Stage stage=(Stage) notesavebutton.getScene().getWindow();
        stage.close();


    }




}