package TestTool.View.TestCreation;

import TestTool.MainApp;
import TestTool.Model.TestCreation.BasicTestCreation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import TestTool.View.TestCreation.*;


/**
 * Created by JonathanTan on 11/20/15.
 */
public class BasicGenController {

    int a;
    private MainApp mainApp;
    @FXML
    private Button backButton;
    @FXML
    private TextField numQuesTF;
    @FXML
    private TextField avgDiffTF;
    @FXML
    private TextField minRangeTF;
    @FXML
    private TextField maxRangeTF;
    @FXML
    private TextField testLengthTF;
    @FXML
    private TextField testNameTF;
    @FXML
    private ComboBox testLengthCB;
    @FXML
    private ComboBox subjectCB;
    @FXML
    private ComboBox courseCB;
    @FXML
    private CheckBox multChoiceCB;
    @FXML
    private CheckBox trueFalseCB;
    @FXML
    private CheckBox freeResponseCB;
    @FXML
    private CheckBox codingCB;
    @FXML
    private CheckBox fillBlankCB;



    public void setMain(MainApp a) {
        mainApp = a;
    }

    public void backToRanMain() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestCreation/GenTest.fxml"));
        AnchorPane ranMa = (AnchorPane) loader.load();

        RanTestController ranTest = loader.getController();
        ranTest.setMain(mainApp);

        // Set new screen into center of root layout
        mainApp.rootLayout.setCenter(ranMa);

        mainApp.primaryStage.show();

    }

    public void basicHandleGen() {
        if(hasErrors()){
            return;
        }
        String name = testNameTF.getText();
        int numQues = Integer.valueOf(numQuesTF.getText());
        int avgDiff = Integer.valueOf(avgDiffTF.getText());
        int minRange = Integer.valueOf(minRangeTF.getText());
        int maxRange = Integer.valueOf(maxRangeTF.getText());
        int testLength = Integer.valueOf(testLengthTF.getText());
        String timeUnit = (String)testLengthCB.getValue();
        String subject = (String)subjectCB.getValue();
        String course = (String)courseCB.getValue();
        boolean multipleChoice = multChoiceCB.isSelected();
        boolean freeResponse = freeResponseCB.isSelected();
        boolean trueFalse = trueFalseCB.isSelected();
        boolean fillInBlank = fillBlankCB.isSelected();
        boolean coding = codingCB.isSelected();

        BasicTestCreation.genBasicTest(name, numQues, avgDiff, minRange, maxRange, testLength, timeUnit, subject, course,
                multipleChoice, freeResponse, trueFalse, fillInBlank, coding);

    }

    private boolean hasErrors(){
        if(testNameTF.getText().isEmpty() ||numQuesTF.getText().isEmpty() || avgDiffTF.getText().isEmpty() ||
                minRangeTF.getText().isEmpty() || testLengthTF.getText().isEmpty() || testNameTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Please Fill All Fields");
            alert.showAndWait();
            return true;
        }
        else if(testLengthCB.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Please Select a Unit of Time");
            alert.showAndWait();
            return true;
        }
        else if(subjectCB.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Please Select a Subject");
            alert.showAndWait();
            return true;
        }
        else if(courseCB.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Please Select a Course");
            alert.showAndWait();
            return true;
        }
        return false;

    }
}