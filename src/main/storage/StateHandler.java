package storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StateHandler implements Loadable, Saveable {

    //Effects: Loads what is written in the required .txt file
    @Override
    public String load(String s) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(s));
        PrintWriter writer = new PrintWriter(s, "UTF-8");
        writer.println(lines);
        String ans = lines.toString();
        System.out.println(lines);
        writer.close();
        return ans;
    }

    //Effects: Saves the three strings given to the saved.txt file.
    @Override
    public Boolean save(String s, String r, String l) {
        List<String> saved = new ArrayList<>();
        saved.add("Output:\n" + s + "\n" + r + "\n" + l + "\n");
        lineExtractor(saved);
        return true;
    }

    private void lineExtractor(List<String> saved) {
        try {
            String data = saved.toString();
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("./saved.txt"));
            String[] lines = data.split("\\,");
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                line = line.replace("[", "");
                line = line.replace("]", "");
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
