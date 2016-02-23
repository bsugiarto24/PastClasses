package TestTool.Model.Resource;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Course represents a CalPoly course. A Course is associated with a collection of subjects.
 * EX: CSC 103 can be associated with data structures, algorithms, etc.
 */
public class Course {
    /**
     * The identifier for the Course.
     */
    String course;

    String code;

    /**
     * The collection of Subjects associated with the Course.
     */
    Collection<Subject> subject;

    /**
     * The collection of Students associated with the Course.
     */
    ArrayList<TestTaker> students;
    
    public Course(String course) {
    	this.course = course;
        students = new ArrayList<TestTaker>();
    }

    /**
     * Sets the identifier of the Course.
     * @param course The identifier of the Course.
     */
    public void setCourse(String course) {
    	this.course = course;
    }

    /**
     * Retrieves the identifier of the Course.
     * @return The identifier of the Course.
     */
    public String getName() {
    	return course;
    }

    /**
     * Adds a Subject to be associated with the Course.
     * @param subject A Subject to be associated with the Course.
     */
    public void addSubject(Subject subject) {
    	this.subject.add(subject);
    }

    /**
     * Removes a Subject from the collection.
     * @param subject A Subject to be disassociated from the Course.
     */
    public void removeSubject(Subject subject) {
    	
    }


    public void addStudent(TestTaker student) {
        this.students.add(student);
    }


    public void removeStudent(TestTaker student) {

    }

    public ArrayList<TestTaker> getStudents(){
        return students;
    }


    public void addAccessCode(String code) {
        this.code = code;
    }

    public String getAccessCode() {
        return code;
    }

}
