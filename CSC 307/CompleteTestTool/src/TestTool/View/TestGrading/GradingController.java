package TestTool.View.TestGrading;

import javafx.fxml.FXML;

/**
 * Created by mgolahi on 11/8/15.
 */
public class GradingController {

    @FXML
    public void markCorrect() {
        System.out.println("Marking correct");
    }

    @FXML
    public void markIncorrect() {
        System.out.println("Marking incorrect");
    }

    @FXML
    public void save() {
        System.out.println("Saving...");
    }

    @FXML
    public void onBack() {
        System.out.println("Going back");
    }
}
