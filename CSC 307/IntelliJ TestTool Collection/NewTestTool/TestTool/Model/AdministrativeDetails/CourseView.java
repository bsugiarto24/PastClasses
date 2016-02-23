package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


/**
 * This class represents the view of courses.
 * @author bsugiarto
 *
 */
public class CourseView extends ListView{

	/* Collection of Courses */
	private CourseCollection courses;

	/* ObservableList of Course names to display */
	private ObservableList<String> coursesStr;

	/**
	 * Constructor which initilaizes the CourseView
	 */
	public CourseView() {
		courses = CourseCollection.getInstance();
		coursesStr = FXCollections.observableArrayList();
	}


	/**
	 * This function adds an object to the list.
	 * @param obj Object to add to the list.
	 * Pre: obj != null
	 */
	@Override
	public void add(Object obj) {
		/* checks if obj is not null and a Course */
		if(obj instanceof Course && obj != null) {

			/* adds course to collection and ObservableList */
			courses.addCourse((Course) obj);
			coursesStr.add(((Course) obj).getName());
		}
	}

	@Override
	/**
	 * Deletes course at index given.
	 * @param index An Int which represents the index of the course to be deleted.
	 */
	public void delete(String index) {
		System.out.println("Deleting " + index);
	}


	/**
	 * Returns the Course of the name given.
	 * @param name Name of Course to get.
	 * @return A Course
     */
	public Course get(String name) {
		return courses.findCourse(name);
	}

	/**
	 * Returns an ObserableList<String>
	 * @return An ObservableList<String> to display.
     */
	public ObservableList<String> getCoursesStr() {

		/* creates the coursesStr to return */
		coursesStr = FXCollections.observableArrayList();
		coursesStr.addAll(courses.getAllCourses());
		return coursesStr;
	}

	/**
	 * This function sends the teacher to the test results of the course selected
	 * @param index Index to get more details.
	 * Pre: index >=0 && index < list.size()
	 */
	@Override
	public void moreDetails(int index) {}


}
