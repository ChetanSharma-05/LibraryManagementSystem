public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        // Register users
        library.registerUser(new User(101, "Chetan"));
        library.registerUser(new User(102, "Ravi"));

        // Show all books
        library.showAllBooks();

        // Issue book
        library.issueBook(101, 1);  // Chetan -> Java Programming
        library.issueBook(102, 2);  // Ravi -> Effective Java

        // Try to issue already issued book
        library.issueBook(101, 1);  // Already issued

        // Show issued books
        library.showIssuedBooks();

        // Return book
        library.returnBook(101, 1);

        // Show books again
        library.showAllBooks();
    }
}
