package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.Resource.*;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestGrading.Status;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by mgolahi on 11/29/15.
 */
public class TestGradingMainController implements Initializable {

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
    private ComboBox<Status> statusBox;
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
        initializeStatuses();
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
        setTests(ActiveTestBank.getInstance().getBank());
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
            return new ReadOnlyObjectWrapper(val);
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

    private void initializeStatuses() {
        statusBox.setItems(FXCollections.observableArrayList(Status.COMPLETE, Status.IN_PROGRESS, Status.NOT_STARTED));
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
        statusBox.valueProperty().addListener(new ChangeListener<Status>() {
            @Override
            public void changed(final ObservableValue<? extends Status> observable, final Status oldValue, final Status newValue) {
                filter();
            }
        });
    }

    @FXML
    private void filter() {
        ArrayList<ActiveTest> activeTests = new ArrayList<>(activeTestBank.getBank());

        String name = testName.getText();
        Course course = courseBox.getValue();
        Subject subject = subjectBox.getValue();
        Status status = statusBox.getValue();
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
        if (status != null) {
            activeTests = filterByStatus(activeTests, status);
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

    private ArrayList<ActiveTest> filterByStatus(ArrayList<ActiveTest> input, Status status) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<ActiveTest> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getStatus().equals(status)) {
                filtered.add(input.get(i));
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
        statusBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        filter();
    }
}
