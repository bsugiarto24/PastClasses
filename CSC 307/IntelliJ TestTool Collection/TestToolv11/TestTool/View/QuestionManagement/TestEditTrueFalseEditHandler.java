package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.TrueFalse;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.TestMaker;
import TestTool.Model.Resource.User;
import TestTool.Model.TestCreation.Test;
import TestTool.View.TestCreation.TestEditController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class TestEditTrueFalseEditHandler extends TrueFalseHandler {

    @FXML
    private TextArea questionText;
    @FXML
    private ComboBox<Course> courseBox;
    @FXML
    private ComboBox<Boolean> answerBox;
    @FXML
    private Button saveButton;
    @FXML
    private ComboBox<Subject> subjectBox;
    @FXML
    private ComboBox<Integer> difficultyBox;
    @FXML
    private TextArea pointsText;

    TrueFalse question;
    Test test;

    @FXML
    private void initialize() {

    }

    public void setQuestion(TrueFalse q) {
        question = q;
    }

    public void setTest(final Test test) {
        this.test = test;
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

        answerBox.setItems(FXCollections.observableArrayList(true, false));
        answerBox.setValue(question.getAnswer());
    }

    @FXML
    private void saveQuestion() throws Exception {
        String questionString = questionText.getText();
        Subject subject = subjectBox.getSelectionModel().getSelectedItem();
        Integer difficulty = difficultyBox.getValue();
        Boolean answer = answerBox.getValue();
        Double points;
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
        question.setAnswer(answer);
        question.setDate(LocalDate.now());
        handleClear();
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
}
