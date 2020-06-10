package questions;

import data.Question;
import data.QuitException;

import java.util.Scanner;

public class MajorQuestion extends Question {
    private Boolean ans = null;

    // EFFECTS: Constructs new MajorQuestion.
    public MajorQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: Interaction with user to gather information about course and major.
    @Override
    public String handleQuestion() throws QuitException {
        System.out.println("What major are you in (if you are undeclared enter UD)");
        ans = true;
        return this.getNextLineOrThrow();
    }

    // EFFECTS: Returns ans.
    public Boolean getAns() {
        return ans;
    }
}


