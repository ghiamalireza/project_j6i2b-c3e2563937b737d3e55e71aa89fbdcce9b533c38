package questions;

import data.Question;
import data.QuitException;

import java.util.Scanner;

public class GoalQuestion extends Question {

    private Integer ans = 0;

    // EFFECTS: Constructs new GoalQuestion.
    public GoalQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: Asks for goal and returns goal.
    // MODIFIES: this.
    public String handleQuestion() throws QuitException {
        System.out.println("What is your goal in this course");
        String goal = this.getNextLineOrThrow();
        System.out.println("You have entered " + goal);
        ans = Integer.parseInt(goal);
        return goal;
    }

    // EFFECTS: returns goal.
    public Integer getGoal() {
        return ans;
    }
}
