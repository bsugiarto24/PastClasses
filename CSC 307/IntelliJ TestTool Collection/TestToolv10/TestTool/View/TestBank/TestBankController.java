package TestTool.View.TestBank;

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
import TestTool.View.TestCreation.RanTestController;
import TestTool.View.TestCreation.TestEditController;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by brvo on 11/24/15.
 */
public class TestBankController {

    private MainApp mainApp;

    @FXML
    private TableView<Test> testTable;

    @FXML
    private TableColumn<Test, String> testNameColumn;

    @FXML
    private TableColumn<Test, Course> courseColumn;

    @FXML
    private TableColumn<Test, Subject> subjectColumn;

    @FXML
    private TableColumn<Test, Integer> questionsColumn;

    @FXML
    private TableColumn<Test, Integer> difficultyColumn;

    @FXML
    private TableColumn<Test, Integer> timeLengthColumn;

    @FXML
    private TextField avgDiffTF;
    @FXML
    private TextField testLengthTF;
    @FXML
    private TextField testNameTF;
    @FXML
    private ComboBox<Subject> subjectCB;
    @FXML
    private ComboBox<Course> courseCB;
    @FXML
    private Button filterButton;



    public void setMain(MainApp app) {
        mainApp = app;
    }

    @FXML
    private void initialize(){
        initializeTests();
        initializeCourses();
        initializeListeners();
    }

    public void onAdd() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestCreation/GenTest.fxml"));
        AnchorPane ranMa = (AnchorPane) loader.load();

        RanTestController testController = loader.getController();
        testController.setMain(mainApp);

        // Set new screen into center of root layout
        mainApp.rootLayout.setCenter(ranMa);

        mainApp.primaryStage.show();

    }

    public void onDelete(){
        Test test = testTable.getSelectionModel().getSelectedItem();
        if(test == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cannot delete Test");
            alert.setContentText("Please Select a Test to Delete");
            alert.showAndWait();
            return;
        }
        TestBank.getInstance().delete(test);
        testTable.setItems(FXCollections.observableArrayList(TestBank.getInstance().getBank()));
        System.out.println(test.getName());
    }


    public void editTest() throws Exception {
        Test testToEdit = testTable.getSelectionModel().getSelectedItem();
        if (testToEdit != null) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestCreation/testEdit.fxml"));
            loader.setControllerFactory((cf) -> {
                return new TestEditController(testToEdit, mainApp);
            });
            AnchorPane curPane = loader.load();
            mainApp.rootLayout.setCenter(curPane);
            mainApp.primaryStage.show();
        }
    }



    private void initializeTests() {
        setTests(TestBank.getInstance().getBank());
    }

    private void setTests(ArrayList<Test> tests) {
        ObservableList<Test> testList = FXCollections.observableArrayList();
        tests.forEach(testList::add);
        //Set the table's items
        testTable.setItems(testList);

        testNameColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getName());
        });

        courseColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getCourse());});
        subjectColumn.setCellValueFactory(( TableColumn.CellDataFeatures<Test, Subject> p ) ->
        {
            ArrayList<Subject> subjects = p.getValue().getSubject();
            String val = subjects
                    .stream()
                    .map(item -> item.getName()).
                            collect(Collectors.joining(", "));
            return new ReadOnlyObjectWrapper( val );
        });
        questionsColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getNumQuestions());
        });
        difficultyColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());
        });
        timeLengthColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getTimeLimit());
        });
    }

    private void initializeCourses() {
        courseCB.setItems(FXCollections.observableArrayList(CourseCollection.getInstance().getAllCourseList()));
        subjectCB.setDisable(true);
    }

    private void updateSubjects(final Course newValue) {
        subjectCB.setItems(FXCollections.observableArrayList(newValue.getSubjects()));
    }

    private void initializeListeners() {
        courseCB.valueProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(final ObservableValue<? extends Course> observable, final Course oldValue, final Course newValue) {
                if (newValue != null) {
                    subjectCB.setDisable(false);
                    updateSubjects(newValue);
                } else {
                    subjectCB.getItems().clear();
                    subjectCB.setDisable(true);
                }
                filter();
            }
        });
        subjectCB.valueProperty().addListener(new ChangeListener<Subject>() {
            @Override
            public void changed(final ObservableValue<? extends Subject> observable, final Subject oldValue, final Subject newValue) {
                filter();
            }
        });
    }

    @FXML
    private void filter() {
        ArrayList<Test> tests = new ArrayList<>(TestBank.getInstance().getBank());

        String name = testNameTF.getText();
        Course course = courseCB.getValue();
        Subject subject = subjectCB.getValue();
        String length = testLengthTF.getText();
        String difficulty = avgDiffTF.getText();

        if (name != null) {
            tests = filterByName(tests, name);
        }
        if (course != null) {
            tests = filterByCourse(tests, course);
        }
        if (subject != null) {
            tests = filterBySubject(tests, subject);
        }
        if (length != null && !length.isEmpty()){
            tests = filterByLength(tests, Integer.valueOf(length));
        }
        if (difficulty != null && !difficulty.isEmpty()){
            tests = filterByDifficulty(tests, Integer.valueOf(difficulty));
        }

        setTests(tests);
    }

    private ArrayList<Test> filterByName(ArrayList<Test> input, String name) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Test> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Test> filterByCourse(ArrayList<Test> input, Course course) {
         /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Test> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getCourse().getName().equals(course.getName())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Test> filterBySubject(ArrayList<Test> input, Subject subject) {
         /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Test> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            for (Subject inTest : input.get(i).getSubject()) {
                if (inTest.getName().equals(subject.getName())) {
                    filtered.add(input.get(i));
                }
            }
        }
        return filtered;
    }

    private ArrayList<Test> filterByLength(ArrayList<Test> input, int length){
    /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Test> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* If the length matches then add it to the arraylist */
            if(input.get(i).getTimeLimit() == length){
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Test> filterByDifficulty(ArrayList<Test> input, int difficulty){
    /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Test> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* If the difficulty matches then add it to the arraylist */
            if(input.get(i).getDifficulty()== difficulty){
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }



    @FXML
    private void reset() {
        testNameTF.clear();
        courseCB.getSelectionModel().clearSelection();
        subjectCB.getSelectionModel().clearSelection();
        filter();
    }
}
