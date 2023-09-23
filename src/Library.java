import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!isBookBorrowed(book)) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean isBookBorrowed(Book book) {
        for (Member member : members) {
            if (member.getBorrowedBooks().contains(book)) {
                return true;
            }
        }
        return false;
    }

    public void borrowBook(Member member, Book book) {
        if (!isBookBorrowed(book)) {
            member.borrowBook(book);
        } else {
            System.out.println("Book is already borrowed by someone else.");
        }
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
    }
}
