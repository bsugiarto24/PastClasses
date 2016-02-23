package TestTool.View.QuestionBank;

import TestTool.MainApp;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.BasicTestCreation;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import TestTool.Model.QuestionBank.*;
import javafx.fxml.FXMLLoader;
import TestTool.*;
import javafx.scene.layout.*;
import TestTool.Model.TestCreation.*;
import javafx.scene.control.*;

/**
 * Created by JonathanTan on 11/20/15.
 */
public class QuesBankController {

    private MainApp mainApp;

    private FXMLLoader load;
    private AnchorPane curPane;

    @FXML
    private TextField searchBox;
    @FXML
    private TextField diffNum;
    @FXML
    private ComboBox subjectDD;
    @FXML
    private ComboBox courseDD;
    @FXML
    private ComboBox quesType;
    @FXML
    private TextField quesLen;
    @FXML
    private ComboBox quesLenDD;
    private BankOptions opt;

    boolean alertShown = false;
    boolean quesLenAlert = false;


    public void setMain(MainApp a) {
        mainApp = a;
        load = new FXMLLoader();
        opt = new BankOptions();
    }

    public void searchBoxValue() {
        String boxVal = searchBox.getText();
        opt.setSearch(boxVal);
    }

    public void diffValue() {
        try {
            if (diffNum.getText().length() != 0) {
                int diff = Integer.valueOf(diffNum.getText());
                opt.setDiff(diff);
                alertShown = false;
            }
        }
        catch (NumberFormatException e) {
            if (alertShown == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Creating Test");
                alert.setContentText("Sorry, Invalid input. Please Input an Integer with no spaces");
                alert.showAndWait();
                alertShown = true;
            }
        }
    }

    public void subjValue() {
        String subjVal = (String) subjectDD.getValue();
        opt.setSubj(subjVal);
    }

    public void courseValue() {
        String courseVal = (String) courseDD.getValue();
        opt.setCourse(courseVal);
    }

    public void quesTypeValue() {
        String qT = (String) quesType.getValue();
        opt.setCourse(qT);
    }

    public void quesLenValue() {
        try {
            if (quesLen.getText().length() != 0) {
                int qL = Integer.valueOf(quesLen.getText());
                opt.setQuesLength(qL);
                quesLenAlert = false;
            }
        }
        catch (NumberFormatException e) {
            if (quesLenAlert == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Creating Test");
                alert.setContentText("Sorry, Invalid input. Please input a number");
                alert.showAndWait();
                quesLenAlert = true;
            }
        }
    }

    public void quesLenUnitValue() {
        String qLenUnit = (String) quesLenDD.getValue();
        opt.setQuesLenType(qLenUnit);
    }

    public void backButQuesBank() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

}
