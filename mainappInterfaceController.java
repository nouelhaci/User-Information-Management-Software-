package sample;
//This controls the main interface
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Path;



import static java.nio.file.StandardCopyOption.*;

import static java.nio.file.LinkOption.*;

import java.net.URL;
import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;








//client class
class Client
{
    private AbstractUser AbstractUser;
    private AbstractRoot AbstractRoot;
    private AbstractType AbstractType;

    public Client(AbstractFactoryWidget factory)
    {
        AbstractRoot = factory.CreateScreen();
        AbstractUser = factory.CreateCamera();
        AbstractType = factory.CreateGPU();
    }
    public String Run()
    {
        String take="";
        take=AbstractRoot.DisplayName(AbstractRoot)+ AbstractUser.DisplayName(AbstractUser)+AbstractType.DisplayName(AbstractType);
        /*AbstractRoot.DisplayName(AbstractRoot);
        AbstractUser.DisplayName(AbstractUser);
        AbstractType.DisplayName(AbstractType);*/
        return take;
    }

}








//UserPathLogin
class UserPathLogin extends AbstractUser
{


    @Override
    public String DisplayName(AbstractUser a)
    {
        String userName=null;
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




       // System.out.println(" Camera iPhone 11 ");
        return userName ;
    }
}

//UserPathCard
class UserPathCard extends AbstractUser
{
    @Override public String DisplayName(AbstractUser a)
    {
       // System.out.println(" Camera iPhone 12 " );
        String userName=null;
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




        // System.out.println(" Camera iPhone 11 ");
        return userName ;
    }
}
//UserPathIdentity
class UserPathIdentity extends AbstractUser
{
    @Override public String DisplayName(AbstractUser a)
    {
      //  System.out.println(" Camera iPhone 13 ");
        String userName=null;
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




        // System.out.println(" Camera iPhone 11 ");
        return userName ;
    }
}
//UserPathNote
class UserPathNote extends AbstractUser
{
    @Override public String DisplayName(AbstractUser a)
    {
       // System.out.println(" Camera iPhone 14 ");
        String userName=null;
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




        // System.out.println(" Camera iPhone 11 ");
        return userName ;
    }
}











//RootPathLogin
class RootPathLogin extends AbstractRoot
{
    @Override public String DisplayName(AbstractRoot a)
    {
        return "src\\main\\";
        //System.out.println(" Screen iPhone 11 " );
    }
}
//RootPathCard
class RootPathCard extends AbstractRoot
{

    @Override public String DisplayName(AbstractRoot a)
    {
        return "src\\main\\";
       // System.out.println(" Screen iPhone 12 " );
    }
}
//RootPathIdentity
class RootPathIdentity extends AbstractRoot
{

    @Override public String DisplayName(AbstractRoot a)
    {return "src\\main\\";
      //  System.out.println(" Screen iPhone 13 " );
    }
}
//RootPathNote
class RootPathNote extends AbstractRoot
{

    @Override public String DisplayName(AbstractRoot a)
    {
        return "src\\main\\";
        //System.out.println(" Screen iPhone 14 " );
    }
}






//TypePathLogin
class TypePathLogin extends AbstractType
{
    @Override public String DisplayName(AbstractType a)
    {
        return "\\readlogin.txt";
        //System.out.println(" GPU iPhone 11 " );
    }
}
//TypePathCard
class TypePathCard extends AbstractType
{

    @Override public String DisplayName(AbstractType a)
    {
        return "\\readcard.txt";
      //  System.out.println(" GPU iPhone 12 " );
    }
}
//TypePathIdentity
class TypePathIdentity extends AbstractType
{

    @Override public String DisplayName(AbstractType a)
    {

       return "\\readidentity.txt";

        //System.out.println(" GPU iPhone 13 " );
    }
}
//TypePathNote
class TypePathNote extends AbstractType
{

    @Override public String DisplayName(AbstractType a)
    {
        return "\\readnote.txt";
       // System.out.println(" GPU iPhone 14 " );
    }
}

















//AbstractUser
abstract class AbstractUser
{
    public abstract String DisplayName(AbstractUser a);
}
//AbstractRoot
abstract class AbstractRoot
{
    public abstract String DisplayName(AbstractRoot a);
}
//AbstractType
abstract class AbstractType
{
    public abstract String DisplayName(AbstractType a);
}
//AbstractFactoryWidget
abstract class AbstractFactoryWidget
{

   


