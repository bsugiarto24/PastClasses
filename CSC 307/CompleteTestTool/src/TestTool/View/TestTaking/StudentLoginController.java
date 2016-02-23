package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.View.Resource.MenuTabController;
import TestTool.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import TestTool.Model.TestTaking.StudentLogin;



/**
 * Created by Dylan on 11/8/15.
 */
public class StudentLoginController {

    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;



    public void setMenutabController(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    @FXML
    public void onTestAttempt() {
        System.out.println("in first attemp");
        try {
            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingTests.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentSubmitTestController controller = loader.getController();
            controller.setStudentLoginController(mainApp);

            StudentLogin.attemptTest(1);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void onTest2Attempt() {

        StudentLogin.attemptTest(2);
    }

    @FXML
    public void onTest3Attempt() {

        StudentLogin.attemptTest(3);
    }
}
