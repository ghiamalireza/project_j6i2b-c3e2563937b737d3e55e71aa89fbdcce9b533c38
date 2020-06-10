package ui;

import questions.QuestionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GuiStarter extends JFrame implements ActionListener {
    private final JLabel courseCode;
    private final JLabel courseNum;
    private final JLabel section;
    private JLabel label;
    private JLabel label1;
    private JLabel faculty;
    private JLabel major;
    private JLabel course;
    private JLabel takenprereq;
    private JLabel average;
    private JLabel goal;
    private JLabel selectedFaculty;
    private JLabel selectedMajor;
    private JLabel selectedCourse;
    private JLabel selectedAverage;
    private JLabel selectedGoal;
    private JTextField field;
    private JTextField field1;
    private JTextField field2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel predicted;
    private JLabel gpaRecommendation;
    private JLabel preReqs;


    // EFFECTS: Constructs a new JFrame with initial wanted elemnets
    // MODIFIES: this.
    public GuiStarter() {
        super("Course Recommending Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.textField1 = new JTextField(7);
        this.textField2 = new JTextField(7);
        this.textField3 = new JTextField(7);
        this.courseCode = new JLabel("Course Code:");
        this.courseNum = new JLabel("Course Number:");
        this.section = new JLabel("Section:");
        this.predicted = new JLabel("");
        this.preReqs = new JLabel("");
        this.gpaRecommendation = new JLabel("");
        setPreferredSize(new Dimension(1000, 1000));
        JPanel panel1 = new JPanel();
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel2.setBackground(Color.blue.brighter());
        panel1.setBackground(Color.blue.darker());
        panel3.setBackground(Color.gray.brighter());
        panel3.setLayout(null);
        panel3.setBounds(1900, 650, 270, 350);
        panel1.setBounds(0, 0, 1000, 1000);
        panel2.setBounds(300, 200, 2100, 1200);
        panel.setBackground(Color.white);
        panel.setBounds(500, 300, 1700, 1000);
        add(panel3);
        add(panel);
        add(panel2);
        add(panel1);
        panel.setLayout(null);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu of Operations");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Course Finder", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menuItem.setActionCommand("myMenu");
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        JButton btn = new JButton("Recommendation");
        btn.setBounds(1450, 120, 150, 80);
        btn.setActionCommand("myButton");
        btn.addActionListener(this);
        predicted.setBounds(200, 700, 2000, 100);
        label = new JLabel("");
        faculty = new JLabel("Faculty:");
        faculty.setBounds(100, 50, 100, 100);
        major = new JLabel("Major:");
        major.setBounds(600, 50, 100, 100);
        course = new JLabel("Course:");
        course.setBounds(1000, 50, 100, 100);
        takenprereq = new JLabel("Have you taken these prerequisites? (Y/N):");
        takenprereq.setBounds(100, 180, 300, 100);
        average = new JLabel("Average:");
        average.setBounds(700, 180, 100, 100);
        average.setHorizontalAlignment(SwingConstants.CENTER);
        goal = new JLabel("Goal:");
        goal.setBounds(1100, 180, 100, 100);
        field = new JTextField(7);
        field.setBounds(150, 88, 200, 30);
        field1 = new JTextField(7);
        field1.setBounds(650, 88, 200, 30);
        field2 = new JTextField(7);
        field2.setBounds(1050, 88, 200, 30);
        textField4 = new JTextField(7);
        textField4.setBounds(350, 218, 200, 30);
        textField5 = new JTextField(7);
        textField5.setBounds(780, 218, 200, 30);
        textField6 = new JTextField(7);
        textField6.setBounds(1140, 218, 200, 30);
        label1 = new JLabel();
        selectedFaculty = new JLabel("Faculty: ");
        selectedFaculty.setForeground(Color.red.darker());
        selectedFaculty.setBounds(20, 10, 200, 50);
        selectedMajor = new JLabel("Major: ");
        selectedMajor.setForeground(Color.red.darker());
        selectedMajor.setBounds(20, 70, 200, 50);
        selectedCourse = new JLabel("Course: ");
        selectedCourse.setForeground(Color.red.darker());
        selectedCourse.setBounds(20, 130, 200, 50);
        selectedAverage = new JLabel("Average: ");
        selectedAverage.setForeground(Color.red.darker());
        selectedAverage.setBounds(20, 180, 200, 50);
        selectedGoal = new JLabel("Goal: ");
        selectedGoal.setForeground(Color.red.darker());
        selectedGoal.setBounds(20, 230, 200, 50);
        preReqs.setBounds(200, 550, 1200, 100);
        preReqs.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        ImageIcon header = new ImageIcon("Logo.PNG");
        header = new ImageIcon(header.getImage().getScaledInstance(1100, 195, Image.SCALE_REPLICATE));
        JLabel jheader = new JLabel();
        jheader.setIcon(header);
        jheader.setBounds(600, 0, 700, 700);
        ImageIcon iconLogo = new ImageIcon("src/UBC.jpg");
        iconLogo = new ImageIcon(iconLogo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel icon = new JLabel();
        icon.setIcon(iconLogo);
        icon.setBounds(1530, 570, 700, 700);
        panel.add(faculty);
        panel.add(field);
        panel.add(major);
        panel.add(field1);
        panel.add(course);
        panel.add(field2);
        panel.add(takenprereq);
        panel.add(textField4);
        panel.add(average);
        panel.add(textField5);
        panel.add(goal);
        panel.add(textField6);
        panel.add(btn);
        panel.add(label1);
        panel.add(predicted);
        panel.add(preReqs);
        panel.add(icon);
        panel1.add(jheader);
        panel3.add(selectedFaculty);
        panel3.add(selectedMajor);
        panel3.add(selectedCourse);
        panel3.add(selectedAverage);
        panel3.add(selectedGoal);
        setJMenuBar(menuBar);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    // EFFECTS: creates a new JFrame window for the course finder app.
    // MODIFIES: this.
    public void courseFinder() {
        JFrame f = new JFrame("Course Finder");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(1000, 1000));
        f.setLayout(new FlowLayout());
        JButton btn = new JButton("Find Course");
        btn.setActionCommand("courseFinder");
        btn.addActionListener(this);
        f.add(courseCode);
        f.add(textField1);
        f.add(courseNum);
        f.add(textField2);
        f.add(section);
        f.add(textField3);
        f.add(btn);
        f.add(label);
        f.setVisible(true);
    }

    // EFFECTS: performs actions when a specific button is pressed.
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            try {
                resultUpdater();
                selectItems();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("myMenu")) {
            courseFinder();
        } else if (e.getActionCommand().equals("courseFinder")) {
            CourseInformationQuestion ci =
                    new CourseInformationQuestion(new Scanner(""));

            try {
                label.setText(ci.guiHandleQuestion(textField1.getText(), textField2.getText(), textField3.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // EFFECTS: Sets selected fields into what the user has inputted.
    // MODIFIES: this.
    private void selectItems() {
        selectedFaculty.setText("Faculty: " + field.getText());
        selectedMajor.setText("Major: " + field1.getText());
        selectedCourse.setText("Course: " + field2.getText());
        selectedAverage.setText("Average: " + textField5.getText());
        selectedGoal.setText("Goal: " + textField6.getText());
    }

    // EFFECTS: Gets and sets results text.
    // MODIFIES: this.
    private void resultUpdater() throws FileNotFoundException {
        QuestionHandler q = new QuestionHandler();
        CoursesToTakeQuestion coursesToTakeQuestion = new CoursesToTakeQuestion(new Scanner(field2.getText()));
        coursesToTakeQuestion.setSelectedCourse(field2.getText());
        coursesToTakeQuestion.check(field2.getText());
        q.setAverage(coursesToTakeQuestion.getAvg());
        q.setGoal(Integer.parseInt(textField5.getText()));
        predicted.setText("Prediction: " + q.operations(Integer.parseInt(textField5.getText()),
                Integer.parseInt(textField6.getText())));
        predicted.setFont(new Font("Times New Roman", Font.BOLD, 21));
        if (textField4.getText().toLowerCase().equals("n")) {
            preReqs.setText("You need to take these courses before: " + q.getPreReqs());
        } else {
            preReqs.setText("");
        }
    }

    // EFFECTS: Main.
    public static void main(String[] args) {
        new GuiStarter();
    }
}