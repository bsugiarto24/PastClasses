package TestTool.Model.Resource;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Course represents a CalPoly course. A Course is associated with a collection of subjects.
 * EX: CSC 103 can be associated with data structures, algorithms, etc.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class Course {
    /**
     * The identifier for the Course.
     */
    String course;

    /**
     * The access code of a course. Acts as a permission number.
     */
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
        subject = new ArrayList<Subject>();
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
        this.subject.remove(subject);
    }


    /**
     * Adds student to the course.
     * @param student A TestTaker to be added to the course.
     */
    public void addStudent(TestTaker student) {
        this.students.add(student);
        student.getCourses().add(this);
    }


    /**
     * Returns ArrayList of students.
     * @return ArrayList of TestTakers associated to course.
     */
    public ArrayList<TestTaker> getStudents(){
        return students;
    }

    /**
     * Assigns a code to the course.
     * @param code A String used to add this course.
     */
    public void addAccessCode(String code) {
        this.code = code;
    }

    /**
     * Returns the Access Code of the course.
     * @return A String of the Access Code.
     */
    public String getAccessCode() {
        return code;
    }

    /**
     * Returns the Course name.
     * @return Name of Course.
     */
    public String toString() {
        return course;
    }

    /**
     * Removes given student from the Course.
     * @param student A TestTaker to remove from the Course.
     */
    public void removeStudent(TestTaker student) {
        this.students.remove(student);
    }


}
