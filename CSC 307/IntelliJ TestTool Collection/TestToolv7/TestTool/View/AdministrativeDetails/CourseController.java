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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import TestTool.Model.Resource.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
    @FXML
    private Text couseName, addSubject;
    @FXML
    private Button delete, submit, delete1, goToCourse;

    CourseView courses;
    CourseCollection collect;
    private MainApp mainApp;
    private boolean isStudent = false;

    public void setMain(MainApp main) {
        this.mainApp = main;
    }

    @FXML
    public void print(){
        System.out.println("does something");

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
    /**
     * Switches to Student View of Selected Course
     */
    public void goToStudentView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/studentview.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            StudentViewController handler = loader.getController();
            handler.setMainApp(mainApp);
            System.out.println(collect.getAllCourses());
            handler.setCourse(collect.findCourse(listBoxMain.getFocusModel().getFocusedItem()));
            System.out.println("Going to course: " + listBoxMain.getFocusModel().getFocusedItem());
            mainApp.rootLayout.setCenter(newScreen);
            mainApp.primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteCourse() {
        System.out.println("Deleting Course");
        User loggedIn = User.getUserLoggedIn();

        String courseSelected = listBoxMain.getFocusModel().getFocusedItem();
        System.out.println(courseSelected);

        loggedIn.getCourses().remove(collect.findCourse(courseSelected));
        courses.delete(courseSelected);

        System.out.println(loggedIn.getCourses());
        listBoxMain.setItems(courses.getCoursesStr());

        popup.setVisible(false);
    }

    @FXML
    public void deleteCourseTeacher(){
        System.out.println("Deleting Course");
        User loggedIn = User.getUserLoggedIn();

        Course courseSelected = collect.findCourse(listBoxMain.getFocusModel().getFocusedItem());
        System.out.println(courseSelected);

        courses.delete(courseSelected.getName());
        collect.deleteCourse(courseSelected);

        System.out.println(collect.getAllCourses());
        listBoxMain.setItems(courses.getCoursesStr());

        popup.setVisible(false);
    }

    @FXML
    public void addSubjectToCourse(){
        System.out.println("adding subject to course");

        if(subject.getText().equals("")) {
            new InvalidInput("Error Adding Subject To Course","Please Enter A Subject");
        }else {
            Course add = collect.findCourse(listBoxMain.getFocusModel().getFocusedItem());
            Subject sub = new Subject(subject.getText());

            //subject doesn't exist
            if(SubjectCollection.getInstance().findSubject(sub.getName()) == null) {
                SubjectCollection.getInstance().addSubject(sub);
            }

            add.addSubject(SubjectCollection.getInstance().findSubject(sub.getName()));

            subject.clear();
        }
    }

    @FXML
    public void addCourse(){
        System.out.println("adding course");

        if(isStudent) {
            boolean success = false;
            if (code.getText().equals(""))
                new InvalidInput("Error Adding Course", "Please An Access Code");
            else {
                String acode = code.getText();
                if(collect.getAllCourseList() != null) {
                    for (Course c : collect.getAllCourseList()) {
                        if (c.getAccessCode().equals(acode) && !c.getStudents().contains(User.getUserLoggedIn())) {
                            c.addStudent((TestTaker) User.getUserLoggedIn());
                            courses.add(c);
                            code.clear();
                            listBoxMain.setItems(courses.getCoursesStr());
                            success = true;
                        }
                    }
                    if(!success)
                        new InvalidInput("Error Adding Course", "Invalid Access Code");
                }
            }
        }else {
            Course add = new Course(name.getText());
            add.addAccessCode(code.getText());
            if (name.getText().equals("")) {
                new InvalidInput("Error Adding Course", "Please Enter A Name Of A Course");
            } else if (code.getText().equals("")) {
                new InvalidInput("Error Adding Course", "Please Enter An Access Code");
            } else {
                courses.add(add);
                collect.addCourse(add);
                listBoxMain.setItems(courses.getCoursesStr());
                name.clear();
                code.clear();
            }
        }
    }

    @FXML
    public void popup() {
            popup.setVisible(true);

            if(isStudent){
                addSubject.setVisible(false);
                submit.setVisible(false);
                subject.setVisible(false);
                delete.setVisible(true);
                delete1.setVisible(false);
                goToCourse.setVisible(false);
            }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delete.setVisible(false);
        collect = CourseCollection.getInstance();

        if(User.getUserLoggedIn() instanceof TestTaker)
            isStudent = true;

        System.out.println(isStudent);
        courses = new CourseView();

        if(isStudent) {
            name.setVisible(false);
            couseName.setVisible(false);
            for(Course c: User.getUserLoggedIn().getCourses())
                courses.add(c);
        }
        else {
            for(Course c: collect.getAllCourseList()) {
                courses.add(c);
            }
        }

        listBoxMain.setItems(courses.getCoursesStr());
        popup.setVisible(false);
    }
}
