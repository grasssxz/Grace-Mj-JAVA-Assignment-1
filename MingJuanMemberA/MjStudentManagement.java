package MingJuanMemberA;

import javax.swing.*;

public class MjStudentManagement {
    private Student[] students;
    private int count;

    public MjStudentManagement() {
        students = new Student[100];
        count = 0;
        initStudents();
    }

    private void initStudents() {
        students[count++] = new Student("Grace", "p2429077", new String[]{"ISBN001", "Elon Musk"});
        students[count++] = new Student("MingJuan", "p2429085", new String[]{"ISBN002", "Clean Code"});
        students[count++] = new Student("Weexuan", "p2429067", new String[]{"ISBN003", "Java Basics"});
    }

    public void displayStudent() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "There are no students.", "Student List", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("=== Student List ===\n\n");

        for (int i = 0; i < count; i++) {
            Student s = students[i];
            sb.append("Name: ").append(s.getName()).append("\n");
            sb.append("Admin No: ").append(s.getAdminNo()).append("\n");

            sb.append("Books Borrowed: ");
            String[] books = s.getBooks();

            if (books.length == 0) {
                sb.append("None");
            } else {
                for (int j = 0; j < books.length; j++) {
                    sb.append(books[j]);
                    if (j < books.length - 1) {
                        sb.append(", ");
                    }
                }
            }

            sb.append("\n-----------------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "All Students", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchStudByName() {
        String name = JOptionPane.showInputDialog("Enter student name to search:");
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot find the student '" + name + "'", "Not Found", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                Student s = students[i];

                StringBuilder sb = new StringBuilder();
                sb.append("Name: ").append(s.getName()).append("\n");
                sb.append("Admin No: ").append(s.getAdminNo()).append("\n");

                sb.append("Books Borrowed: ");
                String[] books = s.getBooks();

                if (books.length == 0) {
                    sb.append("None");
                } else {
                    for (int j = 0; j < books.length; j++) {
                        sb.append(books[j]);
                        if (j < books.length - 1) sb.append(", ");
                    }
                }

                JOptionPane.showMessageDialog(null, sb.toString(), "Student Found", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Cannot find the student '" + name + "'", "Not Found", JOptionPane.ERROR_MESSAGE);
    }

    public void addStudent() {
        String name = JOptionPane.showInputDialog("Enter student name:");
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Student name cannot be empty.");
            return;
        }

        String adminNo = JOptionPane.showInputDialog("Enter student admin number:");
        if (adminNo == null || adminNo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Admin number cannot be empty.");
            return;
        }

        String booksInput = JOptionPane.showInputDialog("Enter books, or leave blank if none:");
        String[] books;

        if (booksInput == null || booksInput.trim().isEmpty()) {
            books = new String[0]; // no books
        } else {
            books = booksInput.split("\\s*,\\s*");
        }

        students[count++] = new Student(name, adminNo, books);

        JOptionPane.showMessageDialog(null, "Student successfully added.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayStudNum() {
        JOptionPane.showMessageDialog(null, "Total number of students: " + count, "Student Count", JOptionPane.INFORMATION_MESSAGE);
    }

    public Student[] getStudents() {
        return students;
    }

    public int getCount() {
        return count;
    }
}
