package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.InvalidInput;
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

        if(name.getText().equals("")) {
            new InvalidInput("Incorrect Username/Password","Please Try Logging In Again");
        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/CourseView.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            CourseController handler = loader.getController();
            handler.setMain(mainApp);
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {}


}
