package questions;

import data.*;
import observer.CourseObserver;
import storage.Saveable;
import storage.StateHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionHandler extends Question {

    private String ans = "";
    private Question ans1;
    private List<Question> questions = new ArrayList<>();
    private String string;

    public Scanner scanner;

    public static final String ABOVE_CLASS_AVERAGE = "The goal is above the class average.";
    public static final String BELOW_CLASS_AVERAGE = "The goal is obtainable.";

    // EFFECTS: Constructs a new QuestionHandler
    public QuestionHandler() {
    }

    // EFFECTS: Adds question to list of questions.
    public void addQuestion(Question q) {
        questions.add(q);
        ans1 = q;
    }

    // EFFECTS: Gets ans1.
    public Question getAns1() {
        return ans1;
    }

    // EFFECTS: creates new list of answers and checks exceptions returns ans.
    public String handleQuestion() throws FileNotFoundException {
        List<String> answers = new ArrayList<>();
        exceptionHandler(answers);
        operations(Integer.parseInt(gpa), goal);
        return ans;
    }

    // EFFECTS: Checks for exceptions from list of answers.
    private void exceptionHandler(List<String> answers) {
        for (Question q : questions) {
            try {
                String answer = q.handleQuestion();
                answers.add(answer);
            } catch (QuitException qe) {
                System.out.println("Application Terminated");
                System.exit(0);
            } catch (NoPreReqTakenException e) {
                System.out.println("You are unable to take this course due to missing Pre-Requisites.");
            } catch (NullPointerException e) {
                System.out.println("This course will be added soon");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("To quit application enter 'quit'");
            }
        }
    }

    public String getAns() {
        return ans;
    }


    // EFFECTS: Recommends course and produces predicted grade average.
    // MODIFIES: this
    public String operations(Integer gpa, Integer goal) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("result.txt");
        System.setOut(fileStream);
        predictedAverage = (gpa + average) / 2.0;
        newAverage = "New Predicted grade average: " + predictedAverage;
        goalAnalyser(goal);
        averageAnalyser(gpa);
        System.out.println(goalresult + "\n" + result + "\n" + newAverage + "\n");
        save(goalresult, result, newAverage);
        return readingCourseFinderFile("/result.txt");
    }

    // EFFECTS: Analyses the average compared to predicted and returns result
    public String averageAnalyser(Integer gpa) {
        if (predictedAverage >= gpa) {
            result = " Your average will increase due to course average. Course is recommended.";
        } else {
            result = " Your average will drop. The course is not recommended.";
        }
        return readingCourseFinderFile("/averageAnalysis.txt");
    }

    // EFFECTS: Analyses the goal compared to course average and returns result
    public String goalAnalyser(Integer goal) {
        if ((goal >= average)) {
            goalresult = ABOVE_CLASS_AVERAGE;
            newAverage = " New Predicted grade average: " + predictedAverage;
        } else {
            goalresult = BELOW_CLASS_AVERAGE;
            newAverage = " New Predicted grade average: " + predictedAverage;
        }
        return readingCourseFinderFile("/goalAnalysis.txt");
    }

    // EFFECTS: Reads given file name.
    public String readingCourseFinderFile(String s) {
        FileReader fileReader = new FileReader();
        try {
            string = String.valueOf(fileReader.readFinder(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    // EFFECTS: Saves three strings.
    public Boolean save(String s, String l, String r) {
        Saveable sh = new StateHandler();
        sh.save(s, r, l);
        return true;
    }

    // EFFECTS: Sets average to given integer.
    public static void setAverage(Integer average) {
        Question.average = average;
    }

    // EFFECTS: Sets goal to given integer.
    public static void setGoal(Integer goal) {
        Question.goal = goal;
    }

    // EFFECTS: Gets prereq.
    public String getPreReqs() {
        return prereq;
    }

}
