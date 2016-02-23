package TestTool.View.TestCreation;

import javafx.fxml.FXMLLoader;
import TestTool.*;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import TestTool.Model.TestCreation.*;
import TestTool.View.Resource.*;

import TestTool.*;

public class RanTestController {

    int a;
    private MainApp mainApp;

    public void setMain(MainApp a) {
        mainApp = a;
    }

    public void backBut() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    public void goToAdvanced() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/TestCreation/advGen.fxml"));

        AnchorPane curPane = (AnchorPane) load.load();
        AdvGenController AGC = load.getController();
        AGC.setMain(mainApp);

        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    public void goToBasic() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestCreation/basicGen.fxml"));
        AnchorPane curPane = (AnchorPane) loader.load();

        BasicGenController BGC = loader.getController();
        BGC.setMain(mainApp);

        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }
}