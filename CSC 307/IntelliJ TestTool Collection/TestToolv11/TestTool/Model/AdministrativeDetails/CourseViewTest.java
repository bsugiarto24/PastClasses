package TestTool.Model.AdministrativeDetails;

/**
 * Created by bsugiarto on 12/9/15.
 */

import TestTool.Model.Resource.Course;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseViewTest {

    @Test
    public void testAdd() {
        CourseView cv = new CourseView();

        cv.add(null);
        assertEquals(cv.getCoursesStr().size(), 0);

        cv.add(new Object());
        assertEquals(cv.getCoursesStr().size(), 0);

        cv.add(new Course("Java"));
        assertEquals(cv.getCoursesStr().size(), 1);
        assertEquals(cv.getCoursesStr().get(0), "Java");
    }


    @Test
    public void testDelete() {
        CourseView cv = new CourseView();

        cv.add(new Course("Java"));
        cv.add(new Course("C"));

        assertEquals(cv.getCoursesStr().size(), 2);

        cv.delete("");
        assertEquals(cv.getCoursesStr().size(), 2);

        cv.delete("C");
        assertEquals(cv.getCoursesStr().size(), 1);

        cv.delete("Java");
        assertEquals(cv.getCoursesStr().size(), 0);
    }


    @Test
    public void testConstructor(){

        CourseView cv = new CourseView();
        assertEquals(cv.getCoursesStr().size(), 0);

    }


}
