package GraceMemberB;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class GraceAdvancedFeatures {


    // --- MEMBER B ADVANCED FEATURES ---

    // Checks if the ISBN already exists in the array of books
    public static boolean isDuplicateISBN(Book[] books, int count, String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getISBN().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    // Allows the user to loan a book if it is available
    public static void loanBook(Book[] books, int count) {
        String title = JOptionPane.showInputDialog("Enter book title to loan:");
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (!books[i].isAvailable()) {
                    JOptionPane.showMessageDialog(null, "Book is already loaned out.");
                } else {
                    books[i].setAvailable(false);
                    JOptionPane.showMessageDialog(null, "Book loaned successfully.");
                    playSound("ding.wav"); // optional sound
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
    }

    // Sorts all books alphabetically by title
    // in the .sort(-,0,...) they compare the unicode of the first character of each title
    //   0  → titles are equal
//   <0 → first title comes before second alphabetically
//   >0 → first title comes after second alphabetically
    public static void sortBooksByTitle(Book[] books, int count) {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle));
        JOptionPane.showMessageDialog(null, "Books sorted by title.");
    }



    // Filters and shows books belonging to a specific category
    public static void filterByCategory(Book[] books, int count) {
        String category = JOptionPane.showInputDialog("Enter category to filter:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (books[i].getCategory().equalsIgnoreCase(category)) {
                sb.append(books[i].toString()).append("\n\n");
            }
        }
        if (sb.length() == 0) {
            JOptionPane.showMessageDialog(null, "No books found in that category.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString(), "Books in Category", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Plays a sound using a .wav file
    public static void playSound(String filename) {
    try {
        // Load the sound file from the GraceMemberB package using relative path
        File soundFile = new File("GraceMemberB/" + filename);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        System.out.println("Sound error: " + e.getMessage());
    }
}
    // Allows editing of book info based on title match
    public static void editBook(Book[] books, int count) {
        String title = JOptionPane.showInputDialog("Enter the title of the book to edit:");
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                String newTitle = JOptionPane.showInputDialog("Enter new title:", books[i].getTitle());
                String newAuthor = JOptionPane.showInputDialog("Enter new author:", books[i].getAuthor());
                String newISBN = JOptionPane.showInputDialog("Enter new ISBN:", books[i].getISBN());
                double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter new price:", books[i].getPrice()));
                String newCategory = JOptionPane.showInputDialog("Enter new category:", books[i].getCategory());
                boolean available = books[i].isAvailable();
                books[i] = new Book(newTitle, newAuthor, newISBN, newPrice, newCategory, available);
                JOptionPane.showMessageDialog(null, "Book updated successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
    }

    // Deletes a book by shifting the remaining books left
    public static int deleteBook(Book[] books, int count) {
        String title = JOptionPane.showInputDialog("Enter the title of the book to delete:");
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                JOptionPane.showMessageDialog(null, "Book deleted successfully.");
                return count - 1;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
        return count;
    }

    // Counts how many books are in each category and displays it
    public static void countBooksByCategory(Book[] books, int count) {
        Map<String, Integer> categoryCounts = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String cat = books[i].getCategory();
            categoryCounts.put(cat, categoryCounts.getOrDefault(cat, 0) + 1);
        }
        StringBuilder sb = new StringBuilder("Books by Category:\n");
        for (String cat : categoryCounts.keySet()) {
            sb.append(cat).append(" : ").append(categoryCounts.get(cat)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // --- MEMBER A + B COMBINED FEATURES ---

    // Links a student to a book they borrowed and marks the book unavailable
    public static void linkStudentToBook(Map<String, String> loanLog, Book[] books, int count) {
        String studentName = JOptionPane.showInputDialog("Enter student name:");
        String bookTitle = JOptionPane.showInputDialog("Enter book title to borrow:");
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(bookTitle) && books[i].isAvailable()) {
                books[i].setAvailable(false);
                loanLog.put(studentName, bookTitle);
                JOptionPane.showMessageDialog(null, studentName + " has borrowed '" + bookTitle + "'.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book is either not found or not available.");
    }

    // Displays all records of borrowed books
    public static void displayLoanLog(Map<String, String> loanLog) {
        if (loanLog.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books are currently loaned out.");
            return;
        }
        StringBuilder sb = new StringBuilder("Borrowed Books Log:\n");
        for (String student : loanLog.keySet()) {
            sb.append(student).append(" borrowed ").append(loanLog.get(student)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Allows a student to return their borrowed book
    public static void returnBook(Map<String, String> loanLog, Book[] books, int count) {
        String studentName = JOptionPane.showInputDialog("Enter student name to return book:");
        if (!loanLog.containsKey(studentName)) {
            JOptionPane.showMessageDialog(null, "This student has not borrowed any book.");
            return;
        }
        String bookTitle = loanLog.get(studentName);
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(bookTitle)) {
                books[i].setAvailable(true);
                loanLog.remove(studentName);
                JOptionPane.showMessageDialog(null, studentName + " has returned '" + bookTitle + "'.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book record mismatch.");
    }

    // Verifies if a specific student borrowed a specific book
    public static void verifyStudentBookLoan(Map<String, String> loanLog) {
        String studentName = JOptionPane.showInputDialog("Enter student name:");
        String bookTitle = JOptionPane.showInputDialog("Enter book title to verify:");

        if (loanLog.containsKey(studentName)) {
            String borrowedBook = loanLog.get(studentName);
            if (borrowedBook.equalsIgnoreCase(bookTitle)) {
                JOptionPane.showMessageDialog(null, "✅ Yes, " + studentName + " has borrowed '" + bookTitle + "'.");
            } else {
                JOptionPane.showMessageDialog(null, "❌ No, " + studentName + " did not borrow '" + bookTitle + "'.");
            }
        } else {
            JOptionPane.showMessageDialog(null, studentName + " has not borrowed any book.");
        }
    }

    // Verifies if the student borrowed any book at all
    public static void verifyAnyBooksBorrowed(Map<String, String> loanLog) {
        String studentName = JOptionPane.showInputDialog("Enter student name to check loans:");
        if (loanLog.containsKey(studentName)) {
            String book = loanLog.get(studentName);
            JOptionPane.showMessageDialog(null, studentName + " has borrowed '" + book + "'.");
        } else {
            JOptionPane.showMessageDialog(null, studentName + " has not borrowed any books.");
        }
    }

    // Shows which book the student has borrowed
    public static void listBorrowedBooksByStudent(Map<String, String> loanLog, String studentName) {
        if (loanLog.containsKey(studentName)) {
            JOptionPane.showMessageDialog(null, studentName + " has borrowed: " + loanLog.get(studentName));
        } else {
            JOptionPane.showMessageDialog(null, studentName + " has not borrowed any books.");
        }
    }
}
