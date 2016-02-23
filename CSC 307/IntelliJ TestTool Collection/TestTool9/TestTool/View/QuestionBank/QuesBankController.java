package TestTool.View.QuestionBank;

import TestTool.MainApp;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.BasicTestCreation;
import TestTool.View.QuestionManagement.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import TestTool.Model.QuestionBank.*;
import javafx.fxml.FXMLLoader;
import TestTool.*;
import javafx.scene.layout.*;
import TestTool.Model.TestCreation.*;
import javafx.scene.control.*;
import TestTool.Model.QuestionCreation.*;
import javafx.collections.ObservableList;
import TestTool.Model.Resource.*;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * Created by JonathanTan on 11/20/15.
 */
public class QuesBankController {

    private MainApp mainApp;

    private FXMLLoader load;
    private AnchorPane curPane;

    @FXML
    private TextField searchBar;
    @FXML
    private TextField diffLevel;
    @FXML
    private ComboBox subject;
    @FXML
    private ComboBox course;
    @FXML
    private ComboBox quesType;
    @FXML
    private TableView<Question> quesTable;
    @FXML
    private TableColumn<Question, String> questionCol;
    @FXML
    private TableColumn<Question, Integer> diffCol;
    @FXML
    private TableColumn<Question, String> subjCol;
    @FXML
    private TableColumn<Question, String> courseCol;
    @FXML
    private TableColumn<Question, String> typeCol;
    @FXML
    private TableColumn<Question, LocalDate> dateCol;
    @FXML
    private TableColumn<Question, Double> pointsCol;
    @FXML
    private DatePicker startDa;
    @FXML
    private DatePicker endDa;
    @FXML
    private Button stDateClear;
    @FXML
    private Button endDateClear;


    private BankOptions opt;

    boolean alertShown = false;
    boolean quesLenAlert = false;


