package TestTool.View.TestResults;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestResults.QuestionChart;
import TestTool.Model.TestResults.TestChart;
import TestTool.View.TestGrading.TestGradingIndividualController;
import TestTool.View.TestGrading.TestGradingMainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

/**
 * Created by brvo on 11/8/15.
 */
public class StatisticsController {
    private MainApp mainApp;

    @FXML
    private BarChart<String, Number> chart;

    public void setMain(MainApp a) {
        mainApp = a;
    }

    @FXML
    public void onTestBankSelect() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestResults/testStatBank.fxml"));
        AnchorPane newScreen = (AnchorPane) loader.load();
        TestStatBankController testStatBankController = loader.getController();
        testStatBankController.setMain(mainApp);

        // Set new screen into center of root layout
        mainApp.rootLayout.setCenter(newScreen);

        mainApp.primaryStage.show();
    }

    @FXML
    public void initialize(){
        createChart(null, true, "");
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

    public void createChart(HashMap<String, Integer> percentages, boolean blank, String testName){
        String title = "Grade Breakdown";
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        XYChart.Series series1 = new XYChart.Series();
        if(!testName.isEmpty()){
            title = "Grade Breakdown for " + testName;
        }
        chart = new BarChart<String,Number>(xAxis,yAxis);
        chart.setTitle(title);
        xAxis.setLabel("Grade in Percentages");
        yAxis.setLabel("Number of Students");

        if(blank){
            series1.getData().add(new XYChart.Data(TestChart.firstPercentage, 0));
            series1.getData().add(new XYChart.Data(TestChart.secondPercentage, 0));
            series1.getData().add(new XYChart.Data(TestChart.thirdPercentage, 0));
            series1.getData().add(new XYChart.Data(TestChart.fourthPercentage, 0));
            series1.getData().add(new XYChart.Data(TestChart.fifthPercentage, 0));

        }
        else{

        }
        chart.getData().add(series1);
        System.out.println("Hello");
        chart.setVisible(true);
    }

}
