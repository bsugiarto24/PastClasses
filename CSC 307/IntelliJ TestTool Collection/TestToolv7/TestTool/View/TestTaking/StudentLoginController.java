package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.TestTaking;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import TestTool.Model.TestTaking.*;
import TestTool.Model.TestCreation.*;
import javafx.scene.layout.StackPane;
import javafx.scene.*;


import java.util.*;
import TestTool.Model.QuestionCreation.*;
import javafx.scene.text.Font;


/**
 * Created by Dylan on 11/8/15.
 */
public class StudentLoginController {

    private static ArrayList<Question> question = new ArrayList<Question>();
    private static ArrayList<StudentTest> testss = new ArrayList<StudentTest>();
    private static int temp = 0;




    @FXML
    private TableView<StudentTest> testTable;

    @FXML
    private TableColumn<StudentTest, String> testColumn;

    @FXML
    private TableColumn<StudentTest, Integer> timeColumn;

    @FXML
    private StackPane loggedInName;

    private ObservableList<StudentTest> testChoicesList;




    FXMLLoader loader = new FXMLLoader();
    public BorderPane rootLayout;

    private MainApp mainApp;

    public void setMenutabController(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    @FXML
    private void initialize() {


        TestTaking.initialize();
        //Label name = new Label(StudentLogin.getStudentName());
        Label name = new Label(StudentLogin.getStudentName());
        name.setFont(Font.font(40));
        loggedInName.getChildren().add(name);

        //ArrayList<StudentTest> assignedTest = TestTaking.getStudentAssignedTests();
        testChoicesList = FXCollections.observableArrayList();

        // changes to assigned test when done
        /*if (StudentLogin.getStudentAssignedTests().size() > 0) {
            for (int i = 0; i < StudentLogin.getStudentAssignedTests().size(); i++) {
                testChoicesList.add(StudentLogin.getStudentAssignedTests().get(i));
            }
        }
        else {
            testChoicesList.clear();
        }*/
        testTable.setItems(testChoicesList);
        testColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getName());});
        timeColumn.setCellValueFactory(c -> {return new ReadOnlyObjectWrapper<>(c.getValue().getTimeLimit());});
    }


    @FXML
    public void onTestAttempt() {
        int selectedTestNumber;
        try {


            //gets selected test number
            selectedTestNumber = testTable.getSelectionModel().getSelectedIndex();
            StudentLogin.attemptTest(selectedTestNumber);



            loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingTests.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();

            StudentTakingTestController controller = loader.getController();
            controller.setStudentLoginController(mainApp);



        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
