package ui;

import data.Course;
import data.FileReader;
import data.Question;
import data.QuitException;
import observer.CourseObserver;
import observer.PopularCourse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CoursesToTakeQuestion extends Question {

    private Course course1 = new Course("", "", 0);
    private Map<Integer, Course> courseMap = new HashMap<>();
    private String selectedCourse = "";
    private Integer avg = 0;

    // EFFECTS: Constructs a new CoursesToTakeQuestion.
    // Requires: Scanner.
    public CoursesToTakeQuestion(Scanner s) {
        this.setScanner(s);
    }

    // EFFECTS: sets selectedcourse to new course name.
    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    @Override
    // EFFECTS: gets what course is wanted and checks for the course.
    public String handleQuestion() throws QuitException {
        System.out.println("What course are you planning to take? (Please enter in course code format)");
        selectedCourse = this.getNextLineOrThrow();
        System.out.println("You have selected " + selectedCourse);
        check(selectedCourse);
        return selectedCourse;
    }

    // MODIFIES: this
    // EFFECTS: String uiCourseName is checked in list of courses and outputs course average and prerequisites
    public boolean check(String uiCourseName) {
        Boolean checkresult = false;
        FileReader fileReader = new FileReader();
        List<Course> courses = fileReader.getCoursesFromFile();
        checkresult = courseFinder(uiCourseName, checkresult, courses);
        Course course = new Course("", "", 0);
        course.addObserver(course1);
        course.notifyObservers(course1);
        nonActiveCourse(checkresult);
        return checkresult;
    }

    // EFFECTS: Gets avg.
    public Integer getAvg() {
        return avg;
    }

    // EFFECTS: finds course and returns true if course is found.
    // MODIFIES: this, average, avg, prereq, course1
    private Boolean courseFinder(String uiCourseName, Boolean checkresult, List<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            courseMap.put(i, courses.get(i));
            Course course = courses.get(i);
            if (course.getName().toLowerCase().equals(uiCourseName.toLowerCase())) {
                average = course.getAverage();
                avg = course.getAverage();
                prereq = course.getPreReqCourses();
                course1 = new Course(course.getName(), prereq, average);
                checkCourse(uiCourseName.toUpperCase(), prereq, average, i);
            }
            if (course1.getName().toLowerCase().equals(uiCourseName.toLowerCase())) {
                checkresult = true;
            }
        }
        return checkresult;
    }

    // EFFECTS: finds course and returns true if course is found and prints "Found Course!"
    public boolean checkCourse(String s, String p, Integer a, Integer i) {
        Course course = courseMap.get(i);
        Course courseDemo = new Course(s, p, a);
        if (course.equals(courseDemo)) {
            System.out.println("Found Course!");
            return true;
        }
        return false;
    }

    // EFFECTS: If course is not found adds course to a list to be added.
    public void nonActiveCourse(boolean checkResult) {
        FileReader fileReader = new FileReader();
        if (checkResult == false) {
            fileReader.addCourse(course1);
        }
    }

}
