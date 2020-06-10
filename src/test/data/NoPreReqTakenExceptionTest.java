package data;

import QuestionsTest.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.PreRequisiteQuestion;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.fail;

public class NoPreReqTakenExceptionTest {
    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void NoPreReqTakenTest() {
        String mockInput = TestHelper.createFakeUserInput("N");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        PreRequisiteQuestion q = new PreRequisiteQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            fail("You are unable to take this course due to missing Pre-Requisites.");
        } catch (NoPreReqTakenException ne) {
            ne.printStackTrace();
        } catch (QuitException qe) {
            qe.printStackTrace();
        }
    }

    @Test
    public void PreReqTakenTest() {
        String mockInput = TestHelper.createFakeUserInput("Y");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        PreRequisiteQuestion q = new PreRequisiteQuestion(new Scanner(in));
        try {
            q.handleQuestion();
        } catch (NoPreReqTakenException ne) {
            fail();
        } catch (QuitException qe) {
            qe.printStackTrace();
        }
    }


    @Test
    public void quitPreReqTakenTest() {
        String mockInput = TestHelper.createFakeUserInput("quit");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        PreRequisiteQuestion q = new PreRequisiteQuestion(new Scanner(in));
        try {
            q.handleQuestion();
            fail();
        } catch (NoPreReqTakenException ne) {
            ne.printStackTrace();
        } catch (QuitException qe) {
            qe.printStackTrace();
        }
    }

}
