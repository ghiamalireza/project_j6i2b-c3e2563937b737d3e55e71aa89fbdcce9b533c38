package QuestionsTest;

import questions.OperationsQuestion;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationQuestionTest {

    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void GoalQuestion() {
        String mockInput = TestHelper.createFakeUserInput("90");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        OperationsQuestion q = new OperationsQuestion(new Scanner(in));

        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertEquals(90, q.getGpa());
    }
}
