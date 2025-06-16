import GraceMemberB.BookManagement;
import GraceMemberB.GraceAdvancedFeatures;
import javax.swing.*; 



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

// ...existing code...
public static void handleBookMenu(BookManagement bookMgmt) {
    while (true) {
        String choice = JOptionPane.showInputDialog(null,
            "Book Management Menu\n" +
            "1. Display all books\n" +
            "2. Search book by title\n" +
            "3. Add new book\n" +
            "4. Display total books costs\n" +
            "5. Loan a book (Advanced)\n" + //plays the sound effect
            "6. Sort books by title (Advanced)\n" +
            "7. Filter books by category (Advanced)\n" +
            "8. Edit a book (Advanced)\n" +
            "9. Delete a book (Advanced)\n" +
            "10. Count books by category (Advanced)\n" +
            "11. Exit",
            "Book Management", JOptionPane.QUESTION_MESSAGE);

        // Exit Book Management submenu
        if (choice == null || choice.equals("11")) {
            break;
        }

        switch (choice) {
            case "1":
                bookMgmt.displayBooks();
                break;
            case "2":
                bookMgmt.searchBookByTitle();
                break;
            case "3":
                bookMgmt.addBook();
                break;
            case "4":
                bookMgmt.displayTotalBookCost();
                break;
            case "5":
                GraceAdvancedFeatures.loanBook(bookMgmt.getBooks(), bookMgmt.getCount());
                break;
            case "6":
                GraceAdvancedFeatures.sortBooksByTitle(bookMgmt.books, bookMgmt.getCount());
                break;
            case "7":
                GraceAdvancedFeatures.filterByCategory(bookMgmt.books, bookMgmt.getCount());
                break;
            case "8":
                GraceAdvancedFeatures.editBook(bookMgmt.books, bookMgmt.getCount());
                break;
            case "9":
                bookMgmt.count = GraceAdvancedFeatures.deleteBook(bookMgmt.books, bookMgmt.getCount());
                break;
            case "10":
                GraceAdvancedFeatures.countBooksByCategory(bookMgmt.books, bookMgmt.getCount());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
}