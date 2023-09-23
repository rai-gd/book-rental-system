import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        initializeMembers(); // Initialize the member list
    }

    private void initializeMembers() {
        Member member1 = new Member(101, "Alice");
        Member member2 = new Member(102, "Bob");
        Member member3 = new Member(103, "MinMin");

        members.add(member1);
        members.add(member2);
        members.add(member3);
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


    public void viewBorrowedBooks(Member member) {
        List<Book> borrowedBooks = member.getBorrowedBooks();
        System.out.println("Borrowed Books by " + member.getName() + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }


    public void displayAvailableBooks() {
        List<Book> availableBooks = getAvailableBooks();
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}