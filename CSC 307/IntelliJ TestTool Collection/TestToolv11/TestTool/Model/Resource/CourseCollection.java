package TestTool.Model.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * The collection of Courses available. Currently, this collection is a universal representation of the Courses
 * available for one professors. However, we wish to implement this test tool for multiple professors, and as such,
 * a professor will have ownership over a CourseCollection in a future implementation. This allows our tool to
 * distinguish which professor teaches which courses.
 *
 * This is implemented using the singleton design pattern.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class CourseCollection {

    /**
     * Singleton instance of the CourseCollection.
     */
    private static CourseCollection instance = new CourseCollection();

    /**
     * The collection of Courses.
     */
    private HashMap<String, Course> courses;

    /**
     * Private constructor to instantiate the CourseCollection.
     */
    private CourseCollection() {
        courses = new HashMap<>();
    }

    /**
     * Add the given Course to the CourseCollection. The Course's name must not be the same as a Course already
     * in the collection.
     * @param course The Course to add to the collection.
     */
    public void addCourse(Course course){
        courses.put(course.getName(), course);
    }

    /**
     * Find the Course by the real-world name.
     * @param name The name of the course.
     */
    public Course findCourse(String name){
        return courses.get(name);
    }

    /**
     * Change the given old Course to the given new Course. The old and new records must not be the same. The old
     * record must already be in the CourseCollection. The new Course must meet the same conditions as for the input
     * to the addCourse operation. Typically, the user runs the findCourse operation prior to changeCourse to locate
     * an existing record to be changed.
     * @param oldC Course to replace.
     * @param newC Course to add.

       pre:
        oldC != null && newC != null && oldC.getname() == newC.getName() && !oldC.equals(newC) &&
        courses.containsValue(oldC) && newC.getName() != null && newC.getAccessCode() != null &&
        newC.getSubjects() != null && newC.getStudents() != null;

       post:
        forall ( Course c_other ;
           courses'.containsValue(c_other) iff
              c_other.equals(newC) ||
                 (courses.containsValue(c_other) &&
                    !c_other.equals(oldC)));
     */
    public void changeCourse(Course oldC, Course newC){
        if(oldC.getName().equals(newC.getName())) {
            courses.remove(oldC.getName());
            courses.put(newC.getName(), newC);
        }
    }

    /**
     * Delete the given Course from the given CourseCollection. The given Course must already be in the
     * CourseCollection. Typically the user runs the findCourse operation prior to deleteCourse to locate an existing
     * record to delete.
     * @param course The course to delete.
     */
    public void deleteCourse(Course course){
        courses.remove(course.getName());
    }

    /**
     * Gets all of the courses in an ArrayList of Strings.
     * @return The ArrayList of all courses.

       pre:
        courses != null;

       post:
        forall ( Course c_other ; courses.containsValue(c_other) ;
            return.contains(c_other.toString()));
     */
    public ArrayList<String> getAllCourses() {
        ArrayList<String> allCourses = new ArrayList<>();

        for (Course course: courses.values()) {
            allCourses.add(course.toString());
        }

        return allCourses;
    }


    /**
     * Gets all of the courses in an ArrayList of Courses.
     * @return The ArrayList of all courses.

       pre:
        courses != null;

       post:
        forall ( Course c_other ; courses.containsValue(c_other) ;
                return.contains(c_other));
     */
    public ArrayList<Course> getAllCourseList() {
        ArrayList<Course> allCourses = new ArrayList<>();

        for (Course course: courses.values()) {
            allCourses.add(course);
        }

        return allCourses;
    }


    /**
     * Gets the singleton instance of the CourseCollection.
     * @return The single HashMap instance.
     */
    public static CourseCollection getInstance() {
        return instance;
    }

    /**
     * A setter which allows all of the Courses to be initialized upon reading serialized data. Called once per launch
     * of the application.
     * @param newCourses The HashMap that represents the persisted Courses.
     */
    public void setCourses(HashMap<String, Course> newCourses){
        courses = newCourses;
    }

    /**
     * A getter which returns all of the Courses currently in the collection.
     * @return The HashMap of all Courses.
     */
    public HashMap<String, Course> getCourse(){
        return courses;
    }

    /**
     * Resets the collection of Courses -- Used during testing to blow away collection and restart.
     */
    public void reset() {
        courses = new HashMap<>();
    }
}
