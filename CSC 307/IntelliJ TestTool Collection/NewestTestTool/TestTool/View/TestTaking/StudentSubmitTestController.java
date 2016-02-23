package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.StudentTakingTest;
import TestTool.View.Resource.MenuTabController;
import TestTool.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


/**
 * Created by Dylan on 11/8/15.
 */
public class StudentSubmitTestController {

    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;


    public void setStudentLoginController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    public void onSubmit() {
        try {
            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingSubmit.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentFinishedScreenController controller = loader.getController();
            controller.setStudentFinishedController(mainApp);
            StudentTakingTest.submitTest(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}