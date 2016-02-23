package TestTool.Model.Resource;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgolahi on 12/9/15.
 */
public class CourseCollectionTest {

    /**
     * Resets the CourseCollection (to remove conflicts) and then adds 2 Courses - CPE101 and CPE 102.
     */
    @Before
    public void init() {
        CourseCollection.getInstance().reset();
        Course CPE101 = new Course("CPE 101");
        CPE101.addAccessCode("101");
        CourseCollection.getInstance().addCourse(CPE101);

        Course CPE102 = new Course("CPE 102");
        CPE102.addAccessCode("102");
        CourseCollection.getInstance().addCourse(CPE102);
    }

    /**
     * Resets the CourseCollection to avoid conflicts in between tests.
     */
    @After
    public void cleanup() {
        CourseCollection.getInstance().reset();
    }

    @Test
    public void testAdd() {
        /*Create a new course*/
        Course newCourse = new Course("Test Course");
        newCourse.addAccessCode("12345");
        /*Copy the old collection to use for verification*/
        HashMap<String, Course> oldCollection = new HashMap<>(CourseCollection.getInstance().getCourse());

        /*Add the new Course*/
        CourseCollection.getInstance().addCourse(newCourse);
        /*Verify the new Course has been added*/
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(newCourse));
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsKey(newCourse.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(entry.getValue()));
        }
    }

    @Test
    public void testChangeCourseValid() {
        /*Find an existing course with a given name*/
        Course oldC = CourseCollection.getInstance().findCourse("CPE 101");
        /*Create a new course with the same name*/
        Course newC = new Course("CPE 101");
        newC.addAccessCode("123");
        /*Copy the old collection to use for verification*/
        HashMap<String, Course> oldCollection = new HashMap<>(CourseCollection.getInstance().getCourse());

        CourseCollection.getInstance().changeCourse(oldC, newC);
        /*Verify the new Course has been added*/
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(newC));
        /*Verify the old course has been deleted*/
        Assert.assertFalse(CourseCollection.getInstance().getCourse().containsValue(oldC));
        /*Verify the key (which should be the same as the old course) still exists*/
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsKey(newC.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            if (!entry.getValue().equals(oldC)) {
                Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(entry.getValue()));
            }
        }
    }

    @Test
    public void testChangeCourseInvalid() {
        /*Find an existing course with a given name*/
        Course oldC = CourseCollection.getInstance().findCourse("CPE 101");
        /*Create a new course with a different name*/
        Course newC = new Course("CPE 103");
        newC.addAccessCode("103");
        /*Copy the old collection to use for verification*/
        HashMap<String, Course> oldCollection = new HashMap<>(CourseCollection.getInstance().getCourse());

        CourseCollection.getInstance().changeCourse(oldC, newC);
        /*Verify the new Course has not been added*/
        Assert.assertFalse(CourseCollection.getInstance().getCourse().containsValue(newC));
        Assert.assertFalse(CourseCollection.getInstance().getCourse().containsKey(newC.toString()));
        /*Verify the old Course has persisted*/
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(oldC));
        Assert.assertTrue(CourseCollection.getInstance().getCourse().containsKey(oldC.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(entry.getValue()));
        }
    }

    @Test
    public void testGetAllCourses() {
        ArrayList<String> allCoursesString = CourseCollection.getInstance().getAllCourses();
        /*Verify all of the collection's data has been pulled*/
        for (String course : allCoursesString) {
            Assert.assertTrue(CourseCollection.getInstance().getCourse().containsKey(course));
        }
    }

    @Test
    public void testGetAllCourseList() {
        ArrayList<Course> allCoursesString = CourseCollection.getInstance().getAllCourseList();
        /*Verify all of the collection's data has been pulled*/
        for (Course course : allCoursesString) {
            Assert.assertTrue(CourseCollection.getInstance().getCourse().containsValue(course));
        }
    }
}
