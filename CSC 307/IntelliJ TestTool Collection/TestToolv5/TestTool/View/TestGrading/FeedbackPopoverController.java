package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.FreeResponse;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class FeedbackPopoverController implements Initializable {
    private MainApp mainApp;
    private ActiveTest activeTest;
    private StudentTest studentTest;
    private Question question;
    private TestGradingQuestionController questionController;

    @FXML
    private StackPane questionPane;
    @FXML
    private StackPane answersPane;
    @FXML
    private StackPane pointsPossiblePane;
    @FXML
    private TextField pointsEarnedField;
    @FXML
    private TextArea expectedKeywordsArea;
    @FXML
    private StackPane foundKeywordsPane;
    @FXML
    private Button saveButton;

    public FeedbackPopoverController(final MainApp mainApp, final ActiveTest activeTest, final StudentTest studentTest, final Question question, final TestGradingQuestionController qc) {
        this.mainApp = mainApp;
        this.activeTest = activeTest;
        this.studentTest = studentTest;
        this.question = question;
        this.questionController = qc;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Text questionText = new Text(question.getQuestion());
        questionText.wrappingWidthProperty().bind(questionPane.widthProperty());
        questionPane.getChildren().add(questionText);

        //TODO: fully implement this crap
        String answerString = "";
        if (question.getClass() == FreeResponse.class) {
            FreeResponse fr = (FreeResponse) question;
            answerString = fr.getStudentAnswer();
        }
        Text answerText = new Text(answerString);
        answerText.wrappingWidthProperty().bind(answersPane.widthProperty());
        answersPane.getChildren().add(answerText);

        Text pointsPossible = new Text(Double.toString(question.getPoints()));
        pointsPossiblePane.getChildren().add(pointsPossible);

        pointsEarnedField.setText(Double.toString(question.getScore().getPointsEarned()));
    }

    @FXML
    private void handleSave() {
        Double pointsBefore = question.getScore().getPointsEarned();
        Alert invalidPoints = new Alert(Alert.AlertType.ERROR);
        invalidPoints.setTitle("Invalid Input");
        boolean validInput = true;
        Double pointsEarnedSave = 0.0;
        try {
            pointsEarnedSave = Double.parseDouble(pointsEarnedField.getText());
            if (pointsEarnedSave.compareTo((double)0) < 0) {
                invalidPoints.setHeaderText("Points Earned is not a valid value.");
                invalidPoints.showAndWait();
                validInput = false;
            }
            else if (pointsEarnedSave.compareTo(question.getPoints()) > 0) {
                invalidPoints.showAndWait();
                invalidPoints.showAndWait();
                validInput = false;
            }
        } catch (NumberFormatException e) {
            invalidPoints.setHeaderText("Points Earned is not a valid value.");
            invalidPoints.showAndWait();
            validInput = false;
        }
        if (validInput) {
            question.getScore().setPointsEarned(pointsEarnedSave);
            if (!question.getScore().isGraded()) {
                question.getScore().setGraded();
                studentTest.getScore().updateGradedCount();
            }
            Stage stage = (Stage) saveButton.getScene().getWindow();
            studentTest.getScore().updateEarnedPoints(pointsEarnedSave - pointsBefore);
            questionController.initializeData();
            stage.close();
        }
    }

    @FXML
    private void handleEditFeedback() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/FeedbackPopoverPrompt.fxml"));
        loader.setControllerFactory((cf) -> {
            return new FeedbackPopoverPromptController(mainApp, activeTest, studentTest, question, questionController);
        });
        Parent newWindow = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newWindow));
        stage.show();
    }

}
