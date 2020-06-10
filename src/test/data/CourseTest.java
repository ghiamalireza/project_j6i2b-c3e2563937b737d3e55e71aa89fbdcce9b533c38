package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    private Course courseCpsc210;
    private Course courseCpsc110;
    private Course emptycourse = new Course("", "", 0);
    private List<Course> courses = new ArrayList<>();

    @BeforeEach
    public void runBefore() {
        course = new Course("", "", 0);
    }

    @Test
    public void testEmptyCourse() {
        assertTrue(emptycourse.getName().equals(course.getName()));
        assertTrue(emptycourse.getPreReqCourses().equals(course.getPreReqCourses()));
        assertEquals(emptycourse.getAverage(), (course.getAverage()));
    }

    @Test
    public void testOneCourse() {
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        assertTrue("CPSC 210".equals(courseCpsc210.getName()));
        assertTrue("CPSC 107 or CPSC 110".equals(courseCpsc210.getPreReqCourses()));
        assertEquals(73, (courseCpsc210.getAverage()));
    }


    @Test
    public void testListOfCourses() {
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        courseCpsc110 = new Course("CPSC 110", "No Prerequisites", 73);
        courses.add(courseCpsc110);
        courses.add(courseCpsc210);
        assertTrue(courses.contains(courseCpsc110));
        assertTrue(courses.contains(courseCpsc210));
    }

    @Test
    public void equalsTest() {
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        courseCpsc110 = new Course("CPSC 110", "No Prerequisites", 73);
        Course courseDemo = new Course("CPSC 110", "No Prerequisites", 73);
        assertFalse(courseCpsc110.equals(courseCpsc210));
        assertFalse(courseCpsc210.equals(courseCpsc110));
        assertTrue(courseDemo.equals(courseCpsc110));
        assertTrue(courseCpsc110.equals(courseDemo));
    }

    @Test
    public void hashCodeTest(){
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        courseCpsc110 = new Course("CPSC 110", "No Prerequisites", 73);
        Object demo = courseCpsc110.hashCode();
        Object demo1 = courseCpsc210.hashCode();
    }

    @Test
    public void addFileReaderTest(){
        Course course = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        FileReader fileReader = new FileReader();
        try {
            course.addFileReader(fileReader);
            fail();
        }catch (NullPointerException e){
        }
    }
}

