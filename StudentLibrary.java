import javax.swing.*;
import GraceMemberB.BookManagement;
public class StudentLibrary {
    public static void main(String[] args) {
        // Create an instance of BookManagement to handle all book-related features
        BookManagement bookMgmt = new BookManagement();

        // Main menu loop
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                "Mini Library System - Main Menu\n" +
                "1. Student Management\n" +
                "2. Books in Library\n" +
                "3. Exit",
                "Main Menu", JOptionPane.QUESTION_MESSAGE);

            // Exit if user closes the dialog or chooses option 3
            if (choice == null || choice.equals("3")) {
                break;
            }

            switch (choice) {
                case "1":
                    // Placeholder for Student Management (Member A’s part)
                    JOptionPane.showMessageDialog(null, "Feature by Member A (Student Management)", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "2":
                    // Navigate to Book Management menu (Member B’s part)
                    handleBookMenu(bookMgmt);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // This method shows the Book Management submenu and handles user actions
    public static void handleBookMenu(BookManagement bookMgmt) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                "Book Management Menu\n" +
                "1. Display all books\n" +
                "2. Search book by title\n" +
                "3. Add new book\n" +
                "4. Display total books costs\n" +
                "5. Exit",
                "Book Management", JOptionPane.QUESTION_MESSAGE);

            // Exit Book Management submenu
            if (choice == null || choice.equals("5")) {
                break;
            }

            switch (choice) {
                case "1":
                    bookMgmt.displayBooks(); // Option 1: Show all books
                    break;
                case "2":
                    bookMgmt.searchBookByTitle(); // Option 2: Search by title
                    break;
                case "3":
                    bookMgmt.addBook(); // Option 3: Add new book
                    break;
                case "4":
                    bookMgmt.displayTotalBookCost(); // Option 4: Show total price
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
