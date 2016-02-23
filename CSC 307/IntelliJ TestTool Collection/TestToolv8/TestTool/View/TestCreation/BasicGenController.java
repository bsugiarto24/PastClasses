package TestTool.View.TestCreation;

import TestTool.MainApp;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.BasicTestCreation;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestCreation.TestCreationException;
import TestTool.View.TestBank.TestBankController;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import TestTool.View.TestCreation.*;

import java.util.ArrayList;


/**
 * Created by JonathanTan on 11/20/15.
 */
public class BasicGenController {

    int a;
    private MainApp mainApp;
    @FXML
    private Button backButton;
    @FXML
    private Button generateButton;
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

    public void toTestBank() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestBank/testbank.fxml"));
        AnchorPane ranMa = (AnchorPane) loader.load();

        TestBankController testBank = loader.getController();
        testBank.setMain(mainApp);

        // Set new screen into center of root layout
        mainApp.rootLayout.setCenter(ranMa);

        mainApp.primaryStage.show();

    }

    public void basicHandleGen() {
        if(hasErrors()){
            return;
        }
        generateButton.requestFocus();
        String name = testNameTF.getText();
        int numQues = Integer.valueOf(numQuesTF.getText());
        int avgDiff = Integer.valueOf(avgDiffTF.getText());
        int minRange = Integer.valueOf(minRangeTF.getText());
        int maxRange = Integer.valueOf(maxRangeTF.getText());
        int testLength = Integer.valueOf(testLengthTF.getText());
        String timeUnit = (String)testLengthCB.getValue();
        String subject = (String)subjectCB.getValue();
        String course = (String)courseCB.getValue();
        boolean multipleChoice =
                multChoiceCB.isSelected();
        boolean freeResponse = freeResponseCB.isSelected();
        boolean trueFalse = trueFalseCB.isSelected();
        boolean fillInBlank = fillBlankCB.isSelected();
        boolean coding = codingCB.isSelected();



        try{
            BasicTestCreation.genBasicTest(name, numQues, avgDiff, minRange, maxRange, testLength, timeUnit, subject, course,
                    multipleChoice, freeResponse, trueFalse, fillInBlank, coding);
            toTestBank();
        }
        catch(TestCreationException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Test cannot be created with exisiting parameters");
            alert.showAndWait();
            return;
        }
        catch (Exception e){
            e.printStackTrace();
        }

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
        else if(!multChoiceCB.isSelected() && !freeResponseCB.isSelected() && !fillBlankCB.isSelected()
                && !trueFalseCB.isSelected() && !codingCB.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Creating Test");
            alert.setContentText("Please Select at least one Question Type");
            alert.showAndWait();
            return true;
        }
        return false;

    }


    @FXML
    private void initialize(){
        subjectCB.setItems(FXCollections.observableArrayList(SubjectCollection.getInstance().getAllSubjects()));
        courseCB.setItems(FXCollections.observableArrayList(CourseCollection.getInstance().getAllCourses()));
    }

}
