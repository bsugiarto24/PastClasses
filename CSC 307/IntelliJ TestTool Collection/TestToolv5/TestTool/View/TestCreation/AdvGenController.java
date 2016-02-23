package TestTool.View.TestCreation;

import TestTool.MainApp;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.AdvTestOption;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Calendar;
import java.util.HashMap;
import TestTool.View.TestBank.TestBankController;
import TestTool.Model.Resource.*;
import java.util.Date;
import TestTool.Model.Resource.*;

/**
 * Created by JonathanTan on 11/20/15.
 */
public class AdvGenController{

    private MainApp mainApp;

    private AnchorPane curPane;
    private ArrayList<AdvTestOption> advOptions;
    private ArrayList<Button> track;

    private int buttonCount = 1;
    private int buttonRemove = 0;



    @FXML
    private TextField testName;
    @FXML
    private TextField testLenVal;
    @FXML
    private ComboBox testLenType;
    @FXML
    private ComboBox course;
    @FXML
    private VBox numQuesVBox;
    @FXML
    private VBox diffVBox;
    @FXML
    private VBox quesTypeVBox;
    @FXML
    private VBox subjVBox;
    @FXML
    private VBox delVBox;
    @FXML
    private VBox stDateVBox;
    @FXML
    private VBox endDateVBox;

    public AdvGenController() {
        track = new ArrayList<>();
        Button temp = new Button();
        temp.setId("remove0");
        track.add(temp);
        advOptions = new ArrayList<>();
    }


