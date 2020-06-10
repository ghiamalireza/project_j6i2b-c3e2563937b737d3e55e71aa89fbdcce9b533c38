package ui;

import data.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for results
public class resultsTest {
    private Results result;

    private Course course;
    private Course courseCpsc210;
    private Course courseCpsc110;
    private Course emptycourse = new Course("", "", 0);
    private List<Course> courses = new ArrayList<>();

    // EFFECTS: Creates a fake user interaction.
    private String createFakeUserInput(String... args) {
        String result = "";
        for (String save : args) {
            result += save + "\n";
        }
        return result;
    }

    @BeforeEach
    public void runBefore() {
    }

    @Test
    public void resultTest() {
        Results results = new Results(90,70,80);
        Boolean done = results.getDone();
        assertTrue(done);
    }
}

//    public void testquit() {
//        String mockInput = createFakeUserInput("quit");
//        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
//        result = new Results(in);
//        assertTrue(result.questions1());
//
//    }
//
//
//    @Test
//    public void operationsTest() {
//        String mockInput = createFakeUserInput("Science", "CS", "CPSC 210", "Y", "90", "20", "quit");
//        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
//        result = new Results(in);
//        Double expectedpredicted = (90 + 73) / 2.0;
//        //Results results = new Results();
//        assertEquals(expectedpredicted, result.operations(90, 20));
//    }
//
//    @Test
//    public void operationsTest2() {
//        String mockInput = createFakeUserInput("Science", "CS", "CPSC 210", "Y", "90", "20", "quit");
//        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
//        result = new Results(in);
//        Double expectedpredicted = (73 + 73) / 2.0;
//        //Results results = new Results();
//        assertEquals(expectedpredicted, result.operations(73, 80));
//    }
//
//    @Test
//    public void checkTestTrue() {
//        result = new Results("CPSC 210");
//        assertTrue(result.check("CPSC 210"));
//    }
//
//    @Test
//    public void checkTestFalse() {
//        result = new Results("ASIA 310");
//        assertFalse(result.check("ASIA 310"));
//    }
//
//
//    @Test
//    public void operationTest() {
//        result = new Results(80,74,67);
//        double pa = result.operations(67,80);
//        assertEquals(pa,(67 + 74) / 2.0);
//    }
//
//}
