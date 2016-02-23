package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.InvalidInput;
import TestTool.Model.AdministrativeDetails.StudentView;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.TestTaker;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.omg.PortableInterceptor.ACTIVE;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private ListView<String> listBoxStudents;
    @FXML
    private ListView<String> listBoxTests;
    @FXML
    private Pane testPopup;

    @FXML
    private DatePicker date;


    private MainApp mainApp;
    private Course course;
    private StudentView sv;

    //ObservableList<String> listItems = FXCollections.observableArrayList();
    ObservableList<String> testList = FXCollections.observableArrayList();



    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }



    @FXML
    public void print(){
        //done when student is selected.
        System.out.println("working");
    }

    @FXML
    public void testSelection(){
        System.out.println("test click");
        testPopup.setVisible(true);
        // done when test is selected
    }

    @FXML
    public void assignTest(){

        TestBank bank = TestBank.getInstance();
        Test selected = bank.get(listBoxTests.getFocusModel().getFocusedItem());

        if(date.getValue() == null) {
            new InvalidInput("No Date Entered","Please Enter a Date");
        }
        else {
            ActiveTest test = new ActiveTest(selected, date.getValue());
            ActiveTestBank atb = ActiveTestBank.getInstance();
            atb.getBank().add(test);
        }

    }

    @FXML
    public void back() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/CourseView.fxml"));
        AnchorPane newScreen = (AnchorPane) loader.load();
        CourseController handler = loader.getController();
        handler.setMain(mainApp);
        mainApp.rootLayout.setCenter(newScreen);
        mainApp.primaryStage.show();
    }

    public void setCourse(Course course) {
        this.course = course;

        //populate students
        ObservableList<String> studentsStr = FXCollections.observableArrayList();

        for(TestTaker t : course.getStudents()) {
            sv.add(t);
        }
        sv.add(new TestTaker("Bryan", "Bryan", "Bryan"));
        listBoxStudents.setItems(sv.getStudentsStr());


        //populate tests
        TestBank tb = TestBank.getInstance();
        ArrayList<String> tests = new ArrayList<String>();

        for(Test c : tb.getTestForCourse(course)) {
            tests.add(c.getName());
        }

        tests.add("midterm");
        testList.addAll(tests);
        listBoxTests.setItems(testList);
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sv = new StudentView();
        listBoxStudents.setItems(sv.getStudentsStr());
        listBoxTests.setItems(testList);
        testPopup.setVisible(false);
    }

}