    public abstract AbstractUser
    CreateCamera();
    public abstract AbstractRoot
    CreateScreen();
    public abstract AbstractType
    CreateGPU();
}









//ConcreteLogin
class ConcreteLogin extends AbstractFactoryWidget {


    @Override public  AbstractUser CreateCamera() {
        return new UserPathLogin();
    }
    @Override public  AbstractRoot CreateScreen() {
        return new RootPathLogin();
    }
    @Override public  AbstractType CreateGPU() {
        return new TypePathLogin();
    }
}
//ConcreteCard
class ConcreteCard extends AbstractFactoryWidget {


    private static int  ConcreteIphone12_flag= 0;

    @Override public  AbstractUser CreateCamera() {



        return new UserPathCard();
    }
    @Override public  AbstractRoot CreateScreen() {
        return new RootPathCard();
    }
    @Override public  AbstractType CreateGPU() {
        return new TypePathCard();
    }
}
//ConcreteIdentity
class ConcreteIdentity extends AbstractFactoryWidget {
    @Override public  AbstractUser CreateCamera() {
        return new UserPathIdentity();
    }
    @Override public  AbstractRoot CreateScreen() {
        return new RootPathIdentity();
    }
    @Override public  AbstractType CreateGPU() {
        return new TypePathIdentity();
    }
}
//ConcreteNote
class ConcreteNote extends AbstractFactoryWidget {
    @Override public  AbstractUser CreateCamera() {
        return new UserPathNote();
    }
    @Override public  AbstractRoot CreateScreen() {
        return new RootPathNote();
    }
    @Override public  AbstractType CreateGPU() {
        return new TypePathNote();
    }
}






































//FileEngineer
class FileEngineer
{
    // FileEngineer uses a complex series of steps
    public void Construct(FileBuilder FileBuilder)
    {
        String userName = null;
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

        FileBuilder.BuildRootPath();
        FileBuilder.BuilduserPath(userName );
        FileBuilder.BuilFinalPath();
    }
}







// Builder: "FileBuilder"
abstract class FileBuilder
{
    public abstract void BuildRootPath();
    public abstract void BuilduserPath(String i);
    public abstract void BuilFinalPath();
    public abstract Afile GetResult();
}








// Product: "Afile"
class Afile {

    ArrayList parts = new ArrayList();
    public void Add(String part) {
        parts.add(part);
    }
    public String Show() {
      String take = "";
        for (Object part : parts)
            take+=part.toString();

            //System.out.print(part);
        return take;
    }

}




// "All"
class All extends FileBuilder
{
    private Afile afile = new Afile();
    @Override public  void BuildRootPath()
    {
        afile.Add("src\\main\\");
    }
    @Override public  void BuilduserPath(String i)
    {
        afile.Add(i);
    }
    @Override public  void BuilFinalPath()
    {
        afile.Add("\\All");
    }
    @Override  public  Afile GetResult()
    {
        return afile;
    }
}




// "Favorite"
class Favorite extends FileBuilder
{
    private Afile afile = new Afile();
    @Override  public  void BuildRootPath()
    {
        afile.Add("src\\main\\");
    }
    @Override  public  void BuilduserPath(String i)
    {
        afile.Add(i);
    }
    @Override  public  void BuilFinalPath()
    {
        afile.Add("\\Favorites");
    }
    @Override  public  Afile GetResult()
    {
        return afile;
    }
}




// "Trash"
class Trash extends FileBuilder
{
    private Afile afile = new Afile();
    @Override public  void BuildRootPath()
    {
        afile.Add("src\\main\\");
    }
    @Override  public  void BuilduserPath(String i)
    {
        afile.Add(i);
    }
    @Override  public  void BuilFinalPath()
    {
        afile.Add("\\Trash");
    }
    @Override  public  Afile GetResult()
    {
        return afile;
    }
}










public class mainappInterfaceController implements Initializable {









    //Displaying my variables
    @FXML
    private Label alllable;
    @FXML
    private Label trashlable;
    @FXML
    private Label favoratelable;
    @FXML
    private Label loginlabl;
    @FXML
    private Label cardlabl;
    @FXML
    private Label identitylabl;
    @FXML
    private Label notelable;



