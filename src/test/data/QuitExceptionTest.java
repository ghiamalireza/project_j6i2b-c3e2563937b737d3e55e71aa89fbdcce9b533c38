package data;

import QuestionsTest.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.*;
import ui.CoursesToTakeQuestion;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class QuitExceptionTest {

    private QuestionHandler question;

    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void quitIsEnteredCoursesToTake() {
        String mockInput = TestHelper.createFakeUserInput("quit");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        CoursesToTakeQuestion q = new CoursesToTakeQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            fail("Application Terminated");
        } catch (QuitException qe) {
            System.out.println("Application Terminated");
        }
    }

    @Test
    public void quitIsEnteredFaculty() {
        String mockInput = TestHelper.createFakeUserInput("quit");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        FacultyQuestion q = new FacultyQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            fail("Application Terminated");
        } catch (QuitException qe) {
            System.out.println("Application Terminated");
        }
    }

    @Test
    public void quitIsEnteredMajor() {
        String mockInput = TestHelper.createFakeUserInput("quit");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        MajorQuestion q = new MajorQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            fail("Application Terminated");
        } catch (QuitException qe) {
            assertTrue(true);
        }
    }

    @Test
    public void quitIsNotEnteredMajor() {
        String mockInput = TestHelper.createFakeUserInput("q");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        MajorQuestion q = new MajorQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            assertTrue(true);
        } catch (QuitException qe) {
            fail();
        }
    }

}



