package data;


import observer.PopularCourse;

import java.io.IOException;
import java.util.Scanner;

public abstract class Question {

    protected static Integer goal = 0;

    protected static Integer average = 73;
    protected static String gpa;
    protected static String goalresult = "";
    protected static String result = "";
    protected static String newAverage = "";
    protected static String prereq = "";
    protected static double predictedAverage = 0.0;

    protected Scanner scanner;

    // EFFECTS: Sets scanner.
    public void setScanner(Scanner s) {
        scanner = s;
    }

    public abstract String handleQuestion() throws QuitException, NoPreReqTakenException, IOException;

    // EFFECTS: Checks for quit exception and returns nextLine.
    protected String getNextLineOrThrow() throws QuitException {
        String nextLine = scanner.nextLine();
        quitExceptionThrower(nextLine);
        return nextLine;
    }

    // EFFECTS: If nextLine is Equal to quit it throws QuitException otherwise does nothing.
    private void quitExceptionThrower(String nextLine) throws QuitException {
        if (nextLine.toLowerCase().equals("quit")) {
            throw new QuitException();
        }
    }

    // EFFECTS: Checks for NoPreReqTakenException and QuitException and returns nextLine.
    protected String getNextLineOrThrowPreReq() throws NoPreReqTakenException, QuitException {
        String nextLine = scanner.nextLine();
        noPreRequisiteExceptionThrower(nextLine);
        quitExceptionThrower(nextLine);
        return nextLine;
    }

    // EFFECTS: If nextLine equals to n it throws NoPreReqTakenException, otherwise does nothing.
    private void noPreRequisiteExceptionThrower(String nextLine) throws NoPreReqTakenException {
        if (nextLine.toLowerCase().equals("n")) {
            throw new NoPreReqTakenException();
        }
    }

}
