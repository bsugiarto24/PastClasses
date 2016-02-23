package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.Coding;
import TestTool.Model.QuestionCreation.FreeResponse;
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

public class TestEditFreeResponseEditHandler extends FreeResponseHandler {

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
    private TextArea flagsText;

    FreeResponse question;
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

        String flagDelimitedString = "";
        for (int i = 0; i < question.getFlags().size(); i++) {
            if (i == question.getFlags().size() - 1) {
                flagDelimitedString += question.getFlags().get(i);
            } else {
                flagDelimitedString += question.getFlags().get(i) + ";";
            }
        }
        flagsText.setText(String.valueOf(flagDelimitedString));
    }

    public void setQuestion(FreeResponse q) {
        question = q;
    }

    public void setTest(final Test test) {
        this.test = test;
    }

    @FXML
    private void saveQuestion() throws Exception {
        String questionString = questionText.getText();
        Subject subject = subjectBox.getSelectionModel().getSelectedItem();
        Integer difficulty = difficultyBox.getValue();
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
        String flags = flagsText.getText();

        question.setQuestion(questionString);
        question.setSubject(subject);
        question.setDifficulty(difficulty);
        question.setPoints(points);
        question.setFlags(flags);
        question.setDate(LocalDate.now());
        handleClear();
    }

    // Name handleClear, but will also be used to go back to the previous screen.
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
