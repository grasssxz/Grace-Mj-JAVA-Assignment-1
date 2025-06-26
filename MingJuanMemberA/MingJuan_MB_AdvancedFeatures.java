package MingJuanMemberA;

import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

// Define Student class here if not already defined elsewhere
class Student {
    private String name;
    private String adminNo;
    private String[] books;

    public Student(String name, String adminNo, String[] books) {
        this.name = name;
        this.adminNo = adminNo;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public String[] getBooks() {
        return books;
    }
}

public class MingJuan_MB_AdvancedFeatures {

    // Play sound (only supports .wav by default)
    public static void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.out.println("Sound error: " + e.getMessage());
        }
    }

    // Display students in JTable
    public static void displayStudentsTable(Student[] students, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No students to display.");
            return;
        }

        String[] columnNames = {"Name", "Admin No", "Books Borrowed"};
        String[][] data = new String[count][3];

        for (int i = 0; i < count; i++) {
            Student s = students[i];
            data[i][0] = s.getName();
            data[i][1] = s.getAdminNo();
            data[i][2] = (s.getBooks().length == 0) ? "None" : String.join(", ", s.getBooks());
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JOptionPane.showMessageDialog(null, scrollPane, "Student List", JOptionPane.INFORMATION_MESSAGE);
    }

    // Show number of books per student
    public static void displayBookCountPerStudent(Student[] students, int count) {
        StringBuilder sb = new StringBuilder("Books Borrowed Count:\n\n");
        for (int i = 0; i < count; i++) {
            sb.append(students[i].getName()).append(" - ")
              .append(students[i].getBooks().length).append(" book(s)\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}