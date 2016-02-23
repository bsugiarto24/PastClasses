package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.InvalidInput;
import TestTool.Model.Resource.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private MainApp mainApp;


    @FXML
    private TextField name;
    @FXML
    private TextField pass;


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
            //CourseController handler = loader.getController();
            //handler.setMain(mainApp);
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }
        else {
            new InvalidInput("Incorrect Username/Password","Please Try Logging In Again");
        }
    }



    @FXML
    public void register(){
        System.out.println("registering");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TestMaker d = new TestMaker("123", "admin", "Joe Smith");

        System.out.println("init");
        /**** init data for courses/ users *******/
        CourseCollection collection = CourseCollection.getInstance();
        Course c1 = new Course("CPE 101");
        c1.addSubject(new Subject("C"));
        Course c2 = new Course("CPE 102");
        collection.addCourse(c1);
        collection.addCourse(c2);

    }


}
