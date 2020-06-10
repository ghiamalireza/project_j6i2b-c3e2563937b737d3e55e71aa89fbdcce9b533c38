package observer;

import java.util.ArrayList;
import java.util.List;

public interface CourseObserver {
    void update(CourseObserver courseObserver, List<CourseObserver> observers);

    void popularityOfCourse();
}
