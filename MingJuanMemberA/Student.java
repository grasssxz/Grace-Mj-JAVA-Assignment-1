package MingJuanMemberA;

public class Student {
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

    @Override
    public String toString() {
        String bookList = (books.length == 0) ? "None" : String.join(", ", books);

        return "Student Name: " + name +
               "\nAdmin Number: " + adminNo +
               "\nBooks Borrowed: " + bookList;
    }
}