    public void setMain(MainApp a) {
        mainApp = a;
        addRow();
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



    public void addRow() {

        Button newButt = new Button("X");
        newButt.setId("remove" + buttonCount++);

        newButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeRow(newButt);
            }
        });
        track.add(newButt);

        delVBox.getChildren().add(newButt);

        TextField newQues = new TextField();
        numQuesVBox.getChildren().add(newQues);

        TextField newDiff = new TextField();
        diffVBox.getChildren().add(newDiff);

        ComboBox<String> newQuesType = new ComboBox<>();
        newQuesType.setPrefWidth(quesTypeVBox.getPrefWidth());
        newQuesType.getItems().addAll("True/False", "Multiple Choice", "Fill In the Blank","Free Response", "Coding");
        quesTypeVBox.getChildren().add(newQuesType);

        ComboBox<String> newSubj = new ComboBox<>();
        newSubj.setPrefWidth(subjVBox.getPrefWidth());
        newSubj.getItems().addAll(SubjectCollection.getInstance().getAllSubjects());
        subjVBox.getChildren().add(newSubj);

        DatePicker start = new DatePicker();
        start.setPrefWidth(stDateVBox.getPrefWidth());
        stDateVBox.getChildren().add(start);

        DatePicker end = new DatePicker();
        end.setPrefWidth(endDateVBox.getPrefWidth());
        endDateVBox.getChildren().add(end);
    }


    //Removes the first row and updates the Arraylist that tracks the numbers
    public void removeRow() {
        track.remove(0);
        delVBox.getChildren().remove(0);
        numQuesVBox.getChildren().remove(0);
        diffVBox.getChildren().remove(0);
        quesTypeVBox.getChildren().remove(0);
        subjVBox.getChildren().remove(0);
        stDateVBox.getChildren().remove(0);
        endDateVBox.getChildren().remove(0);
    }

    public void removeRow(Button a) {
        int num = 0;

        for (int i = 0; i < track.size(); i++) {
            if (track.get(i).getId().equals(a.getId())) {
                num = i;
                break;
            }
        }
        track.remove(num);

        delVBox.getChildren().remove(num);
        numQuesVBox.getChildren().remove(num);
        diffVBox.getChildren().remove(num);
        quesTypeVBox.getChildren().remove(num);
        subjVBox.getChildren().remove(num);
        stDateVBox.getChildren().remove(num);
        endDateVBox.getChildren().remove(num);
    }

    public void advHandleGen() throws Exception {
        if(!hasErrors()){
            String testN = testName.getText();
            int testLV = Integer.valueOf(testLenVal.getText());
            String testLType = (String) testLenType.getValue();
            String cour = (String) course.getValue();
            LocalDate start = null;
            LocalDate end = null;
            int day;
            int month;
            int year;


            for (int i = 0; i < delVBox.getChildren().size(); i ++) {

                TextField numQuesB = (TextField) numQuesVBox.getChildren().get(i);
                int numQues = Integer.valueOf(numQuesB.getText());

                TextField diffB = (TextField) diffVBox.getChildren().get(i);
                int diff = Integer.valueOf(diffB.getText());

                ComboBox quesTypeB = (ComboBox) quesTypeVBox.getChildren().get(i);
                String quesType = (String) quesTypeB.getValue();

                ComboBox subSubjB = (ComboBox) subjVBox.getChildren().get(i);
                String subSubj = (String) subSubjB.getValue();


                /* Adds the start date and creates a local date object */
                DatePicker startDate = (DatePicker) stDateVBox.getChildren().get(i);
                if (startDate.getValue() != null) {
                    day = startDate.getValue().getDayOfMonth();
                    month = startDate.getValue().getMonthValue();
                    year = startDate.getValue().getYear();
                    start = LocalDate.of(year, month, day);
                }

                DatePicker endDate = (DatePicker) endDateVBox.getChildren().get(i);
                if (endDate.getValue() != null) {
                    day = endDate.getValue().getDayOfMonth();
                    month = endDate.getValue().getMonthValue();
                    year = endDate.getValue().getYear();
                    end = LocalDate.of(year, month, day);
                }


                AdvTestOption temp = new AdvTestOption(numQues, diff, quesType, subSubj, start, end);

                advOptions.add(temp);
            }

            AdvancedTestCreation advTest = new AdvancedTestCreation();
            advTest.genAdvTest(testN, testLV, testLType, cour, advOptions);

            FXMLLoader load = new FXMLLoader();
            load.setLocation(MainApp.class.getResource("View/TestBank/testbank.fxml"));

            AnchorPane curPane = (AnchorPane) load.load();
            TestBankController TestBank = load.getController();
            TestBank.setMain(mainApp);

            mainApp.rootLayout.setCenter(curPane);
            mainApp.primaryStage.show();
        }
        else {
            System.out.println("Sorry, could not create test");
        }
    }

    private void alertUser(String a) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Creating Test");
        alert.setContentText(a);
        alert.showAndWait();
    }

    private boolean hasErrors(){

        try {
            if (testName.getText().isEmpty() || testLenVal.getText().isEmpty()) {
                alertUser("Please Fill In All Fields");
                return true;
            }

            if (testLenType.getValue().equals(null) || testLenType.getValue().equals("None") ||
                    course.getValue().equals(null) || course.getValue().equals("None")) {
                alertUser("Please make a selection in all of the DropDown Boxes");
                return true;
            }

            for (int i = 0; i < delVBox.getChildren().size(); i++) {

                TextField numQuesB = (TextField) numQuesVBox.getChildren().get(i);
                int numQues = Integer.valueOf(numQuesB.getText());


                TextField diffB = (TextField) diffVBox.getChildren().get(i);
                int diff = Integer.valueOf(diffB.getText());

                ComboBox quesTypeB = (ComboBox) quesTypeVBox.getChildren().get(i);
                String quesType = (String) quesTypeB.getValue();
                if (quesType.equals(null))
                    throw new Exception();

                ComboBox subjB = (ComboBox) subjVBox.getChildren().get(i);
                String subj = (String) subjB.getValue();
                if (subj.equals(null))
                    throw new Exception();

            }
        }
        catch(Exception e) {
            e.printStackTrace();
            alertUser("Sorry please make sure Test Length, Number Questions, and Difficulty are numbers" +
                    "and Question Type and Sub-Subject are selected");
            return true;
        }


        return false;
    }
}
