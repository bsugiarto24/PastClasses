package TestTool.Model.TestCreation;

import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.TestTaker;
import TestTool.Model.TestGrading.Status;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * An active test contains the test, due date, a list of student tests,
 * and the grading status for the test.
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class ActiveTest {

    /*The test object for the active test*/
    private Test test;

    /*The due date*/
    private LocalDate date;

    /*All of the studentTests that are assigned*/
    private ArrayList<StudentTest> studentTests;

    /*The current grading status for the test */
    private Status status;

    /*This method is the constructor for ActiveTest that takes in a test and a date*/
    public ActiveTest(Test test, LocalDate date){
        this.test = test;
        this.date = date;

        /*The status defaults to NOT_STARTED*/
        this.status = Status.NOT_STARTED;

        /*StudentTests calls a method to get all of the students in a course and creates a StudentTest object for them*/
        this.studentTests = getStudentTests(test.getCourse());


    }

    /*Gets all of the students in a course and creates a StudentTest object for them
    * Then it returns an ArrayList of StudentTest
    * */
    private ArrayList<StudentTest> getStudentTests(Course course){
       //For testing purposes TODO: Remove
        if(course == null){
            return new ArrayList<StudentTest>();
        }

        /*Checks if course is empty to avoid a nullpointer exception*/
        if(course.getStudents().isEmpty()){
            return new ArrayList<StudentTest>();
        }

        /*List of testTaker objects that is a part of each course*/
        ArrayList<TestTaker> testTakers = course.getStudents();

        /*The list of students that the test is assigned to*/
        ArrayList<StudentTest> students = new ArrayList<>();

        /*Iterates through each TestTaker and then creates a new StudentTest with the this.test and the testTaker name*/
        for(TestTaker testTaker: testTakers){
            StudentTest studentTest = new StudentTest(this.test, testTaker.getName());
            students.add(studentTest);

        }
        return students;
    }

    public Test getTest() {
        return test;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<StudentTest> getStudentTests() {
        return studentTests;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
