package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.TestTaking;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import TestTool.Model.TestTaking.*;
import TestTool.Model.TestCreation.*;
import javafx.scene.text.*;


import java.awt.*;
import java.util.*;
import TestTool.Model.QuestionCreation.*;



/**
 * Created by Dylan on 11/8/15.
 */
public class StudentLoginController {

    private static ArrayList<Question> question = new ArrayList<Question>();
    private static ArrayList<StudentTest> testss = new ArrayList<StudentTest>();

    private static void things() {
        for(int i = 0; i<5; i++) {
            testss.add(i, new StudentTest(question, 5, 5, "Math", "Test" + i, "Calc 1", "John"));
        }
    }

    @FXML
    private TableView<StudentTest> testTable;

    @FXML
    private TableColumn<StudentTest, String> testColumn;

    @FXML
    private TableColumn<StudentTest, Integer> timeColumn;

    @FXML
    private static Text loggedInName;

    private ObservableList<StudentTest> testChoicesList;

    private StudentTest tempTest;




    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;

    private int testCount = 0;

    public void setTestCount (int testCount) {
        this.testCount = testCount;
    }

    public void setMenutabController(MainApp mainApp) {
        this.mainApp = mainApp;
    }




    @FXML
    private void initialize() {
        things();
        ArrayList<StudentTest> assignedTest = TestTaking.getListOfAssignedTests();
        testChoicesList = FXCollections.observableArrayList();



        // changes to assigned test when done
        for (int i = 0; i < testss.size(); i++ ) {

            testChoicesList.add(testss.get(i));

            testTable.setItems(testChoicesList);
            testColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getName());});
            timeColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getTimeLimit());});
       }
    }


    @FXML
    public void onTestAttempt() {
        try {
            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingTests.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentTakingTestController controller = loader.getController();
            controller.setStudentLoginController(mainApp);

            //sends the test selected to StudentLogin.java in model
            //StudentLogin.attemptTest();


        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
