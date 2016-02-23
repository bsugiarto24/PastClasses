package TestTool.View.AdministrativeDetails;

import TestTool.MainApp;
import TestTool.Model.AdministrativeDetails.CourseView;
import TestTool.Model.AdministrativeDetails.InvalidInput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import TestTool.Model.Resource.*;
import javafx.scene.layout.Pane;
import sun.applet.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {


    //fields
    @FXML
    private Pane popup;
    @FXML
    private TextField name, subject, code;
    @FXML
    private ListView<String> listBoxMain;

    CourseView courses;
    CourseCollection collect = CourseCollection.getInstance();
    private MainApp mainApp;


    public void setMain(MainApp main) {
        this.mainApp = main;
    }

    @FXML
    public void print(){
        System.out.println(courses.get(listBoxMain.getFocusModel().getFocusedItem()));

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/studentview.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            StudentViewController handler = loader.getController();
            handler.setMainApp(mainApp);
            handler.setCourse(courses.get(listBoxMain.getFocusModel().getFocusedItem()));
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToStudentView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/studentview.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            StudentViewController handler = loader.getController();
            handler.setMainApp(mainApp);
            handler.setCourse(courses.get(listBoxMain.getFocusModel().getFocusedItem()));
            System.out.println("Going to course: " + listBoxMain.getFocusModel().getFocusedItem());
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addSubjectToCourse(){
        System.out.println("adding subject to course");

        if(subject.getText().equals("")) {
            new InvalidInput("Error Adding Subject To Coursee","lease Enter A Subject");
        }else {
            Course add = courses.get(listBoxMain.getFocusModel().getFocusedItem());

            add.addSubject(new Subject(subject.getText()));
            subject.clear();
        }
    }

    @FXML
    public void addCourse(){
        System.out.println("adding course");
        Course add = new Course(name.getText());
        add.addAccessCode(code.getText());

        if(name.getText().equals("")) {
            new InvalidInput("Error Adding Course","Please Enter A Name Of A Course");
        }else if(code.getText().equals("")) {
            new InvalidInput("Error Adding Course","Please Enter An Access Code");
        }else {
            courses.add(add);
            listBoxMain.setItems(courses.getCoursesStr());
            name.clear();
            code.clear();
        }
    }

    @FXML
    public void popup() {
        popup.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courses = new CourseView();
        for(Course c: collect.getAllCourseList()) {
            courses.add(c);
        }

        listBoxMain.setItems(courses.getCoursesStr());

        popup.setVisible(false);
    }
}
