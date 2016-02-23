package TestTool.View.TestTaking;

import TestTool.Model.TestTaking.StudentLogin;
import TestTool.View.Resource.MenuTabController;
import TestTool.Model.TestTaking.StudentFinishedScreen;
import TestTool.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Created by Dylan on 11/9/15.
 */
public class StudentFinishedScreenController {

    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;


    public void setStudentFinishedController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    public void onTakeStudentHome() {
        try {
            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingLogin.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentLoginController controller = loader.getController();
            controller.setMenutabController(mainApp);

            StudentFinishedScreen.takeStudentToHomeScreen();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
