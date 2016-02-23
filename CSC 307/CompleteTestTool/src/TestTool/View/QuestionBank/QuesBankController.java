package TestTool.View.QuestionBank;

import TestTool.MainApp;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.BasicTestCreation;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import TestTool.*;
import javafx.scene.layout.*;
import TestTool.Model.TestCreation.*;

/**
 * Created by JonathanTan on 11/20/15.
 */
public class QuesBankController {

    private MainApp mainApp;

    private FXMLLoader load;
    private AnchorPane curPane;

    public void setMain(MainApp a) {
        mainApp = a;
        load = new FXMLLoader();
    }

    public void backButQuesBank() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

}
