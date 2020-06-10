package QuestionsTest;

import questions.GoalQuestion;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GoalQuestionTest {

    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void GoalQuestion() {
        String mockInput = TestHelper.createFakeUserInput("80");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        GoalQuestion q = new GoalQuestion(new Scanner(in));

        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertEquals(80, q.getGoal());
    }

}
