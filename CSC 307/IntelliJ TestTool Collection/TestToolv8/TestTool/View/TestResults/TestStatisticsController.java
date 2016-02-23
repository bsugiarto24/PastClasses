package TestTool.View.TestResults;

import TestTool.Model.TestResults.TestChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.HashMap;

/**
 * Created by brvo on 12/6/15.
 */
public class TestStatisticsController {
    @FXML
    private BarChart<String, Number> chart;


    public void createChart(HashMap<String, Integer> percentages,String testName){
        String title = "Grade Breakdown for " + testName;
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();

        chart.setTitle(title);

        series1.getData().add(new XYChart.Data(TestChart.firstPercentage, percentages.get(TestChart.firstPercentage)));
        series1.getData().add(new XYChart.Data(TestChart.secondPercentage, percentages.get(TestChart.secondPercentage)));
        series1.getData().add(new XYChart.Data(TestChart.thirdPercentage, percentages.get(TestChart.thirdPercentage)));
        series1.getData().add(new XYChart.Data(TestChart.fourthPercentage, percentages.get(TestChart.fourthPercentage)));
        series1.getData().add(new XYChart.Data(TestChart.fifthPercentage, percentages.get(TestChart.fifthPercentage)));

        chart.getData().add(series1);
        System.out.println("Hello");
    }
}