    @FXML
    private Button allbutton;
    @FXML
    private Button favoritbutton;

    @FXML
    private Button trashbutton;





    @FXML
    private Button addtwo;
    @FXML
    private Button cancelbutton;

    @FXML
    private Button logininf;

    @FXML
    private Button cardinf;

    @FXML
    private Button identityinf;

    @FXML
    private Button noteinf;

    @FXML
    private Button max;

    @FXML
    private Button min;
    @FXML
    private AnchorPane myPane;
    @FXML
    private CheckBox selectall;

   /* @FXML
    private TableView maintable;
    @FXML
    private TableColumn name ,age ,email,actionCol ;*/
    @FXML
    private ChoiceBox choices;
    /* ObservableList <Person> items;
    ObservableList <Person> data;*/

    String id,name,email,notes;
    Button update;


    @FXML
    private ChoiceBox typeschanger;
    @FXML
    private ChoiceBox maincheck;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, CheckBox> selectcolum;

    @FXML
    private TableColumn<Person, String> namecilum;

    @FXML
    private TableColumn<Person, String> typecolum;

    @FXML
    private TableColumn<Person, String> brandcolum;

    @FXML
    private TableColumn<Person, Button> deletecolum;

    @FXML
    private TableColumn<Person, Button> editcolum;



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






  Button  []button=new Button[10];
    Button  []delete=new Button[10];




    ObservableList<Person>items;
    ObservableList<Person>listF;
    ObservableList<Person> getProductList(){
        ObservableList<Person> pers = FXCollections.observableArrayList();
        return pers;
    }
    int indexM = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private String[] choice={"To the Trash", "Select All", "Unselect ALL"};
    private String[] typeschanged={"Login", "Card", "Identity", "Note"};
    private String[] mainchoices={"All", "Favorite", "Trash"};


    String userName = null;


