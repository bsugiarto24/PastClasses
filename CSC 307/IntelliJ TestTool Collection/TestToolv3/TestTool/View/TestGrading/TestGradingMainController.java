package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.*;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
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

    private ArrayList<ActiveTest> makeDummyData() {
        //Collection of TestTakers, since it's not yet implemented
        HashMap<String, TestTaker> testTakers = new HashMap<>();
        TestTaker mgolahi = new TestTaker("123", "mgolahi", "Michael Golahi");
        TestTaker brvo = new TestTaker("123", "brvo", "Brandon Vo");
        TestTaker bsugiart = new TestTaker("123", "bsugiart", "Bryan Sugiarto");
        TestTaker jtan = new TestTaker("123", "jtan", "Jonathan Tan");
        TestTaker dsun = new TestTaker("123", "dsun", "Dylan Sun");
        TestTaker pyieh = new TestTaker("123", "pyieh", "Pierson Yieh");
        testTakers.put(mgolahi.getName(), mgolahi);
        testTakers.put(brvo.getName(), brvo);
        testTakers.put(bsugiart.getName(), bsugiart);
        testTakers.put(jtan.getName(), jtan);
        testTakers.put(dsun.getName(), dsun);
        testTakers.put(pyieh.getName(), pyieh);

        //Subjects
        Subject fund = new Subject("Fundamentals");
        SubjectCollection.getInstance().addSubject(fund);
        Subject basics = new Subject("Basics");
        SubjectCollection.getInstance().addSubject(basics);
        Subject algs = new Subject("Algorithms");
        SubjectCollection.getInstance().addSubject(algs);
        Subject dyn = new Subject("Dynamic");
        SubjectCollection.getInstance().addSubject(dyn);

        //CPE 101
        Course cpe101 = new Course("CPE101");
        cpe101.addStudent(mgolahi);
        cpe101.addStudent(brvo);
        cpe101.addStudent(bsugiart);
        cpe101.addStudent(jtan);
        cpe101.addStudent(dsun);
        cpe101.addStudent(pyieh);

        cpe101.addSubject(fund);
        cpe101.addSubject(basics);
        CourseCollection.getInstance().addCourse(cpe101);

        //CPE 103
        Course cpe103 = new Course("CPE103");
        cpe103.addStudent(mgolahi);
        cpe103.addStudent(brvo);
        cpe103.addStudent(bsugiart);

        cpe103.addSubject(algs);
        cpe103.addSubject(dyn);
        CourseCollection.getInstance().addCourse(cpe103);

        ArrayList<Question> qs1 = new ArrayList<>();
        //a1 should auto grade true
        TrueFalse a1 = new TrueFalse();
        a1.setQuestion("The Sacramento Kings are the best team in the NBA.");
        a1.setPoints(3);
        a1.setAnswer(true);
        a1.setStudentAnswer(true);
        qs1.add(a1);

        //a2 should auto grade false
        TrueFalse a2 = new TrueFalse();
        a2.setQuestion("The LA Lakers are still relevant.");
        a2.setPoints(5);
        a2.setAnswer(false);
        a2.setStudentAnswer(true);
        qs1.add(a2);

        //a3 is free response
        FreeResponse a3 = new FreeResponse();
        a3.setQuestion("This is a sample question that I'm just making up right now.");
        a3.setPoints(10);
        a3.setAnswer("This is what the correct answer should be.");
        a3.setStudentAnswer("A student's answer!");
        a3.setFlags("answer;correct");
        qs1.add(a3);

        //a4 is coding
        Coding a4 = new Coding();
        a4.setQuestion("This is yet another great sample question by mgolahi.");
        a4.setPoints(15);
        a4.setAnswer("System.out.println(\"Hello World!\"");
        a4.setStudentAnswer("stack.push()");
        a4.setFlags("hello;world");
        qs1.add(a4);

        ArrayList<ActiveTest> tests = new ArrayList<>();
        tests.add(new ActiveTest(new Test(qs1, 5, 5, "Fundamentals", "Midterm 1", "CPE101"), LocalDate.of(2015, 11, 29)));
        tests.add(new ActiveTest(new Test(new ArrayList<Question>(), 3, 3, "Basics", "Midterm 2", "CPE101"), LocalDate.of(2015, 10, 2)));
        tests.add(new ActiveTest(new Test(new ArrayList<Question>(), 2, 2, "Algorithms", "Test A", "CPE103"), LocalDate.of(2015, 9, 3)));
        tests.add(new ActiveTest(new Test(new ArrayList<Question>(), 1, 1, "Dynamic", "Test B", "CPE103"), LocalDate.of(2015, 3, 2)));
        return tests;
    }

    private void initializeTests() {
        //TODO: replace the dummy data with a getAllTestsFromBank() call
//        setTests(activeTestBank.getBank());
        setTests(makeDummyData());
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
