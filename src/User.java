import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Book> issuedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public void showIssuedBooks() {
        System.out.println("Books issued by " + name + ":");
        for (Book book : issuedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}

