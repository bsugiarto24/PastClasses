package TestTool.View.QuestionBank;

import TestTool.MainApp;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.AdvancedTestCreation;
import TestTool.Model.TestCreation.BasicTestCreation;
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


    private BankOptions opt;

    boolean alertShown = false;
    boolean quesLenAlert = false;


    public void setMain(MainApp a) {
        mainApp = a;
        load = new FXMLLoader();
        opt = new BankOptions();
        opt.setSearch("");
        opt.setDiff(-1);

        Subject sub = new Subject("None");
        opt.setSubj(sub);

        Course cou = new Course("None");
        opt.setCourse(cou);
        opt.setQuestionType("None");

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

    }

    static int a = 1;

    public void updateBank() {
        searchBoxValue();
        diffValue();
        subjValue();
        courseValue();
        quesTypeValue();

        ArrayList<Question> questions = QuestionBank.getInstance().sortAndFilter(opt);
        ObservableList<Question> testList = FXCollections.observableArrayList(questions);
        quesTable.setItems(testList);
        questionCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());});

        diffCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());});
        subjCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getSubject().getName());});
        courseCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getCourse().getName());});
        typeCol.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getType());});


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

}
