package QuestionsTest;

import questions.MajorQuestion;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MajorQuestionTest {
    @BeforeEach
    public void runbefore() {
    }

    @Test
    public void FacultyQuestionTest() {
        String mockInput = TestHelper.createFakeUserInput("");
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        MajorQuestion q = new MajorQuestion(new Scanner(in));

        try {
            q.handleQuestion();
        } catch (QuitException qe) {
            System.out.println(qe);
        }
        assertTrue(q.getAns());
    }
}

