package TestTool.View.TestCreation;

import TestTool.MainApp;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.BasicTestCreation;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * Created by JonathanTan on 11/20/15.
 */
public class AdvGenController {
    int a;
    private MainApp mainApp;

    private AnchorPane curPane;

    public void setMain(MainApp a) {
        mainApp = a;
    }

    public void backToRanMain() throws Exception {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/TestCreation/GenTest.fxml"));
        curPane = (AnchorPane) load.load();

        RanTestController ranTest = load.getController();
        ranTest.setMain(mainApp);

        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    public void advHandleGen() {
        System.out.println("Advanced");
    }
}
