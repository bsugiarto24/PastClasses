package TestTool.View.TestResults;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestResults.QuestionChart;
import TestTool.Model.TestResults.TestChart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;

/**
 * Created by brvo on 11/8/15.
 */
public class StatisticsController {


    @FXML
    public void onTestBankSelect() {
        TestChart.setCurrent();
    }

    @FXML
    public void onExportScore() {
        TestChart.exportChart();
    }

    @FXML
    public void onQuestionBankSelect() {
        QuestionChart questionChart = new QuestionChart();
        questionChart.setCurrent();
    }

    @FXML
    public void onEditQuestion() {

        QuestionChart questionChart = new QuestionChart();
        questionChart.editQuestion();
    }


}
