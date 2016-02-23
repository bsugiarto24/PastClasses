package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.TestTaker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class represents the view of Students.
 *
 * Created by Bryan Sugiarto (bsugiart@calpoly.edu) on 11/2/15.
 */
public class StudentView extends ListView{

	/* A hashmap mapping the TestTaker's name to the actual TestTaker */
	private HashMap<String,TestTaker> students;

	/* A list which is used to display later on */
	private ObservableList<String> studentsStr;

	/**
	 * Constructs a new Student View
	 */
	public StudentView() {
		students = new HashMap<String, TestTaker>();
		studentsStr = FXCollections.observableArrayList();
	}


	/**
	 * This function adds an object to the list.
	 * @param obj Object to add to the list.
	 * Pre: obj != null
	 */
	@Override
	public void add(Object obj) {
		/* Check if obj is not null and a TestTaker */
		if(obj instanceof TestTaker && obj != null) {
			TestTaker add = (TestTaker) obj;

			/* Adds TestTaker to hashmap */
			students.put(add.getName(), add);

			/* Adds TestTaker to Obserable ArrayList */
			studentsStr.add(((TestTaker) obj).getName());
		}
	}

	@Override
	/**
	 * Deletes TestTaker with name given.
	 * @param name A String name of the TestTaker to be deleted.
	 */
	public void delete(String name) {
		for(int i = 0; i < studentsStr.size(); i++){
			if(studentsStr.get(i).equals(name))
				studentsStr.remove(i);
		}
	}


	/**
	 * Returns the TestTaker of the given name.
	 * @param name A String of the TestTaker name.
	 * @return The TestTaker returned of given name.
     */
	public TestTaker get(String name) {
		return students.get(name);
	}


	/**
	 * Returns an ObsevrableList to display students.
	 * @return an ObservableList<String> of student names
     */
	public ObservableList<String> getStudentsStr() {
		return studentsStr;
	}


}
