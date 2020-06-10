package observer;

import data.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopularCourseTest {

    @Test
    void popularCourseTest() {
        PopularCourse popularCourse = new PopularCourse();
        Course course = new Course("CPSC 210", "", 0);
        Course course1 = new Course("CPSC 110", "", 0);
        popularCourse.addObserver(course);
        popularCourse.addObserver(course1);
        popularCourse.notifyObservers(course);
        popularCourse.notifyObservers(course1);
        assertEquals(popularCourse.getObservers().size(), 2);
    }
}