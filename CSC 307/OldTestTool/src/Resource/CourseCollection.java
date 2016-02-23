package Resource;

import java.util.Collection;

/**
 * The collection of Courses available. Currently, this collection is a universal representation of the Courses
 * available for one professors. However, we wish to implement this test tool for multiple professors, and as such,
 * a professor will have ownership over a CourseCollection in a future implementation. This allows our tool to
 * distinguish which professor teaches which courses.
 */
public abstract class CourseCollection {
    /**
     * The collection of Courses.
     */
    Collection<Course> courses;

    /**
     * Add the given Course to the CourseCollection. The Course's name must not be the same as a Course already
     * in the collection.
     * @param course The Course to add to the collection.
     */
    abstract void addCourse(Course course);

    /**
     * Find the Course by the real-world name.
     * @param name The name of the course.
     */
    abstract void findCourse(String name);

    /**
     * Change the given old Course to the given new Course. The old and new records must not be the same. The old
     * record must already be in the CourseCollection. The new Course must meet the same conditions as for the input
     * to the addCourse operation. Typically, the user runs the findCourse operation prior to changeCourse to locate
     * an existing record to be changed.
     * @param oldC Course to replace.
     * @param newC Course to add.
     */
    abstract void changeCourse(Course oldC, Course newC);

    /**
     * Delete the given Course from the given CourseCollection. The given Course must already be in the
     * CourseCollection. Typically the user runs the findCourse operation prior to deleteCourse to locate an existing
     * record to delete.
     * @param course The course to delete.
     */
    abstract void deleteCourse(Course course);
}
