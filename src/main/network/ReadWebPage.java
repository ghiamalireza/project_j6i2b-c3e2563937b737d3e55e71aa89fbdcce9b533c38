package network;

import data.FileReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ReadWebPage {

    protected String session = "2019W";
    protected String coursecode;
    protected String coursenumber;
    protected String section;
    private List<String> parsedList;
    private String string;

    // EFFECTS: Constructs new ReadWebPage.
    public ReadWebPage(String coursecode, String coursenumber, String section) {
        this.coursecode = coursecode;
        this.coursenumber = coursenumber;
        this.section = section;
    }

    // EFFECTS: Returns information from api.
    public String courseInformation() throws MalformedURLException, IOException {

        BufferedReader br = null;
        String requestedUrl = requestedUrl();
        try {
            String theURL = requestedUrl;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return parseInfo(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: Returns requested URL.
    public String requestedUrl() {
        return String.format("https://ubc-courses-api.herokuapp.com/%s/%s/%s/%s",
                session, coursecode, coursenumber, section);
    }

    // EFFECTS: Returns parsed information from sb.
    public String parseInfo(StringBuilder sb) throws FileNotFoundException {
        String info = sb.toString();
        PrintStream fileStream = new PrintStream("courseFinder.txt");
        System.setOut(fileStream);
        List<String> listOfInfo = Arrays.asList(info.split(","));
        System.out.println(listOfInfo.get(0).replace("{", "") + listOfInfo.get(1));
        System.out.println(listOfInfo.get(14).replace("_", " ")
                + listOfInfo.get(15).replace("_", " ")
                + listOfInfo.get(16).replace("_", " "));
        System.out.println(listOfInfo.get(17) + listOfInfo.get(18));
        System.out.println(listOfInfo.get(3));
        System.out.println(listOfInfo.get(10));
        System.out.println(listOfInfo.get(11));
        System.out.println(listOfInfo.get(19));
        System.out.println(listOfInfo.get(20));
        System.out.println(listOfInfo.get(21));
        return readingCourseFinderFile();
    }

    // EFFECTS: Reads course finder file and returns the string.
    public String readingCourseFinderFile() {
        FileReader fileReader = new FileReader();
        try {
            string = String.valueOf(fileReader.readFinder("/courseFinder.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}