    //initializing my variables and the form data
    @Override
    public void initialize(URL url, ResourceBundle rb) {



















// using Builder Pattern to build the right file path for the right section to load data
        FileEngineer FileEngineer = new FileEngineer();
        FileBuilder allPath= new All();
        FileBuilder favoritePath= new Favorite();
        FileBuilder trashPath= new Trash();
            System.out.println("CHeckintg the path");
        FileEngineer.Construct(allPath);
        FileEngineer.Construct(favoritePath);
        FileEngineer.Construct(trashPath);


        Afile pallPath = allPath.GetResult();

        System.out.println(pallPath.Show());

       Afile pfavoritePath = favoritePath.GetResult();

        System.out.println(pfavoritePath.Show());


        Afile ptrashPath = trashPath.GetResult();

        System.out.println(ptrashPath.Show());



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

       // System.out.println(userName);




// creat a new file for each foem and make sure it is updated every time the app is launched
        File file = new File("src\\main\\"+userName+"\\readcard.txt");
        if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
        File filee = new File("src\\main\\"+userName+"\\readnote.txt");
        if (filee.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
        File fileee = new File("src\\main\\"+userName+"\\readidentity.txt");
        if (fileee.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
        File fileeee = new File("src\\main\\"+userName+"\\readlogin.txt");
        if (fileeee.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }



// set my buttons in the table view
     for(int i=0;i< button.length;i++)
     {
         button[i]=new Button();
         button[i].setOnAction(this::handleButtononAction );
     }

        for(int i=0;i< delete.length;i++)
        {
            delete[i]=new Button();
            delete[i].setOnAction(this::handleDeleteonAction);
        }










// initialize the choice boxes
        choices.getItems().addAll(choice);
        choices.setValue("⚙");
        typeschanger.getItems().addAll(typeschanged);
        typeschanger.setValue("Login");
        maincheck.getItems().addAll(mainchoices);




    maincheck.setValue("All");



        favoratelable.setTextFill(Color.web("Black"));
        trashlable.setTextFill(Color.web("Black"));
        cardlabl.setTextFill(Color.web("Black"));










        selectcolum.setCellValueFactory(new PropertyValueFactory<Person,CheckBox>("Select"));
        namecilum.setCellValueFactory(new PropertyValueFactory<Person,String>("Name"));
        typecolum.setCellValueFactory(new PropertyValueFactory<Person,String>("Type"));
        brandcolum.setCellValueFactory(new PropertyValueFactory<Person,String>("Brand"));
        deletecolum.setCellValueFactory(new PropertyValueFactory<Person,Button>("Delete"));
        editcolum.setCellValueFactory(new PropertyValueFactory<Person,Button>("Edit"));

        //table.setItems(list);
        //initialize my table view
if(maincheck.getValue().toString().equals("All")) {

    table.getItems().clear();
    int count=0;
    File folder = new File("src\\main\\"+userName+"\\All\\");
    File[] listOfFiles = folder.listFiles();

    for (File filet : listOfFiles) {
        if (filet.isFile()) {

                table.setVisible(true);

//loading the data from the right file using  Builder Pattern
            try {
                System.out.println(pallPath.Show()+"\\" +filet.getName());
                BufferedReader readerr = new BufferedReader(new FileReader(pallPath.Show()+"\\"  +filet.getName() ));
                String linee;
                String[] takedataa = new String[20];
                while ((linee = readerr.readLine()) != null) {

                    System.out.println(linee);
                    takedataa = linee.split("#");


                    if (takedataa[0].equals("Note")) {
                        takedataa[0] = "Secure Note";
                    }

                    listF = table.getItems();

                    listF.add(new Person("", takedataa[1], takedataa[0], "MyPass", button[count], delete[count]));


                    table.setItems(listF);

                    count++;
                }
                readerr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



            System.out.println(filet.getName());
        }

    }




}


//set choices functionalities to show a new section everytime we change the data
        choices.setOnAction(event -> {




            items=table.getItems();
            for(Person item : items)
            {
                if(choices.getValue().toString().equals("Select All"))
                {
                    item.getSelect().setSelected(true);
                }
                if(choices.getValue().toString().equals("Unselect ALL"))
                {
                    item.getSelect().setSelected(false);
                }
            }
            if(choices.getValue().toString().equals("To the Trash"))
            {
                ObservableList<Person> dataListRemove= FXCollections.observableArrayList();
                int count=0;
                String manage;
                //updating the data from the right file using  Builder Pattern
                for(Person bean : listF)
                {
                    if(bean.getSelect().isSelected())
                    {
                        dataListRemove.add(bean);

                        if(maincheck.getValue().toString().equals("All")) {

                            if(bean.getType().equals("Secure Note"))
                            {
                                manage="Note";
                            }
                            else
                            {
                                manage=bean.getType().toString();
                            }
                            System.out.println(pallPath.Show()+"\\" +manage+","+bean.getName()+".txt");
                            File fileo = new File(pallPath.Show()+"\\"+manage+","+bean.getName()+".txt");
                            if (fileo.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }

                        }
                        if(maincheck.getValue().toString().equals("Favorite")) {

                            if(bean.getType().equals("Secure Note"))
                            {
                                manage="Note";
                            }
                            else
                            {
                                manage=bean.getType().toString();
                            }
                            System.out.println(pfavoritePath.Show()+"\\"+manage+","+bean.getName()+".txt");
                            File filea = new File(pfavoritePath.Show()+"\\"+manage+","+bean.getName()+".txt");
                            if (filea.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }


                        }
                        if(maincheck.getValue().toString().equals("Trash")) {

                            if(bean.getType().equals("Secure Note"))
                            {
                                manage="Note";
                            }
                            else
                            {
                                manage=bean.getType().toString();
                            }
                            System.out.println(ptrashPath.Show()+"\\"+manage+","+bean.getName()+".txt");
                            File fileb = new File(ptrashPath.Show()+"\\"+manage+","+bean.getName()+".txt");
                            if (fileb.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }


                        }









                    }
                    count++;
                }
                listF.removeAll(dataListRemove);





            }




        });







    }










    Timer timer = new Timer();
// set the timer to close the app due inactivity
    @FXML
    void unlock(MouseEvent event ) throws Exception {

        System.out.println("true");
        timer.cancel();
        timer = new Timer();





    }

    //set choices functionalities to show a new section everytime we change the data using abstract factory pattern
    private void handleButtononAction(ActionEvent event)  {
//using abstract factory pattern to get the right path for each file
        AbstractFactoryWidget FactoryFirst = new ConcreteLogin();
        Client c1 = new Client(FactoryFirst);
        AbstractFactoryWidget FactorySec = new ConcreteCard();
        Client c2 = new Client(FactorySec);
        AbstractFactoryWidget FactoryThird = new ConcreteIdentity();
        Client c3 = new Client(FactoryThird);
        AbstractFactoryWidget FactoryForth = new ConcreteNote();
        Client c4 = new Client(FactoryForth);
// testing if we are getting the right path for each file using abstract factory pattern
        System.out.println("login"+":");
        System.out.println( c1.Run());
        System.out.println("card"+":");
        System.out.println( c2.Run());
        System.out.println("identity"+":");
        System.out.println( c3.Run());
        System.out.println("note"+":");
        System.out.println(  c4.Run());




        if(event.getSource()== button[1])
        {
            System.out.println("pressed");
        }



        int count=0;
        String manage;
        // in All here for each section we are reading and writing the right files using the right path created by abstract factory pattern
        for(Person bean : listF)
        {
            if(event.getSource()== button[count])
            {


                if(maincheck.getValue().toString().equals("All")/*||maincheck.getValue().toString().equals("Trash")||maincheck.getValue().toString().equals("Favorite")*/) {

                    System.out.println("checking"+bean.getType());

                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }
                    if(bean.getType().equals("Secure Note")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\All\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c4.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c4.Run());
                            FileWriter writer = new FileWriter(c4.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 641));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if(bean.getType().equals("Login")) {
                        try {
                            System.out.println("src\\main\\"+userName+"\\All\\" + manage + "," + bean.getName() + ".txt");
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\" + userName +"\\All\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c1.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c1.Run());
                            FileWriter writer = new FileWriter(c1.Run(), true);
                            while ((line = reader.readLine()) != null) {


                                writer.write(line);

                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Logininf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 839));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Identity")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\All\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c3.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c3.Run());
                            FileWriter writer = new FileWriter(c3.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Identityinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 800));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Card")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\" + userName +"\\All\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c2.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c2.Run());
                            FileWriter writer = new FileWriter(c2.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Cardinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 839));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }









                }






