package TestTool.View.TestBank;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.Test;
import TestTool.View.TestCreation.RanTestController;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * Created by brvo on 11/24/15.
 */
public class TestBankController {

    private MainApp mainApp;

    @FXML
    private TableView<Test> testTable;

    @FXML
    private TableColumn<Test, String> testNameColumn;

    @FXML
    private TableColumn<Test, Course> courseColumn;

    @FXML
    private TableColumn<Test, Subject> subjectColumn;

    @FXML
    private TableColumn<Test, Integer> questionsColumn;

    @FXML
    private TableColumn<Test, Integer> difficultyColumn;

    @FXML
    private TableColumn<Test, Integer> timeLengthColumn;

    @FXML
    private TextField avgDiffTF;
    @FXML
    private TextField testLengthTF;
    @FXML
    private TextField testNameTF;
    @FXML
    private ComboBox subjectCB;
    @FXML
    private ComboBox courseCB;
    @FXML
    private Button filterButton;



    public void setMain(MainApp app) {
        mainApp = app;
    }

    @FXML
    private void initialize(){
        ArrayList<Test> tests = TestBank.getInstance().getBank();
        ObservableList<Test> testList = FXCollections.observableArrayList(tests);
        testTable.setItems(testList);
        testNameColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getName());});

        courseColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getCourse());});
        subjectColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getSubject());});
        questionsColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getNumQuestions());});
        difficultyColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());});
        timeLengthColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getTimeLimit());});
    }

    public void onAdd() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestCreation/GenTest.fxml"));
        AnchorPane ranMa = (AnchorPane) loader.load();

        RanTestController testController = loader.getController();
        testController.setMain(mainApp);

        // Set new screen into center of root layout
        mainApp.rootLayout.setCenter(ranMa);

        mainApp.primaryStage.show();

    }

    public void onDelete(){
        Test test = testTable.getSelectionModel().getSelectedItem();
        if(test == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cannot delete Test");
            alert.setContentText("Please Select a Test to Delete");
            alert.showAndWait();
            return;
        }
        TestBank.getInstance().delete(test);
        testTable.setItems(FXCollections.observableArrayList(TestBank.getInstance().getBank()));
        System.out.println(test.getName());
    }
/*
    public void onFilter(){
        String name = testNameTF.getText();
        int avgDiff = Integer.valueOf(avgDiffTF.getText());
        int testLength = Integer.valueOf(testLengthTF.getText());
        String subject = (String)subjectCB.getValue();
        String course = (String)courseCB.getValue();

        ArrayList<Test> tests = TestBank.getInstance().filter(test);
    }
    */


}
