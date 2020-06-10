package ui;

import data.NoPreReqTakenException;
import data.Question;
import data.QuitException;
import network.ReadWebPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class CourseInformationQuestion extends Question {

    private String coursecode;
    private String coursenumber;
    private String section;

    // EFFECTS: Constructs a new CourseInformationQuestion
    public CourseInformationQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: Returns course information from readWebPage.
    public String guiHandleQuestion(String cc, String cn, String s) throws IOException {
        ReadWebPage readWebPage = new ReadWebPage(cc, cn, s);
        return readWebPage.courseInformation();
    }

    @Override
    // EFFECTS: if info is "y" it asks for what course and section to return information about otherwise does nothing
    public String handleQuestion() throws QuitException, NoPreReqTakenException, IOException {
        System.out.println("For information about a course this term enter Y:");
        String info = this.getNextLineOrThrow();
        if (info.toLowerCase().equals("y")) {
            System.out.println("Enter course code letters:");
            coursecode = this.getNextLineOrThrow();
            System.out.println("Enter course number:");
            coursenumber = this.getNextLineOrThrow();
            System.out.println("Enter Section number");
            section = this.getNextLineOrThrow();
            ReadWebPage readWebPage = new ReadWebPage(coursecode, coursenumber, section);
            readWebPage.courseInformation();
        }
        return null;
    }

}
