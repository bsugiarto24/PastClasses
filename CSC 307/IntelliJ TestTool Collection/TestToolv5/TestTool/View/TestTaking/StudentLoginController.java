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




    private static void things() {
        temp = 1;

        ArrayList<String>options = new ArrayList<String>();
        options.add(0, "target");
        options.add(1, "sears");
        options.add(2, "costco");
        options.add(3, "safeway");

        Question question1 = new TrueFalse();
        question1.setQuestion("Are dinasaurs purple and green?");
        Question question2 = new TrueFalse();
        question2.setQuestion("Is string a primitive type?");


        Question question4 = new MultipleChoice();
        ((MultipleChoice)question4).setOption(options);
        ((MultipleChoice)question4).setQuestion("What is your favorite store?");
        Question question5 = new MultipleChoice();
        ((MultipleChoice)question4).setOption(options);
        ((MultipleChoice)question4).setQuestion("Where do you shop?");

        Question question6 = new FreeResponse();
        question6.setQuestion("Type hello?");
        Question question7 = new FreeResponse();
        question6.setQuestion("Type sup");




        question.add(0, question1);
        question.add(1, question2);
        question.add(2, question4);
        question.add(3, question5);
        question.add(4, question6);
        question.add(5, question7);


        testss.add(0, new StudentTest(question, 5, 20, "Math", "Test 9000", "Calc 103", "John"));
        testss.add(1, new StudentTest(question, 5, 30, "Math", "Test 2", "Calc 103", "John"));
        testss.add(2, new StudentTest(question, 5, 40, "Math", "Test 3", "Calc 103", "John"));
        testss.add(3, new StudentTest(question, 5, 50, "Math", "Test 4", "Calc 103", "John"));
        testss.add(4, new StudentTest(question, 5, 60, "Math", "Test 5", "Calc 103", "John"));

    }

    @FXML
    private TableView<StudentTest> testTable;

    @FXML
    private TableColumn<StudentTest, String> testColumn;

    @FXML
    private TableColumn<StudentTest, Integer> timeColumn;

    @FXML
    private StackPane loggedInName;

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


        //Label name = new Label(StudentLogin.getStudentName());
        Label name = new Label("Dylan");
        name.setFont(Font.font(40));
        loggedInName.getChildren().add(name);

        //ArrayList<StudentTest> assignedTest = TestTaking.getStudentAssignedTests();
        testChoicesList = FXCollections.observableArrayList();



        if(temp == 0) {
            things();
        }


        // changes to assigned test when done
        for (int i = 0; i < testss.size(); i++ ) {

            testChoicesList.add(testss.get(i));

       }
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
            System.out.println("Test Selected: " + selectedTestNumber);
            //StudentLogin.attemptTest(selectedTestNumber); WILL USE


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
