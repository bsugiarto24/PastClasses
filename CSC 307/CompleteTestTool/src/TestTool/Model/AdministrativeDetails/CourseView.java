package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


/**
 * This class represents the view of courses.
 * @author bsugiarto
 *
 */
public class CourseView extends ListView{


    private ArrayList<Course> courses;
    private ObservableList<String> coursesStr;

    public CourseView() {
        courses = new ArrayList<Course>();
        coursesStr = FXCollections.observableArrayList();
    }


    /**
     * This function adds an object to the list.
     * @param obj Object to add to the list.
     * Pre: obj != null
     */
    @Override
    public void add(Object obj) {
        if(obj instanceof Course) {
            courses.add((Course) obj);
            coursesStr.add(((Course) obj).getName());
        }
    }

    @Override
    public void delete(int index) {
        courses.remove(index);
        coursesStr.remove(index);
    }

    public Course get(int index) {
        return courses.get(index);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ObservableList<String> getCoursesStr() {
        return coursesStr;
    }


    @Override
    public void display() {}

	
	/**
	 * This function sends the teacher to the test results of the course selected
	 * @param index Index to get more details.
     * Pre: index >=0 && index < list.size()
	 */
	public void moreDetails(int index) {}
	
	
	/**
	 * This function expands the selected row to show Entry Code.
	 * @param index Index to expand row for Entry Code.
	 * Pre: index >=0 && index < list.size()
     */
	public void expand(int index) {}
}