                // in Favorite here for each section we are reading and writing the right files using the right path created by abstract factory pattern

                if(maincheck.getValue().toString().equals("Favorite")) {



                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }
                    if(bean.getType().equals("Secure Note")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\" + userName +"\\Favorites\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c4.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c4.Run());
                            FileWriter writer = new FileWriter(c4.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 641));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if(bean.getType().equals("Login")) {
                        try {
                            System.out.println("src\\main\\"+userName+"\\All\\" + manage + "," + bean.getName() + ".txt");
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Favorites\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c1.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c1.Run());
                            FileWriter writer = new FileWriter(c1.Run(), true);
                            while ((line = reader.readLine()) != null) {


                                writer.write(line);

                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Logininf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 839));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Identity")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Favorites\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c3.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c3.Run());
                            FileWriter writer = new FileWriter(c3.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Identityinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 800));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Card")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Favorites\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c2.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c2.Run());
                            FileWriter writer = new FileWriter(c2.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("SUCCESS");
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Cardinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 800));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }







                }
                // in Trash here for each section we are reading and writing the right files using the right path created by abstract factory pattern

                if(maincheck.getValue().toString().equals("Trash")) {


                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }
                    if(bean.getType().equals("Secure Note")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Trash\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c4.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c4.Run());
                            FileWriter writer = new FileWriter(c4.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 641));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if(bean.getType().equals("Login")) {
                        try {
                            System.out.println("src\\main\\"+userName+"\\All\\" + manage + "," + bean.getName() + ".txt");
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Trash\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c1.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c1.Run());
                            FileWriter writer = new FileWriter(c1.Run(), true);
                            while ((line = reader.readLine()) != null) {


                                writer.write(line);

                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Logininf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 839));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Identity")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Trash\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c3.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c3.Run());
                            FileWriter writer = new FileWriter(c3.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Identityinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 800));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bean.getType().equals("Card")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Trash\\" + manage + "," + bean.getName() + ".txt"));
                            String line;
                            String[] takedata = new String[20];
                            File file = new File(c2.Run());
                            if (file.delete()) {
                                System.out.println("File deleted successfully");
                            }
                            else {
                                System.out.println("Failed to delete the file");
                            }
                            File myObj = new File(c2.Run());
                            FileWriter writer = new FileWriter(c2.Run(), true);
                            while ((line = reader.readLine()) != null) {

                                writer.write(line);
                                writer.write('\n');
                                writer.close();
                            }
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            Stage stageee = new Stage();
                            Parent roottt = FXMLLoader.load(getClass().getResource("Cardinf.fxml"));
                            stageee.initStyle(StageStyle.UNDECORATED);

                            stageee.setScene(new Scene(roottt, 908, 839));
                            stageee.show();
                            Stage stage = (Stage) logininf.getScene().getWindow();
                            stage.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }









                }









            }
            count++;
        }











    }















 //set Delet  button functionalities every button will be connected to the right section in the table view
    private void handleDeleteonAction(ActionEvent event)
    {

        ObservableList<Person> dataListRemove= FXCollections.observableArrayList();
        ObservableList<Person> update= FXCollections.observableArrayList();
        int count=0;

        String manage;
        for(Person bean : listF)
        {
            if(event.getSource()== delete[count])
            {


               // dataListRemove.add( new Person("", bean.getName(), bean.getType(), "MyPass", button[x], delete[x]));
              //  x++;
                dataListRemove.add(bean);
//load data to the right section in the table view  in ALL
                if(maincheck.getValue().toString().equals("All")) {

                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }

                    try {

                        Path bytes = Files.copy(

                                new java.io.File("src\\main\\"+userName+"\\All\\"+manage+","+bean.getName()+".txt").toPath(),

                                new java.io.File("src\\main\\"+userName+"\\Trash\\"+manage+","+bean.getName()+".txt").toPath(),

                                REPLACE_EXISTING,

                                COPY_ATTRIBUTES,

                                NOFOLLOW_LINKS);

                        System.out.println("File successfully copied using Java 7 way");



                    } catch (IOException e) {



                        e.printStackTrace();

                    }
                    System.out.println("src\\main\\"+userName+"\\All\\"+manage+","+bean.getName()+".txt");
                    File file = new File("src\\main\\"+userName+"\\All\\"+manage+","+bean.getName()+".txt");
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                    }
                    else {
                        System.out.println("Failed to delete the file");
                    }









                }






//load data to the right section in the table view  in Favorite
                if(maincheck.getValue().toString().equals("Favorite")) {

                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }
                    System.out.println("src\\main\\"+userName+"\\Favorites\\"+manage+","+bean.getName()+".txt");
                    File file = new File("src\\main\\"+userName+"\\Favorites\\"+manage+","+bean.getName()+".txt");
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                    }
                    else {
                        System.out.println("Failed to delete the file");
                    }


                }
                //load data to the right section in the table view  in Trash
                if(maincheck.getValue().toString().equals("Trash")) {

                    if(bean.getType().equals("Secure Note"))
                    {
                        manage="Note";
                    }
                    else
                    {
                        manage=bean.getType().toString();
                    }
                    System.out.println("src\\main\\"+userName+"\\Trash\\"+manage+","+bean.getName()+".txt");
                    File file = new File("src\\main\\"+userName+"\\Trash\\"+manage+","+bean.getName()+".txt");
                    if (file.delete()) {
                        System.out.println("File deleted successfully");
                    }
                    else {
                        System.out.println("Failed to delete the file");
                    }
                    System.out.println("src\\main\\"+userName+"\\Favorites\\"+manage+","+bean.getName()+".txt");
                    File filee = new File("src\\main\\"+userName+"\\Favorites\\"+manage+","+bean.getName()+".txt");
                    if (filee.delete()) {
                        System.out.println("File deleted successfully");
                    }
                    else {
                        System.out.println("Failed to delete the file");
                    }


                }









            }
            count++;
        }
        listF.removeAll(dataListRemove);
        int x=0;
        // update the data base after deleting something
        for(Person bean : listF)
        {

            update.add(new Person("", bean.getName(), bean.getType(), "MyPass", button[x], delete[x]));
            x++;

        }
        listF.setAll(update);


    }













