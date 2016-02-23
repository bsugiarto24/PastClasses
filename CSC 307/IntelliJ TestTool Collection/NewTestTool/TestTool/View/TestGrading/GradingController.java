package TestTool.View.TestGrading;

import TestTool.Model.TestGrading.QuestionScore;
import javafx.fxml.FXML;

/**
 * Created by mgolahi on 11/8/15.
 */
public class GradingController {

    @FXML
    public void markCorrect() {
        QuestionScore.markCorrect();
    }

    @FXML
    public void markIncorrect() {
        QuestionScore.markIncorrect();
    }

    @FXML
    public void save() {
        QuestionScore.save();
    }

    @FXML
    public void onBack() {
        QuestionScore.back();
    }
}
