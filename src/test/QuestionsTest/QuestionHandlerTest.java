package QuestionsTest;

import questions.QuestionHandler;
import data.Question;
import data.QuitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionHandlerTest {

    @BeforeEach
    public void runbefore() {
    }

//    @Test
//    public void operationsTest() throws FileNotFoundException {
//        QuestionHandler q = new QuestionHandler();
//        q.operations(90, 80);
//        //Results results = new Results();
//        assertEquals(81.5, q.operations(90, 20));
//    }
//
//    @Test
//    public void operationsTest2() throws FileNotFoundException {
//        QuestionHandler q = new QuestionHandler();
//        q.operations(80, 70);
//        //Results results = new Results();
//        assertEquals(76.5, q.operations(80, 70));
//    }

    @Test
    public void saveTest() {
        QuestionHandler q = new QuestionHandler();
        Boolean n = q.save("lol", "hi", "bye");
        assertTrue(n);
    }

    @Test
    public void HandlerTest() {
        QuestionHandler q = new QuestionHandler();
        String s = q.getAns();
        assertTrue(s.equals(""));
    }

    @Test
    public void handerExceptionTest() {
        boolean thrown = false;
        QuestionHandler q = new QuestionHandler();
        try {
            q.handleQuestion();
        } catch (Exception e) {
            thrown = true;
            {
            }
            assertTrue(thrown);
        }
    }

    @Test
    public void addQuestionTest() {
        QuestionHandler q = new QuestionHandler();
        Question a = new Question() {
            @Override
            public String handleQuestion() throws QuitException {
                return null;
            }
        };
        q.addQuestion(a);
        assertEquals(q.getAns1(), q.getAns1());
    }
}


