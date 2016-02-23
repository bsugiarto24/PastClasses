package TestTool.View.TestTaking;

import TestTool.MainApp;
import TestTool.Model.TestTaking.StudentFinishedScreen;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestTaking.TestTaking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.*;
import TestTool.Model.QuestionCreation.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.FontWeight;


/**
 * Created by Dylan on 11/9/15.
 */


public class StudentFinishedScreenController {
    @FXML
    private StackPane classTestNamePane;

    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;


    public void setStudentFinishedController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void initialize() {
        Label classTestName = new Label(StudentFinishedScreen.getFinishedScreenTexts());
        classTestName.setFont(Font.font(null, FontWeight.BLACK,35));
        classTestName.setTextFill(Color.BLACK);
        classTestNamePane.getChildren().add(classTestName);

    }


    @FXML
    public void onTakeStudentHome() {
        try {

            System.out.println(StudentLogin.returnTestNum());

            System.out.println("before"+TestTaking.getStudentAssignedTests().size());
            TestTaking.removeTest(StudentLogin.returnTestNum());
            System.out.println("after" + TestTaking.getStudentAssignedTests().size());


            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingLogin.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentLoginController controller = loader.getController();
            controller.setMenutabController(mainApp);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
