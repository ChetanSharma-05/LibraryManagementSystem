import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void showAllBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public void issueBook(int userId, int bookId) {
        Book bookToIssue = null;
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isIssued()) {
                bookToIssue = book;
                break;
            }
        }

        if (bookToIssue == null) {
            System.out.println("Book not available or already issued.");
            return;
        }

        for (User user : users) {
            if (user.getUserId() == userId) {
                user.issueBook(bookToIssue);
                bookToIssue.markAsIssued();
                System.out.println("Book issued successfully to " + user.getName());
                return;
            }
        }

        System.out.println("User not found.");
    }

    public void returnBook(int userId, int bookId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                for (Book book : user.getIssuedBooks()) {
                    if (book.getBookId() == bookId) {
                        user.returnBook(book);
                        book.markAsReturned();
                        System.out.println("Book returned successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Book or User not found.");
    }

    public void showIssuedBooks() {
        for (User user : users) {
            user.showIssuedBooks();
        }
    }
}

