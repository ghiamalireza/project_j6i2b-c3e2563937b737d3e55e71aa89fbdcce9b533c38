package data;

import observer.CourseObserver;
import observer.PopularCourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Course extends PopularCourse implements CourseObserver {
    private String name;
    private String preReqCourses;
    private Integer average;
    private List<Course> courses;
    private List<FileReader> fileReaders;
    private static Integer occurrences;

    // EFFECTS: Creates an empty course list
    public Course(String name, String preReqCourses, Integer average) {
        this.name = name;
        this.preReqCourses = preReqCourses;
        this.average = average;
    }

//    @Override
//    public String toString() {
//        return "Course{"
//                + "name='" + name + '\''
//                + ", preReqCourses='" + preReqCourses + '\''
//                + ", average=" + average
//                + '}';
//    }

    public void addFileReader(FileReader f) {
        fileReaders.add(f);
        f.addCourse(this);
    }

    // EFFECTS: Returns the name of course
    public String getName() {
        return name;
    }

    // EFFECTS: Returns the prerequisites of course
    public String getPreReqCourses() {
        return preReqCourses;
    }

    // EFFECTS: Checks if course objects are equal and returns true, otherwise false.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return name.equals(course.name)
                && preReqCourses.equals(course.preReqCourses)
                && average.equals(course.average);
    }

    @Override
    public void update(CourseObserver courseObserver, List<CourseObserver> observers) {
        occurrences = Collections.frequency(observers, courseObserver);
    }

    @Override
    public void popularityOfCourse() {
        System.out.println("Number of selections of this course:" + occurrences);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, preReqCourses, average, courses, fileReaders);
    }

    // EFFECTS: Returns the average of course
    public Integer getAverage() {
        return average;
    }
}

