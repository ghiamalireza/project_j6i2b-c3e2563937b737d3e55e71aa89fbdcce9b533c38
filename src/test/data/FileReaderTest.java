package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {
    private FileReader fileReader;
    private Course courseCpsc210;
    private List<Course> courses = new ArrayList<>();

    @BeforeEach
    public void runBefore() {
    }

    @Test
    public void testGetCourseFromFileEmpty() {
        fileReader = new FileReader();
        assertFalse(courses == fileReader.getCoursesFromFile());

    }

    @Test
    public void testGetCourseFromFile() {
        fileReader = new FileReader();
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        assertEquals(fileReader.getCoursesFromFile().size(), 15);
    }

    @Test
    public void testGetCourseFromFile2() {

        fileReader = new FileReader();
        courseCpsc210 = new Course(null, null, null);
        try {
            fileReader.getCoursesFromFile();
        } catch (Exception e) {
            fail();
        }
        int length = fileReader.getCoursesFromFile().size();
        assertEquals(15, length);
    }


    @Test
    public void getCourseFromFileTest() {
        fileReader = new FileReader();
        List<Course> list = fileReader.getCoursesFromFile();
        List<Course> answer = new ArrayList<Course>();
        assertFalse(list.isEmpty());
    }

    @Test
    public void addCourseTest() {
        Course course = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        FileReader fileReader = new FileReader();
        try {
            fileReader.addCourse(course);
            fail();
        } catch (NullPointerException e) {
        }
    }


    @Test
    public void lineReaderTest() {
        FileReader fileReader = new FileReader();
        String[] lines = new String[1];
        lines[0] = "CPSC 210|CPSC 107 or CPSC 110|73";
        List<Course> courses = new ArrayList<>();
        courseCpsc210 = new Course("CPSC 210", "CPSC 107 or CPSC 110", 73);
        fileReader.lineReader(lines,courses);
        assertEquals(courses.get(0),courseCpsc210);
    }
}
