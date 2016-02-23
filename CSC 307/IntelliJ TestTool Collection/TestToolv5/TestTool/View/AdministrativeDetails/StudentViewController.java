package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.InvalidInput;
import TestTool.Model.AdministrativeDetails.StudentView;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.TestTaker;
import TestTool.Model.Resource.User;
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
import javafx.scene.text.Text;
import org.omg.PortableInterceptor.ACTIVE;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private ListView<String> listBoxStudents;
    @FXML
    private ListView<String> listBoxTests;
    @FXML
    private Pane testPopup, studentPopup;
    @FXML
    private Text courseLabel;

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



    public void displayActives(){

        TestBank tb = TestBank.getInstance();
        ActiveTestBank atb = ActiveTestBank.getInstance();


        ArrayList<String> tests = new ArrayList<String>();

        for(Test c : tb.getTestForCourse(course)) {
            tests.add(c.getName());
        }


        for(ActiveTest at : atb.getBank()){
            tests.add(at.getTest().getName() + " - " + at.getDate());
        }

        testList = FXCollections.observableArrayList();
        testList.addAll(tests);
        listBoxTests.setItems(testList);
    }



    @FXML
    public void print(){
        //done when student is selected.
        System.out.println("working");
        studentPopup.setVisible(true);

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
        else if(selected == null){
            new InvalidInput("Bad Test","You Selected An Active Test");
        }
        else {
            System.out.println("*****" + selected);
            System.out.println("*****" + date.getValue());
            System.out.println("*****" + selected.getName());
            ActiveTest test = new ActiveTest(selected, date.getValue());
            ActiveTestBank atb = ActiveTestBank.getInstance();
            atb.getBank().add(test);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Assigned Test for " + date.getValue());
            alert.showAndWait();
            testPopup.setVisible(false);
            displayActives();
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

    @FXML
    public void deleteTest() throws ParseException {

        TestBank tb = TestBank.getInstance();
        ActiveTestBank atb = ActiveTestBank.getInstance();
        ArrayList<Test> tbarr = tb.getBank();
        String test = listBoxTests.getFocusModel().getFocusedItem();

        if(tb.get(test) == null) {

            String testDate = test.substring(test.indexOf("-")+ 1).trim();
            LocalDate ld= LocalDate.parse(testDate);

            ActiveTest at = atb.get(test.substring(0, test.indexOf("-")).trim(), ld);
            atb.getBank().remove(at);

            System.out.println("Deleting Active Test: " + test);
            System.out.println(atb.getBank().toString());


        }else{
            tb.delete(tb.get(test));
            System.out.println("Deleting Test: " + test);

        }

        displayActives();
    }


    @FXML
    public void deleteStudent() {
        String student = listBoxStudents.getFocusModel().getFocusedItem();
        User toDelete = User.getUsers().get(student);
        System.out.println("Deleting Student: " + student);

        course.getStudents().remove(toDelete);
        sv.delete(student);
        System.out.println(sv.getStudentsStr());
        listBoxStudents.setItems(sv.getStudentsStr());
    }

    @FXML
    public void moreInfo(){
        System.out.println("more info");
    }

    /**
     * part of the init process
     * @param course Course used for this View
     */
    public void setCourse(Course course) {
        this.course = course;

        //populate students
        ObservableList<String> studentsStr = FXCollections.observableArrayList();

        for(TestTaker t : course.getStudents()) {
            sv.add(t);
        }
        listBoxStudents.setItems(sv.getStudentsStr());

        //populate tests
        displayActives();

        courseLabel.setText(course.getName());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        studentPopup.setVisible(false);
        sv = new StudentView();
        listBoxStudents.setItems(sv.getStudentsStr());
        listBoxTests.setItems(testList);
        testPopup.setVisible(false);
    }

}
