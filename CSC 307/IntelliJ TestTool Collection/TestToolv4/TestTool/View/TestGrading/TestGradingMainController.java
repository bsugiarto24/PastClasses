package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.*;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestGrading.DummyData;
import TestTool.Model.TestGrading.Status;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mgolahi on 11/29/15.
 */
public class TestGradingMainController {

    @FXML
    private TableView<ActiveTest> testTable;
    @FXML
    private TextField testName;
    @FXML
    private ComboBox<String> courseBox;
    @FXML
    private ComboBox<String> subjectBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> statusBox;
    @FXML
    private TableColumn<ActiveTest, String> nameColumn;
    @FXML
    private TableColumn<ActiveTest, Course> courseColumn;
    @FXML
    private TableColumn<ActiveTest, Subject> subjectColumn;
    @FXML
    private TableColumn<ActiveTest, LocalDate> dateTakenColumn;
    @FXML
    private TableColumn<ActiveTest, Integer> difficultyColumn;
    @FXML
    private TableColumn<ActiveTest, Status> statusColumn;

    private MainApp mainApp;
    final ActiveTestBank activeTestBank = ActiveTestBank.getInstance();

    public void setMain(MainApp a) {
        mainApp = a;
    }

    @FXML
    private void initialize() {
        initializeTests();
        initializeSubjects();
        initializeCourses();
        initializeStatuses();
    }

    @FXML
    private void handleBack() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    private void handleSelect() throws Exception {
        ActiveTest test = testTable.getSelectionModel().getSelectedItem();
        if (test != null) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/TestGradingIndividual.fxml"));
            loader.setControllerFactory((cf) -> {
                return new TestGradingIndividualController(mainApp, test);
            });
            AnchorPane curPane = loader.load();
            mainApp.rootLayout.setCenter(curPane);
            mainApp.primaryStage.show();
        }
    }

    private void initializeTests() {
        //TODO: replace the dummy data with a getAllTestsFromBank() call
//        setTests(activeTestBank.getBank());
        setTests(DummyData.getInstance());
    }

    private void setTests(ArrayList<ActiveTest> tests) {
        ObservableList<ActiveTest> testList = FXCollections.observableArrayList();
        tests.forEach(testList::add);
        //Set the table's items
        testTable.setItems(testList);

        //Set the table's columns
        nameColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getTest().getName());
        });
        courseColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getTest().getCourse());
        });
        subjectColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getTest().getSubject());
        });
        dateTakenColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getDate());
        });
        difficultyColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getTest().getDifficulty());
        });
        statusColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getStatus());
        });
    }

    private void initializeSubjects() {
        subjectBox.setItems(FXCollections.observableArrayList("-None-", "Algorithms", "Fundamentals", "Dynamic", "Poops", "-Add Subject--"));
    }

    private void initializeCourses() {
        courseBox.setItems(FXCollections.observableArrayList(CourseCollection.getInstance().getAllCourses()));
        courseBox.setItems(FXCollections.observableArrayList("-None-", "100", "101", "103", "357", "-Add Course--"));
    }

    private void initializeStatuses() {
        statusBox.setItems(FXCollections.observableArrayList("-None-", "Not Started", "In Progress", "Complete"));
    }

    @FXML
    private void filter() {
        ArrayList<Test> tests = new ArrayList<>();
        tests.add(new Test(null, 5, 5, "Algorithms", "Medium Test", "103"));
        tests.add(new Test(null, 3, 3, "Fundamentals", "Easy Test", "101"));
        tests.add(new Test(null, 2, 2, "Dynamic", "What Test", "100"));
        tests.add(new Test(null, 1, 1, "Poops", "This Test", "357"));

        String name = testName.getText();
        String course = courseBox.getValue();
        String subject = subjectBox.getValue();
        String status = subjectBox.getValue();
        //TODO: get date?
    }
}
