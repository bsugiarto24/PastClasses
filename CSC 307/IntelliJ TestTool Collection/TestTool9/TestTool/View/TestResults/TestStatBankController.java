package TestTool.View.TestResults;

import TestTool.MainApp;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestGrading.Status;
import TestTool.Model.TestResults.TestChart;
import TestTool.View.TestCreation.RanTestController;
import TestTool.View.TestGrading.TestGradingIndividualController;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by brvo on 12/5/15.
 */
public class TestStatBankController implements Initializable{
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTests();
        initializeSubjects();
        initializeCourses();
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
            /*
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/TestGradingIndividual.fxml"));
            loader.setControllerFactory((cf) -> {
                return new TestGradingIndividualController(mainApp, test);
            });
            AnchorPane curPane = loader.load();
            mainApp.rootLayout.setCenter(curPane);
            mainApp.primaryStage.show();
            */
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/TestResults/TestStatistics.fxml"));

            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Test Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
/*
            // Set the persons into the controller
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);


  */
            HashMap<String, Integer> map = TestChart.creatChart(test);
            TestStatisticsController testStatisticsController = loader.getController();
            testStatisticsController.createChart(map, test.getTest().getName());

            dialogStage.show();
        }
    }

    private void initializeTests() {
        //setTests(ActiveTestBank.getInstance().getCompletedTests());
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
        subjectColumn.setCellValueFactory(p ->
        {
            ArrayList<Subject> subjects = p.getValue().getTest().getSubject();
            String val = subjects
                    .stream()
                    .map(item -> item.getName()).
                            collect(Collectors.joining(", "));
            return new ReadOnlyObjectWrapper( val );
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
        subjectBox.setItems(FXCollections.observableArrayList(SubjectCollection.getInstance().getAllSubjects()));
    }

    private void initializeCourses() {
        courseBox.setItems(FXCollections.observableArrayList(CourseCollection.getInstance().getAllCourses()));
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
