package GraceMemberB;
public class Book {
    // Attributes of a book
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private String category;
    private boolean available;

    // Constructor to initialize a book
    public Book(String title, String author, String ISBN, double price, String category, boolean available) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    // Getter methods to access private fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter method for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // This method is used to display the book's information
    @Override
    public String toString() {
        return "Book Title : " + title +
               "\nBook Author : " + author +
               "\nAvailability : " + (available ? "Available" : "Unavailable");
    }
}
