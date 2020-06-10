package observer;

import data.Course;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PopularCourse {

    public static List<CourseObserver> observers = new ArrayList<>();

    public static List<CourseObserver> getObservers() {
        return observers;
    }

    // EFFECTS: adds observer to course observer.
    // MODIFIES: this
    public void addObserver(CourseObserver courseObserver) {
        observers.add(courseObserver);
    }

    // EFFECTS: Notifies observer for every course observer in observer.
    public void notifyObservers(CourseObserver courseObserver) {
        for (CourseObserver observer : observers) {
            observer.update(courseObserver, observers);
        }
        courseObserver.popularityOfCourse();
    }

}
