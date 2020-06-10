package ui;


import java.io.FileNotFoundException;

public class Main {

    public Main() {

    }

    // EFFECTS: Refers to result object
    public void start() throws FileNotFoundException {
        Results results = new Results() {
        };
    }

    // EFFECTS: main method constructs new main.
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start();
    }

}

