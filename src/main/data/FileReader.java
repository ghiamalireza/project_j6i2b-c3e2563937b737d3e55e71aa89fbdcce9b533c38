package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<Course> courses1;
    private Course finalcourse;

    // EFFECTS: Constructs new FileReader.
    public FileReader() {
    }


    // MODIFIES: this
    // REQUIRES: file of .txt type
    // EFFECTS: Reads content inside of the file.txt
    public String readFinder(String s) throws IOException {
        String content;
        String path = System.getProperty("user.dir") + s;
        content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }


    // MODIFIES: this
    // REQUIRES: file of .txt type
    // EFFECTS: Reads content inside of the file.txt
    public String read() throws IOException {
        String content;
        String path = System.getProperty("user.dir") + "\\src\\file.txt";
        content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }


    // MODIFIES: this
    // EFFECTS: Separates every segment of text in the File.txt and adds it to course
    public List<Course> getCoursesFromFile() {
        try {
            String data = read();
            String[] lines = data.split("\\n");
            List<Course> courses = new ArrayList<>();
            lineReader(lines, courses);
            return courses;
        } catch (Exception e) {
            System.out.println("exception");
        }
        return null;
    }

    // EFFECTS: Reads every line of given and adds elements to courses.
    // MODIFIES: this.
    public void lineReader(String[] lines, List<Course> courses) {
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            line = line.replace("\r", "");
            String[] segments = line.split("\\|");
            Course course = new Course(segments[0], segments[1], Integer.parseInt(segments[2]));
            courses.add(course);
            finalcourse = course;
        }
    }

    // EFFECTS: adds course to file reader.
    public void addCourse(Course c) {
        courses1.add(c);
        c.addFileReader(this);
    }


}
