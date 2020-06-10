package QuestionsTest;

import data.NoPreReqTakenException;
import questions.PreRequisiteQuestion;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreRequisiteQuestionTest {
    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void PreRequisiteQuestionTest() {
        String mockInput = TestHelper.createFakeUserInput("Y");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        PreRequisiteQuestion q = new PreRequisiteQuestion(new Scanner(in));

        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        } catch (NoPreReqTakenException e) {
            System.out.println(e);
        }
        assertTrue("Y".equals(q.getTakenPreReq()));
    }
}
