// contains the main method

public class LibrarySystem {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book(1, "Introduction to Java", "John Doe");
        Book book2 = new Book(2, "Programming Basics", "Jane Smith");
        library.addBook(book1);
        library.addBook(book2);

        // Add members to the library
        Member member1 = new Member(101, "Alice");
        Member member2 = new Member(102, "Bob");
        library.addMember(member1);
        library.addMember(member2);

        // Display available books
        library.displayAvailableBooks();

        // Alice borrows a book
        member1.borrowBook(book1);

        // Display available books after borrowing
        library.displayAvailableBooks();

        // Bob borrows a book
        member2.borrowBook(book2);

        // Display available books after Bob's borrowing
        library.displayAvailableBooks();
    }
}