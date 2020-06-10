package questions;

import data.NoPreReqTakenException;
import data.Question;
import data.QuitException;

import java.util.Scanner;

public class PreRequisiteQuestion extends Question {

    // EFFECTS: Constructs new PreRequisiteQuestion.
    public PreRequisiteQuestion(Scanner s) {
        this.setScanner(s);
    }

    private String ans = "";

    // EFFECTS: Interaction with user to gather information about taken prerequisites.
    @Override
    public String handleQuestion() throws QuitException, NoPreReqTakenException {
        System.out.println("Have you taken all of these prerequisites? (Y/N)" + "\n" + prereq);

        String takenPreReq = this.getNextLineOrThrowPreReq();
        System.out.println("You have entered " + takenPreReq);
        ans = takenPreReq;
        return takenPreReq;
    }

    // EFFECTS returns ans.
    public String getTakenPreReq() {
        return ans;
    }

}
