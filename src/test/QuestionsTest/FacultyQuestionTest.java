package QuestionsTest;

import questions.FacultyQuestion;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacultyQuestionTest {

    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void FacultyQuestionTest() {
        String mockInput = TestHelper.createFakeUserInput("");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        FacultyQuestion q = new FacultyQuestion(new Scanner(in));

        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertTrue(q.getAns());
    }
}
