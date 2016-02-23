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
        System.out.println("deleting course: " + course.getName());
        System.out.println(courses);
        courses.remove(course.getName());
        System.out.println(courses);
    }

    /**
     * Gets all of the courses in an ArrayList of Strings.
     * @return The ArrayList of all courses.
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

    public void setCourses(HashMap<String, Course> course){
        this.courses = course;
    }

    public HashMap<String, Course> getCourse(){
        return this.courses;
    }
}
