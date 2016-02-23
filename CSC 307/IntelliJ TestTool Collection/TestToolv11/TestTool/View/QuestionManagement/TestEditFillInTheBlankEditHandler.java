package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.Coding;
import TestTool.Model.QuestionCreation.FillInTheBlank;
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
import java.util.Scanner;

public class TestEditFillInTheBlankEditHandler extends FillInTheBlankHandler {
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
    private TextArea answerText;

    FillInTheBlank question;
    Test test;

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
        answerText.setText(question.getAnswer());
    }

    public void setQuestion(FillInTheBlank q) {
        question = q;
    }

    public void setTest(final Test test) {
        this.test = test;
    }

    @FXML
    private void saveQuestion() throws Exception {
        Subject subject = subjectBox.getSelectionModel().getSelectedItem();
        String answer = answerText.getText();
        Integer difficulty = difficultyBox.getValue();
        Double points;

		/* Parsing the question to ensure there's at least one blank*/
        String questionString = questionText.getText();
        Scanner scanner = new Scanner(questionText.getText());
        boolean hasBlank = false;
        while (scanner.hasNext()) {
            if (scanner.next().compareTo("_") == 0) {
                hasBlank = true;
                break;
            }
        }
        if (!hasBlank) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Question Input");
            alert.setContentText("Please enter one blank space (_) for proper input.");
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
        question.setAnswer(answer);
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
