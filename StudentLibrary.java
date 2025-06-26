import GraceMemberB.BookManagement;
import GraceMemberB.GraceAdvancedFeatures;
import MingJuanMemberA.MingJuan_MB_AdvancedFeatures;
import MingJuanMemberA.MjStudentManagement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class StudentLibrary {
    public static void main(String[] args) {
        MjStudentManagement studentMgmt = new StudentManagement(); // You may rename if needed
        BookManagement bookMgmt = new BookManagement();
        Map<String, String> loanLog = new HashMap<>();

        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Mini Library System - Main Menu\n" +
                            "1. Student Management\n" +
                            "2. Books in Library\n" +
                            "3. Link student to book (A+B)\n" +
                            "4. View borrowed books log (A+B)\n" +
                            "5. Return a book (A+B)\n" +
                            "6. Verify specific loan (A+B)\n" +
                            "7. Check if student borrowed any books (A+B)\n" +
                            "8. Exit",
                    "Main Menu", JOptionPane.QUESTION_MESSAGE);

            if (choice == null || choice.equals("8")) {
                break;
            }

            switch (choice) {
                case "1":
                    handleStudentMenu((StudentManagement) studentMgmt);
                    break;
                case "2":
                    handleBookMenu(bookMgmt);
                    break;
                case "3":
                    GraceAdvancedFeatures.linkStudentToBook(loanLog, bookMgmt.getBooks(), bookMgmt.getCount());
                    break;
                case "4":
                    GraceAdvancedFeatures.displayLoanLog(loanLog);
                    break;
                case "5":
                    GraceAdvancedFeatures.returnBook(loanLog, bookMgmt.getBooks(), bookMgmt.getCount());
                    break;
                case "6":
                    GraceAdvancedFeatures.verifyStudentBookLoan(loanLog);
                    break;
                case "7":
                    GraceAdvancedFeatures.verifyAnyBooksBorrowed(loanLog);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void handleStudentMenu(StudentManagement studentMgmt) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Student Management Menu\n" +
                            "1. Display all students\n" +
                            "2. Search student by name\n" +
                            "3. Add a new student\n" +
                            "4. Display student count\n" +
                            "5. Display table (Advanced)\n" +
                            "6. Display book count per student (Advanced)\n" +
                            "7. Exit",
                    "Student Management", JOptionPane.QUESTION_MESSAGE);

            if (choice == null || choice.equals("7")) {
                break;
            }

            switch (choice) {
                case "1":
                    studentMgmt.displayStudent();
                    break;
                case "2":
                    studentMgmt.searchStudByName();
                    break;
                case "3":
                    studentMgmt.addStudent();
                    break;
                case "4":
                    studentMgmt.displayStudNum();
                    break;
                case "5":
                    MingJuan_MB_AdvancedFeatures.displayStudentsTable(studentMgmt.getStudents(), studentMgmt.getCount());
                    break;
                case "6":
                    MingJuan_MB_AdvancedFeatures.displayBookCountPerStudent(studentMgmt.getStudents(), studentMgmt.getCount());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void handleBookMenu(BookManagement bookMgmt) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Book Management Menu\n" +
                            "1. Display all books\n" +
                            "2. Search book by title\n" +
                            "3. Add new book\n" +
                            "4. Display total books costs\n" +
                            "5. Loan a book (Advanced)\n" +
                            "6. Sort books by title (Advanced)\n" +
                            "7. Filter books by category (Advanced)\n" +
                            "8. Edit a book (Advanced)\n" +
                            "9. Delete a book (Advanced)\n" +
                            "10. Count books by category (Advanced)\n" +
                            "11. Exit",
                    "Book Management", JOptionPane.QUESTION_MESSAGE);

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
