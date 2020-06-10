package questions;

import data.Question;
import data.QuitException;

import java.util.Scanner;

public class FacultyQuestion extends Question {
    private Boolean ans = null;

    // EFFECTS: Constructs new FacultyQuestion.
    public FacultyQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: Interaction with user to gather information about faculty.
    @Override
    public String handleQuestion() throws QuitException {
        System.out.println("Welcome to the Course Recommendation Application:");
        System.out.println("Please indicate which faculty you are in (to quit enter quit):");
        ans = true;
        return this.getNextLineOrThrow();
    }

    // EFFECTS: Returns ans.
    public Boolean getAns() {
        return ans;
    }
}
