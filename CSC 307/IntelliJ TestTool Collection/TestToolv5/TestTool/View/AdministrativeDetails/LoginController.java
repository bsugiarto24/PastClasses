package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.InvalidInput;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.Resource.*;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestTaking.TestTaking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private MainApp mainApp;


    @FXML
    private TextField name, pass, name1;

    @FXML
    private Pane namePane;

    @FXML
    private ComboBox<String> userType;

    public void setMainApp(MainApp main){
        mainApp = main;
    }


    @FXML
    public void login() throws IOException{

        String user = name.getText();
        String password = pass.getText();

        System.out.println(user);
        System.out.println(password);

        HashMap<String,User> users = User.getUsers();

        if(name.getText().equals("") || users.get(user) == null) {
            new InvalidInput("Incorrect Username/Password","Please Try Logging In Again");
        }else if(users.get(user).getPassword().equals(password)) {

            User.setUserLoggedIn(users.get(user));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();


            mainApp.rootLayout.getTop().setVisible(true);
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }
        else {
            new InvalidInput("Incorrect Username/Password","Please Try Logging In Again");
        }
    }



    @FXML
    public void register(){
        namePane.setVisible(true);
    }


    @FXML
    public void addUser(){
        String name = name1.getText();
        String password = pass.getText();
        String user = this.name.getText();
        String type = userType.getSelectionModel().getSelectedItem();

        if(name.length() == 0) {
            new InvalidInput("Bad Inputs","Please Enter a name");
        }
        else if(type == null) {
            new InvalidInput("Bad Inputs","Please Select A Type");
        }
        else if(user.length() == 0) {
            new InvalidInput("Bad Inputs","Please Enter a Username");
        }
        else if(User.getUsers().get(user) != null){
            new InvalidInput("Bad Inputs","Login Exists");
        }
        else {
            if(type.equals("TestTaker")){
                TestTaker t = new TestTaker(password, user, name);
            }
            else if(type.equals("TestMaker")){
                TestMaker t = new TestMaker(password, user, name);
            }
            else if(type.equals("TestProctor")){
                TestProctor t = new TestProctor(password, user, name);
            }

            namePane.setVisible(false);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Success");
            a.setContentText("Successfully added User: " + user);
            a.showAndWait();


            this.name.clear();
            pass.clear();
            name1.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> types = FXCollections.observableArrayList("TestTaker", "TestMaker", "TestProctor");

        userType.setItems(types);
        namePane.setVisible(false);
        TestMaker d = new TestMaker("", "admin", "Joe Smith");
        TestTaker t = new TestTaker("", "student", "Bob Smith");
        TestTaker t2 = new TestTaker("", "student2", "Kobe Bryant");

        System.out.println("init");


        /**** init data for courses/ users *******/
        CourseCollection collection = CourseCollection.getInstance();

        Course c1 = new Course("CPE 101");
        c1.addStudent(t);
        c1.addAccessCode("101");
        Subject c = new Subject("C");
        SubjectCollection.getInstance().addSubject(c);
        c1.addSubject(c);
        collection.addCourse(c1);

        Course c2 = new Course("CPE 102");
        c2.addStudent(t2);
        c2.addAccessCode("102");
        Subject java = new Subject("Java");
        SubjectCollection.getInstance().addSubject(java);
        c2.addSubject(java);
        collection.addCourse(c2);

        TestBank tb = TestBank.getInstance();
        Test test = new Test(new ArrayList<Question>(), 1, 1, "C", "Midterm101", "CPE 101");
        Test test2 = new Test(new ArrayList<Question>(), 1, 1, "Java", "Midterm102", "CPE 102");
        tb.add(test);
        tb.add(test2);

    }


}
