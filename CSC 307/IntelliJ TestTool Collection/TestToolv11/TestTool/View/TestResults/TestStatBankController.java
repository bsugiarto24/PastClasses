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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ComboBox<Course> courseBox;
    @FXML
    private ComboBox<Subject> subjectBox;
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
        initializeCourses();
        initializeListeners();
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

            HashMap<String, Integer> map = TestChart.creatChart(test);
            TestStatisticsController testStatisticsController = loader.getController();
            testStatisticsController.createChart(map, test.getTest().getName());

            dialogStage.show();
        }
    }

    private void initializeTests() {
        setTests(ActiveTestBank.getInstance().getCompletedTests());
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

    private void initializeCourses() {
        courseBox.setItems(FXCollections.observableArrayList(CourseCollection.getInstance().getAllCourseList()));
        subjectBox.setDisable(true);
    }


    private void updateSubjects(final Course newValue) {
        subjectBox.setItems(FXCollections.observableArrayList(newValue.getSubjects()));
    }

    private void initializeListeners() {
        courseBox.valueProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(final ObservableValue<? extends Course> observable, final Course oldValue, final Course newValue) {
                if (newValue != null) {
                    subjectBox.setDisable(false);
                    updateSubjects(newValue);
                } else {
                    subjectBox.getItems().clear();
                    subjectBox.setDisable(true);
                }
                filter();
            }
        });
        subjectBox.valueProperty().addListener(new ChangeListener<Subject>() {
            @Override
            public void changed(final ObservableValue<? extends Subject> observable, final Subject oldValue, final Subject newValue) {
                filter();
            }
        });
        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(final ObservableValue<? extends LocalDate> observable, final LocalDate oldValue, final LocalDate newValue) {
                filter();
            }
        });
    }

    @FXML
    private void filter() {
        ArrayList<ActiveTest> activeTests = new ArrayList<>(activeTestBank.getCompletedTests());

        String name = testName.getText();
        Course course = courseBox.getValue();
        Subject subject = subjectBox.getValue();
        LocalDate date = datePicker.getValue();

        if (name != null) {
            activeTests = filterByName(activeTests, name);
        }
        if (course != null) {
            activeTests = filterByCourse(activeTests, course);
        }
        if (subject != null) {
            activeTests = filterBySubject(activeTests, subject);
        }

        if (date != null) {
            activeTests = filterByDate(activeTests, date);
        }

        setTests(activeTests);
    }

    private ArrayList<ActiveTest> filterByName(ArrayList<ActiveTest> input, String name) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<ActiveTest> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getTest().getName().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<ActiveTest> filterByCourse(ArrayList<ActiveTest> input, Course course) {
         /* ArrayList that will eventually hold final filtered objects */
        ArrayList<ActiveTest> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getTest().getCourse().equals(course)) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<ActiveTest> filterBySubject(ArrayList<ActiveTest> input, Subject subject) {
         /* ArrayList that will eventually hold final filtered objects */
        ArrayList<ActiveTest> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            for (Subject inTest : input.get(i).getTest().getSubject()) {
                if (inTest.equals(subject)) {
                    filtered.add(input.get(i));
                }
            }
        }
        return filtered;
    }

    private ArrayList<ActiveTest> filterByDate(ArrayList<ActiveTest> input, LocalDate date) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<ActiveTest> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getDate().equals(date)) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    @FXML
    private void reset() {
        testName.clear();
        courseBox.getSelectionModel().clearSelection();
        subjectBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        filter();
    }
}
