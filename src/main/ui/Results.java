package ui;

import questions.*;
import storage.Loadable;
import storage.Saveable;
import storage.StateHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Results implements Saveable, Loadable {

    private Boolean done = true;
    protected Integer goal = 0;
    protected Integer average = 0;
    protected Integer gpa = 0;

    // EFFECTS: scanner.
    public Scanner scanner;

    public Results() throws FileNotFoundException {
        run(System.in);
    }

    // EFFECTS: Constructs a results class with goal, average and gpa.
    // MODIFIES: this.
    public Results(int goal, int average, int gpa) {
        this.scanner = new Scanner(System.in);
        this.goal = goal;
        this.average = average;
        this.gpa = gpa;
    }

    // EFFECTS: Constructs a results class with goal, average, taken prereques requirement and gpa.
    // MODIFIES: this.
    public Results(int goal, int average, int gpa, String y) {
        this.scanner = new Scanner(y);
        this.goal = goal;
        this.average = average;
        this.gpa = gpa;
    }

    public void run(InputStream stream) throws FileNotFoundException {
        while (true) {
            scanner = new Scanner(stream);
            QuestionHandler qh = new QuestionHandler();
            qh.addQuestion(new CourseInformationQuestion(scanner));
            qh.addQuestion(new FacultyQuestion(scanner));
            qh.addQuestion(new MajorQuestion(scanner));
            qh.addQuestion(new CoursesToTakeQuestion(scanner));
            qh.addQuestion(new PreRequisiteQuestion(scanner));
            qh.addQuestion(new OperationsQuestion(scanner));
            qh.addQuestion(new GoalQuestion(scanner));
            qh.handleQuestion();
            done = true;
            try {
                load("saved.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // EFFECTS: gets done fields.
    public Boolean getDone() {
        return done;
    }


// Code for displaying saving the UI inputs:
//    public void save(String s) {
//        ArrayList<String> inputs = new ArrayList<>();
//        inputs.add(faculty);
//        inputs.add(major);
//        inputs.add(uiCourseName);
//        inputs.add(takenprereq);
//        inputs.add(gpa.toString());
//        inputs.add(goal.toString());
//
//        Save store = new Save();
//        store.save("Inputs:\n" + inputs.toString());
//    }

    // EFFECTS: loads data from file location s.
    public String load(String s) throws IOException {
        String loader = "";
        String ans = "";
        System.out.println("Would you like load last result? Y/N");
        loader = scanner.nextLine();
        if (loader.equals("Y")) {
            Loadable loadable = new StateHandler();
            ans = loadable.load("saved.txt");
        }
        return ans;
    }

    // EFFECTS: saves s, l and r onto a file.
    public Boolean save(String s, String l, String r) {
        Saveable sh = new StateHandler();
        sh.save(s, r, l);
        return true;
    }
}




