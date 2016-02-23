package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestTaking.StudentTakingTest;
import TestTool.Model.TestTaking.TestTaking;
import TestTool.View.Resource.MenuTabController;
import TestTool.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Node;


/**
 * Created by Dylan on 11/8/15.
 */
public class StudentTakingTestController {

    @FXML
    private TextArea answer1;
    @FXML
    private Button submit;



    FXMLLoader loader = new FXMLLoader();

    public BorderPane rootLayout;
    private int anticipatedAnswerCount = 1;//TestTaking.getTestQuestion().size();

    private MainApp mainApp;


    public void setStudentLoginController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    public void onSubmit() {
        try {

            if (StudentTakingTest.submitTest(StudentLogin.returnTestNum()) == null) {
                submit.requestFocus();
                StudentAnswer.setAnswers(0, answer1.getText());
                loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingSubmit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();

                StudentFinishedScreenController controller = loader.getController();
                controller.setStudentFinishedController(mainApp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}