// lock the app after xseconds of inactivity
    @FXML
    void lock(MouseEvent event ) throws Exception {


        System.out.println("false");
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Stage stageee = new Stage();
                    Parent roottt = null;
                    try {
                        roottt = FXMLLoader.load(getClass().getResource("login.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stageee.initStyle(StageStyle.UNDECORATED);
                    stageee.setScene(new Scene(roottt, 536, 452));
                    stageee.show();
                    Stage stage=(Stage) cancelbutton.getScene().getWindow();
                    stage.close();
                });
            }
        }, 500000, 500000000);






    }









    //set add button functionality
    public void additemonaction(ActionEvent actionEvent) throws Exception {
        //signup

// based on each section the user chose this will show the right form
if(typeschanger.getValue().toString().equals("Note")) {


    Stage stageee = new Stage();
    Parent roottt = FXMLLoader.load(getClass().getResource("SecureNoteinf.fxml"));
    stageee.initStyle(StageStyle.UNDECORATED);

    stageee.setScene(new Scene(roottt, 908, 641));
    stageee.show();
    Stage stage=(Stage) logininf.getScene().getWindow();
    stage.close();
}



// based on each section the user chose this will show the right form

        if(typeschanger.getValue().toString().equals("Identity")) {
            Stage stageee = new Stage();
            Parent roottt = FXMLLoader.load(getClass().getResource("Identityinf.fxml"));
            stageee.initStyle(StageStyle.UNDECORATED);

            stageee.setScene(new Scene(roottt, 909, 800));
            stageee.show();
            Stage stage=(Stage) logininf.getScene().getWindow();
            stage.close();
        }

// based on each section the user chose this will show the right form
        if(typeschanger.getValue().toString().equals("Card")) {
            Stage stageee = new Stage();
            Parent roottt = FXMLLoader.load(getClass().getResource("Cardinf.fxml"));
            stageee.initStyle(StageStyle.UNDECORATED);

            stageee.setScene(new Scene(roottt, 905, 839));
            stageee.show();
            Stage stage=(Stage) logininf.getScene().getWindow();
            stage.close();
        }







// based on each section the user chose this will show the right form
        if(typeschanger.getValue().toString().equals("Login")) {
            Stage stageee = new Stage();
            Parent roottt = FXMLLoader.load(getClass().getResource("Logininf.fxml"));
            stageee.initStyle(StageStyle.UNDECORATED);

            stageee.setScene(new Scene(roottt, 905, 839));
            stageee.show();


            Stage stage=(Stage) logininf.getScene().getWindow();
            stage.close();
        }


    }

