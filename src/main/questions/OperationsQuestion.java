package questions;

import data.Question;
import data.QuitException;

import java.util.Scanner;

public class OperationsQuestion extends Question {

    private Integer ans = 0;

    // EFFECTS: Constructs new OperationsQuestion.
    public OperationsQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: Interaction with user to gather information about gpa and course goal.
    @Override
    public String handleQuestion() throws QuitException {
        System.out.println("What is your average in percentage");
        gpa = this.getNextLineOrThrow();
        System.out.println("You have entered " + gpa);
        ans = Integer.parseInt(gpa);
        return gpa;
    }

    // EFFECTS: Returns gpa.
    public Integer getGpa() {
        return ans;
    }

}
