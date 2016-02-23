package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.Test;
import TestTool.View.Resource.MenuTabController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by mgolahi on 11/29/15.
 */
public class TestGradingMainController extends MenuTabController {

    private MainApp mainApp;
    final TestBank testBank = TestBank.getInstance();

    public void setMain(MainApp a) {
        mainApp = a;
    }

    @FXML
    public void handleBack() throws Exception {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    public void handleSelect() {
        System.out.println("Inside handleSelect");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Test> getTests() {
        ObservableList<Test> tests = FXCollections.observableArrayList();
        // ACTUAL LOGIC
        for (Test test : testBank.getBank()) {
            tests.add(test);
        }
        return tests;
    }

}