//if we click on login the color of label will be changed
    public void logininfonAction(ActionEvent actionEvent) throws Exception {
        //signup


        loginlabl.setTextFill(Color.web("White"));
        cardlabl.setTextFill(Color.web("Black"));
        identitylabl.setTextFill(Color.web("Black"));
        notelable.setTextFill(Color.web("Black"));
        typeschanger.setValue("Login");







    }

    //if we click on card the color of label will be changed
    public void cardinfonAction(ActionEvent actionEvent) throws Exception {
        //signup

        loginlabl.setTextFill(Color.web("Black"));
        cardlabl.setTextFill(Color.web("White"));
        identitylabl.setTextFill(Color.web("Black"));
        notelable.setTextFill(Color.web("Black"));
        typeschanger.setValue("Card");



    }


    //if we click on identity the color of label will be changed
    public void identityinfonAction(ActionEvent actionEvent) throws Exception {
        //signup


        loginlabl.setTextFill(Color.web("Black"));
        cardlabl.setTextFill(Color.web("Black"));
        identitylabl.setTextFill(Color.web("White"));
        notelable.setTextFill(Color.web("Black"));

        typeschanger.setValue("Identity");


    }


    //if we click on note the color of label will be changed
    public void noteinfonAction(ActionEvent actionEvent) throws Exception {
        //signup

        loginlabl.setTextFill(Color.web("Black"));
        cardlabl.setTextFill(Color.web("Black"));
        identitylabl.setTextFill(Color.web("Black"));
        notelable.setTextFill(Color.web("White"));
        typeschanger.setValue("Note");


    }

    //if we click on all the color of label will be changed
    public void allonAction(ActionEvent actionEvent) throws Exception {
        //signup

        alllable.setTextFill(Color.web("White"));
        trashlable.setTextFill(Color.web("Black"));

        favoratelable.setTextFill(Color.web("Black"));
        maincheck.setValue("All");
        if(maincheck.getValue().toString().equals("All")) {
            table.getItems().clear();
            int count=0;
            File folder = new File("src\\main\\"+userName+"\\All\\");
            File[] listOfFiles = folder.listFiles();
// load the right data for all section
            for (File filet : listOfFiles) {
                if (filet.isFile()) {

                    table.setVisible(true);


                    try {
                        System.out.println("src\\main\\"+userName+"\\All\\" +filet.getName());
                        BufferedReader readerr = new BufferedReader(new FileReader("src\\main\\"+userName+"\\All\\" +filet.getName() ));
                        String linee;
                        String[] takedataa = new String[20];
                        while ((linee = readerr.readLine()) != null) {

                            System.out.println(linee);
                            takedataa = linee.split("#");


                            if (takedataa[0].equals("Note")) {
                                takedataa[0] = "Secure Note";
                            }

                            listF = table.getItems();

                            listF.add(new Person("", takedataa[1], takedataa[0], "MyPass", button[count], delete[count]));


                            table.setItems(listF);

                            count++;
                        }
                        readerr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    System.out.println(filet.getName());
                }

            }





        }

    }
    //if we click on favorit the color of label will be changed
    public void favoritonAction(ActionEvent actionEvent) throws Exception {
        //signup

        alllable.setTextFill(Color.web("Black"));
        trashlable.setTextFill(Color.web("Black"));

        favoratelable.setTextFill(Color.web("White"));
        maincheck.setValue("Favorite");

// load the right data for all section
        if(maincheck.getValue().toString().equals("Favorite")) {


            table.getItems().clear();
            int count=0;
            File folder = new File("src\\main\\"+userName+"\\Favorites\\");
            File[] listOfFiles = folder.listFiles();

            for (File filet : listOfFiles) {
                if (filet.isFile()) {

                    table.setVisible(true);


                    try {
                        System.out.println("src\\main\\"+userName+"\\All\\" +filet.getName());
                        BufferedReader readerr = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Favorites\\" +filet.getName() ));
                        String linee;
                        String[] takedataa = new String[20];
                        while ((linee = readerr.readLine()) != null) {

                            System.out.println(linee);
                            takedataa = linee.split("#");


                            if (takedataa[0].equals("Note")) {
                                takedataa[0] = "Secure Note";
                            }

                            listF = table.getItems();

                            listF.add(new Person("", takedataa[1], takedataa[0], "MyPass", button[count], delete[count]));


                            table.setItems(listF);

                            count++;
                        }
                        readerr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    System.out.println(filet.getName());
                }

            }












        }


    }
    //if we click on trash the color of label will be changed
    public void trashonaction(ActionEvent actionEvent) throws Exception {
        //signup

        alllable.setTextFill(Color.web("Black"));
        trashlable.setTextFill(Color.web("White"));

        favoratelable.setTextFill(Color.web("Black"));
        maincheck.setValue("Trash");






        if(maincheck.getValue().toString().equals("Trash")) {



            table.getItems().clear();
            int count=0;
            File folder = new File("src\\main\\"+userName+"\\Trash\\");
            File[] listOfFiles = folder.listFiles();
// load the right data for all section
            for (File filet : listOfFiles) {
                if (filet.isFile()) {

                    table.setVisible(true);


                    try {
                        System.out.println("src\\main\\"+userName+"\\All\\" +filet.getName());
                        BufferedReader readerr = new BufferedReader(new FileReader("src\\main\\"+userName+"\\Trash\\" +filet.getName() ));
                        String linee;
                        String[] takedataa = new String[20];
                        while ((linee = readerr.readLine()) != null) {

                            System.out.println(linee);
                            takedataa = linee.split("#");


                            if (takedataa[0].equals("Note")) {
                                takedataa[0] = "Secure Note";
                            }

                            listF = table.getItems();

                            listF.add(new Person("", takedataa[1], takedataa[0], "MyPass", button[count], delete[count]));


                            table.setItems(listF);

                            count++;
                        }
                        readerr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    System.out.println(filet.getName());
                }

            }







        }






    }



    //set cancel button functionality
    public void cancelbuttononAction(ActionEvent actionEvent) {
        Stage stage=(Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }


}