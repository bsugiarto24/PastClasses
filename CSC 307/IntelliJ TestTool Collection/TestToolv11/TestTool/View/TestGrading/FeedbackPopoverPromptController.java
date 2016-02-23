package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mgolahi on 12/3/15.
 */
public class FeedbackPopoverPromptController implements Initializable {
    private MainApp mainApp;
    private ActiveTest activeTest;
    private StudentTest studentTest;
    private Question question;
    private TestGradingQuestionController questionController;

    @FXML
    private TextArea feedbackText;
    @FXML
    private Button saveButton;

    public FeedbackPopoverPromptController(final MainApp mainApp, final ActiveTest activeTest,
                                           final StudentTest studentTest, final Question question,
                                           final TestGradingQuestionController questionController) {
        this.mainApp = mainApp;
        this.activeTest = activeTest;
        this.studentTest = studentTest;
        this.question = question;
        this.questionController = questionController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        feedbackText.setText(question.getScore().getFeedback());
    }

    @FXML
    private void handleSave() {
        question.getScore().setFeedback(feedbackText.getText());
        closeStage();
    }

    @FXML
    private void handleCancel() {
        closeStage();
    }

    private void closeStage() {
        ((Stage) saveButton.getScene().getWindow()).close();
    }
}
