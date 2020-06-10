package ui;

import QuestionsTest.TestHelper;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class CoursesToTakeQuestionTest {

    @BeforeEach
    public void runbefore() {
    }


//    @Test
//    public void operationsTest() {
//        String mockInput = TestHelper.createFakeUserInput( "CPSC 210");
//        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
//        Question q = new CoursesToTakeQuestion(new Scanner(in));
//        try {
//            q.handleQuestion();
//        } catch (QuitException qe) {
//            System.out.println(qe);
//        }
//        Double expectedpredicted = (90 + 73) / 2.0;
//        //Results results = new Results();
//        assertEquals(expectedpredicted, q.operations(90, 20));
//    }
//
//    @Test
//    public void operationsTest2() {
//        String mockInput = TestHelper.createFakeUserInput("Science", "CS", "CPSC 210", "Y", "90", "20", "quit");
//        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
//        Question q = new CoursesToTakeQuestion(new Scanner(in));
//        try {
//            q.handleQuestion();
//        } catch (QuitException qe) {
//            System.out.println(qe);
//        }
//        Double expectedpredicted = (73 + 73) / 2.0;
//        //Results results = new Results();
//        assertEquals(expectedpredicted, result.operations(73, 80));
//    }

    @Test
    public void checkTestTrue() {
        String mockInput = TestHelper.createFakeUserInput("CPSC 210");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        CoursesToTakeQuestion q = new CoursesToTakeQuestion(new Scanner(in));
        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertTrue(q.check("CPSC 210"));
    }

    @Test
    public void checkTestFalse() {
        String mockInput = TestHelper.createFakeUserInput("CPSC 210");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        CoursesToTakeQuestion q = new CoursesToTakeQuestion(new Scanner(in));
        try {
            assertFalse(q.check("ASIA 310"));
            fail();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    @Test
    public void checkTestTrue2() {
        String mockInput = TestHelper.createFakeUserInput("cpsc 210");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        CoursesToTakeQuestion q = new CoursesToTakeQuestion(new Scanner(in));
        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertTrue(q.check("cpsc 210"));
    }

    @Test
    public void handleQuestionTest() {
        String s = "";
        String mockInput = TestHelper.createFakeUserInput("cpsc 210");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        CoursesToTakeQuestion q = new CoursesToTakeQuestion(new Scanner(in));
        try {
            s = q.handleQuestion();
        } catch (QuitException e) {
            e.printStackTrace();
        }
        assertEquals(s, "cpsc 210");
    }

}
