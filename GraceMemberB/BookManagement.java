package GraceMemberB;
// GraceMemberB/BookManagement.java
import javax.swing.*;



public class BookManagement extends Book {
    // Array to store Book objects
    private Book[] books;
    private int count;

    public BookManagement() {
        super("", "", "", 0.0, "", true);
        books = new Book[100];
        count = 0;
        initBooks(); // Load 3 books at startup
    }

    // Pre-load 3 books for Option 1 display
  private void initBooks() {
    books[count++] = new Book("Basic Java", "Peter Lim", "ISBN001", 20.0, "Programming", true);
    books[count++] = new Book("Java Script Essential", "Tim Steven", "ISBN002", 25.0, "Web Development", true);
    books[count++] = new Book("ABC of Database", "Sue Ling", "ISBN003", 30.0, "Database", true);
    books[count++] = new Book("Networking Essentials", "Ali Rahman", "ISBN004", 22.5, "Networking", true);
    books[count++] = new Book("Object-Oriented Programming", "Nina Teo", "ISBN005", 28.0, "Programming", true);
    books[count++] = new Book("Linux Command Line Basics", "James Toh", "ISBN006", 19.5, "Operating Systems", true);
    books[count++] = new Book("Data Structures in Java", "Rachel Tan", "ISBN007", 27.0, "Computer Science", true);
    books[count++] = new Book("Cybersecurity Fundamentals", "Farah Lim", "ISBN008", 35.0, "Security", true);
}
    // Option 1: Display all books
    public void displayBooks() {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No books found in the library.", "Book List", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create a StringBuilder to build a long message string
        // StringBuilder is used because it's more efficient than using + to join strings repeatedly
        StringBuilder sb = new StringBuilder();

        // Loop through each book that has been added
        for (int i = 0; i < count; i++) {

            // Append the label "Book 1:", "Book 2:", etc.
            sb.append("Book ").append(i + 1).append(":\n");

            // Append the book details (title, author, availability)
            // This comes from the Book class's toString() method
            sb.append(books[i].toString());

            // Append two new lines to separate each book's details
            sb.append("\n\n");
        }

        // Convert the built string and display it in a popup
        JOptionPane.showMessageDialog(null, sb.toString(), "All Books", JOptionPane.INFORMATION_MESSAGE);
    }

    // Option 2: Search book by title
    public void searchBookByTitle() {
        String title = JOptionPane.showInputDialog("Enter book title to search:");
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                JOptionPane.showMessageDialog(null, books[i].toString(), "Book Found", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cannot find the book '" + title + "'", "Not Found", JOptionPane.ERROR_MESSAGE);
    }

    // Option 3: Add a new book
    public void addBook() {
        String title = JOptionPane.showInputDialog("Enter book title:");
        String author = JOptionPane.showInputDialog("Enter book author:");
        String isbn = JOptionPane.showInputDialog("Enter book ISBN:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter book price:"));
        String category = JOptionPane.showInputDialog("Enter book category:");

        // Store the new book in the array
        books[count++] = new Book(title, author, isbn, price, category, true);

        JOptionPane.showMessageDialog(null, "Book successfully added.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Option 4: Display total book costs
    public void displayTotalBookCost() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += books[i].getPrice();
        }
        JOptionPane.showMessageDialog(null, "Total cost of all books: $" + total, "Total Book Cost", JOptionPane.INFORMATION_MESSAGE);
    }
}