    public void setMain(MainApp a) {
        mainApp = a;
        load = new FXMLLoader();
        opt = new BankOptions();
        opt.setSearch("");
        opt.setDiff(-1);

        subject.getItems().addAll(SubjectCollection.getInstance().getAllSubjects());

        course.getItems().addAll(CourseCollection.getInstance().getAllCourses());

        Subject sub = new Subject("None");
        opt.setSubj(sub);

        Course cou = new Course("None");
        opt.setCourse(cou);
        opt.setQuestionType("None");

        quesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (int i = 0; i < QuestionBank.getInstance().getBank().size(); i++) {
            System.out.println(QuestionBank.getInstance().getBank().get(i).getQuestion());
        }

        ArrayList<Question> questions = QuestionBank.getInstance().getBank();
        ObservableList<Question> testList = FXCollections.observableArrayList(questions);
        quesTable.setItems(testList);
        questionCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());});

        diffCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());});
        subjCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getSubject().getName());});
        courseCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getCourse().getName());});
        typeCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getType());});
        dateCol.setCellValueFactory(c-> {return new ReadOnlyObjectWrapper<LocalDate>(c.getValue().getDate());});
        pointsCol.setCellValueFactory(c-> {return new ReadOnlyObjectWrapper<Double>(c.getValue().getPoints());});

    }

    static int a = 1;

    public void updateBank() {
        searchBoxValue();
        diffValue();
        subjValue();
        courseValue();
        quesTypeValue();
        datesValue();

        ArrayList<Question> questions = QuestionBank.getInstance().sortAndFilter(opt);
        ObservableList<Question> testList = FXCollections.observableArrayList(questions);
        quesTable.setItems(testList);
        questionCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());});

        diffCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());});
        subjCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getSubject().getName());});
        courseCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getCourse().getName());});
        typeCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getType());});


    }

    public void datesValue() {
        int day;
        int month;
        int year;
        LocalDate start = null;
        LocalDate end = null;

        if (startDa.getValue() != null) {
            day = startDa.getValue().getDayOfMonth();
            month = startDa.getValue().getMonthValue();
            year = startDa.getValue().getYear();
            start = LocalDate.of(year, month, day);
        }


        if (endDa.getValue() != null) {
            day = endDa.getValue().getDayOfMonth();
            month = endDa.getValue().getMonthValue();
            year = endDa.getValue().getYear();
            end = LocalDate.of(year, month, day);
        }

        opt.setStart(start);
        opt.setEnd(end);
    }

    public void searchBoxValue() {

        try {
            String boxVal = "";
            if (searchBar.getText() != null)
                boxVal = searchBar.getText();
            opt.setSearch(boxVal);
        }

        catch (NullPointerException e) {
            opt.setSearch("");
        }
    }

    public void diffValue() {
        try {
            if (diffLevel.getText().length() != 0) {
                int diff = Integer.valueOf(diffLevel.getText());
                opt.setDiff(diff);
                alertShown = false;
            }
            else {
                opt.setDiff(-1);
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
        String subjVal = (String) subject.getValue();
        Subject newSub = new Subject(subjVal);
        opt.setSubj(newSub);
    }

    public void courseValue() {
        String courseVal = (String) course.getValue();
        Course newCour = new Course(courseVal);
        opt.setCourse(newCour);
    }

    public void quesTypeValue() {
        String qT = (String) quesType.getValue();
        opt.setQuestionType(qT);
    }

    public void addQues() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/QuestionManagement/QuestionEditor.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    public void backButQuesBank() throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    public void clearStart() {
        startDa.setValue(null);
        updateBank();
    }

    public void clearEnd() {
        endDa.setValue(null);
        updateBank();
    }

    public void clearAll() {

        searchBar.setText("");
        diffLevel.setText("");
        subject.setValue("None");
        course.setValue("None");
        quesType.setValue("None");
        startDa.setValue(null);
        endDa.setValue(null);
        updateBank();
    }

    public void deleteQues() {

        /* Get's the selected questions */
        ObservableList<Question> temp = quesTable.getSelectionModel().getSelectedItems();

        ArrayList<Question> del = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            del.add(temp.get(i));
        }

        /* Deletes the selected question from the model */
        QuestionBank.getInstance().deleteQuestion(del);
        updateBank();
    }

    public void editQues() {

        /* Get's the selected questions */
        ObservableList<Question> temp = quesTable.getSelectionModel().getSelectedItems();

        if (temp.size() > 0){

            Question tempQues = temp.get(0);
            String quesType = tempQues.getType();

            FXMLLoader loader;

            switch(quesType) {

                case "True/False":
                    try {
                        loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("View/QuestionManagement/TrueFalseEdit.fxml"));
                        AnchorPane newScreen = (AnchorPane) loader.load();
                        TrueFalseEditHandler tfHandler = loader.getController();
                        tfHandler.setQuestion((TrueFalse) tempQues);
                        tfHandler.init2();
                        tfHandler.setMain(mainApp);

                        mainApp.rootLayout.setCenter(newScreen);
                        mainApp.primaryStage.show();
                    }
                    catch (Exception e) {
                        System.out.println("Error editing test");
                    }

                    break;

                case "Multiple Choice":
                    try {
                        loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("View/QuestionManagement/MultipleChoiceEdit.fxml"));
                        AnchorPane newScreen = (AnchorPane) loader.load();
                        MultipleChoiceEditHandler mceHandler = loader.getController();
                        mceHandler.setQuestion((MultipleChoice) tempQues);
                        mceHandler.init2();
                        mceHandler.setMain(mainApp);

                        mainApp.rootLayout.setCenter(newScreen);
                        mainApp.primaryStage.show();
                    }
                    catch (Exception e) {
                        System.out.println("Error editing test");
                    }

                    break;

                case "Free-Response":

                    try {
                        loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("View/QuestionManagement/FreeResponseEdit.fxml"));
                        AnchorPane newScreen = (AnchorPane) loader.load();
                        FreeResponseEditHandler freeHandler = loader.getController();

                        freeHandler.setQuestion((FreeResponse) tempQues);
                        freeHandler.init2();
                        freeHandler.setMain(mainApp);

                        mainApp.rootLayout.setCenter(newScreen);
                        mainApp.primaryStage.show();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error editing test");
                    }
                    break;

                case "Coding":

                    try {
                        loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("View/QuestionManagement/CodingEdit.fxml"));
                        AnchorPane newScreen = (AnchorPane) loader.load();
                        CodingEditHandler codeHandler = loader.getController();

                        codeHandler.setQuestion((Coding) tempQues);
                        codeHandler.init2();
                        codeHandler.setMain(mainApp);

                        mainApp.rootLayout.setCenter(newScreen);
                        mainApp.primaryStage.show();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error editing test");
                    }
                    break;

                case "Fill-In-The-Blank":

                    try {
                        loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("View/QuestionManagement/FillInTheBlankEdit.fxml"));
                        AnchorPane newScreen = (AnchorPane) loader.load();
                        FillInTheBlankEditHandler fillHandler = loader.getController();

                        fillHandler.setQuestion((FillInTheBlank) tempQues);
                        fillHandler.init2();
                        fillHandler.setMain(mainApp);

                        mainApp.rootLayout.setCenter(newScreen);
                        mainApp.primaryStage.show();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error editing test");
                    }
                    break;

            }


        }
    }

}
