package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.MultipleChoice;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.TestMaker;
import TestTool.Model.Resource.User;
import TestTool.Model.TestCreation.Test;
import TestTool.View.TestCreation.TestEditController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestEditMultipleChoiceEditHandler extends MultipleChoiceHandler {

    @FXML
    private TextArea questionText;
    @FXML
    private ComboBox<Course> courseBox;
    @FXML
    private Button saveButton;
    @FXML
    private ComboBox<Subject> subjectBox;
    @FXML
    private ComboBox<Integer> difficultyBox;
    @FXML
    private TextArea pointsText;
    @FXML
    private Button deleteChoiceButton;
    @FXML
    private Button addChoiceButton;
    @FXML
    private TableView<Option> choiceTable;
    @FXML
    private TableColumn<Option, String> choiceColumn;
    @FXML
    private TableColumn<Option, Boolean> answerColumn;

    MultipleChoice question;
    private ObservableList<Option> answerChoiceList;
    Test test;

    @FXML
    private void initialize() {
    }

    public void init2() {

        questionText.setText(question.getQuestion());

        Course course = question.getCourse();
        courseBox.setValue(course);
        courseBox.setDisable(true);

        subjectBox.setItems(FXCollections.observableArrayList(course.getSubjects()));
        subjectBox.setValue(question.getSubject());

        difficultyBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        difficultyBox.setValue(question.getDifficulty());

        pointsText.setText(String.valueOf(question.getPoints()));

        questionText.setText(question.getQuestion());

        answerChoiceList = FXCollections.observableArrayList();
        SimpleStringProperty opt;
        for (int i = 0; i < question.getOptions().size(); i++) {
            opt = new SimpleStringProperty();
            opt.setValue(question.getOptions().get(i));
            Option option = new Option(opt);
            answerChoiceList.add(option);
            if (question.getAnswer().contains(i)) {
                option.setCorrect(true);
            }
        }
        choiceColumn.setCellValueFactory(new PropertyValueFactory<Option, String>("option"));
        choiceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        answerColumn.setCellValueFactory(new PropertyValueFactory<Option, Boolean>("correct"));
        answerColumn.setCellFactory(CheckBoxTableCell.forTableColumn(answerColumn));

        choiceColumn.setEditable(true);
        answerColumn.setEditable(true);
        choiceTable.setEditable(true);
        choiceTable.setItems(answerChoiceList);

    }

    @FXML
    private void saveQuestion() throws Exception {
        String questionString = questionText.getText();
        Subject subject = subjectBox.getSelectionModel().getSelectedItem();
        Integer difficulty = difficultyBox.getValue();
        Double points;

        //makes sure there is an answer set
        boolean temp = false;

        ArrayList<String> tempOption = new ArrayList<>();
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        for (int i = 0; i < answerChoiceList.size(); i++) {
            tempOption.add(answerChoiceList.get(i).option.getValue());
            if (answerColumn.getCellData(i)) {
                tempAnswer.add(i);
                temp = true;
            }
        }
        if (!temp) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Answer Options");
            alert.setContentText("Please select at least one option as the correct answer.");
            alert.showAndWait();
            return;
        }
        try {
            points = Double.parseDouble(pointsText.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Points Value");
            alert.setContentText("Please enter a valid number for the points value (double).");
            alert.showAndWait();
            return;
        }

        question.setQuestion(questionString);
        question.setSubject(subject);
        question.setDifficulty(difficulty);
        question.setPoints(points);
        question.setDate(LocalDate.now());
        question.setOption(tempOption);
        question.setAnswer(tempAnswer);
        handleClear();
    }

    public void setTest(final Test test) {
        this.test = test;
    }

    public void setQuestion(MultipleChoice q) {
        question = q;
    }

    @FXML
    private void handleClear() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestCreation/testEdit.fxml"));
        loader.setControllerFactory((cf) -> {
            return new TestEditController(test, mainApp);
        });
        AnchorPane curPane = loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    private void handleAddChoiceButton() {
        answerChoiceList.add(new Option(new SimpleStringProperty("-new choice-")));
    }

    @FXML
    private void handleDeleteChoiceButton() {
        ObservableList<Option> select, all;
        all = choiceTable.getItems();
        select = choiceTable.getSelectionModel().getSelectedItems();

        select.forEach(all::remove);
    }
}
