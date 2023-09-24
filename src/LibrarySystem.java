// contains the main method

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibrarySystem {

    public static ArrayList<Book> BookList(){
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Resource/Books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    int id = Integer.parseInt(values[0].trim());
                    boolean isAvailable = Boolean.parseBoolean(values[1].trim());
                    String title = values[2].trim();
                    String author = values[3].trim();
                    Book book = new Book(id, isAvailable, title, author);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }


    public static void main(String[] args) {
        ArrayList<Book> bookList = BookList();
        String divider = "--------------------------";

        // Create a library
        Library library = new Library();

        // // Add books to the library
        // Book book1 = new Book(1, "Introduction to Java", "John Doe");
        // Book book2 = new Book(2, "Programming Basics", "Jane Smith");
        // library.addBook(book1);
        // library.addBook(book2);

        // // Add members to the library
        // Member member1 = new Member(101, "Alice");
        // Member member2 = new Member(102, "Bob");
        // library.addMember(member1);
        // library.addMember(member2);

        // // Display available books
        // library.displayAvailableBooks();

        // // Alice borrows a book
        // member1.borrowBook(book1);

        // // Display available books after borrowing
        // library.displayAvailableBooks();

        // // Bob borrows a book
        // member2.borrowBook(book2);

        // // Display available books after Bob's borrowing
        // library.displayAvailableBooks();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome..");
        while (true) {

            System.out.print("[1] View Books\n" +
                    "[2] View Members\n" +
                    "[0] Exit\n" +
                    "Enter choice: ");// menu 1
            int choice = readChoice(sc);


            switch (choice) {
                case 1: // View books
                    while (true) {
                        System.out.println("====================Books====================");
                        System.out.printf("%-4s%-23s%-40s%-20s%n", "ID", "Status", "Title", "Author");
                        for (Book book : bookList) {
                            String availability = book.getIsAvailable() ? "Available" : "Not Available";

                            String idFormatted = String.format("%-4d", book.getId());
                            String availabilityFormatted = String.format("%-23s", availability);
                            String titleFormatted = String.format("%-40s", book.getTitle());
                            String authorFormatted = String.format("%-20s", book.getAuthor());

                            System.out.println(idFormatted + availabilityFormatted + titleFormatted + authorFormatted);
                        }
                        System.out.println("=============================================");

                        // Print menu
                        System.out.print("[1] Select book\n" +
                                "[2] Search Book\n" +
                                "[3] Add book\n" +
                                "[0] Back\n" +
                                "Enter choice: ");

                        int bookChoice = readChoice(sc);

                        switch (bookChoice) {
                            case 1: // Select book
                                System.out.println("Enter book number: ");

                                break;
                            case 2: // Search book
                                searchBooks(sc);
                                break;
                            case 3: // Add book
                                System.out.println("Enter...");

                                break;

                            case 0:
                                break;

                            default:
                                System.out.print("Invalid choice");
                                delayOutput(300);
                                System.out.println();
                                break;

                        }

                        if (bookChoice == 0)
                            break;
                    }
            
                    break;
                case 2: // View members
                    while (true) {
                    // Print members
                    List<Member> members = library.getMembers();
                    System.out.println(divider);
                    System.out.printf("%5s%5s%n", " ", "Name");// pwede wala format

                    for (Member member : members) {
                        System.out.println(member.getMemberId() + " " + member.getName());
                    } // Gets Members from library member list

                    // Print menu
                    System.out.println(divider);
                    System.out.print("[1] Select member\n" +
                            "[2] Search member\n" +
                            "[3] Add member\n" +
                            "[0] Back\n" +
                            "Enter choice: ");

                    int memChoice = readChoice(sc);
                    switch (memChoice) {
                        case 1: // Select member
                            System.out.println("Enter member ID: ");
                            int memChoice2 = readChoice(sc);
                            boolean isValid = false;
                            Member selectedMember = null;
                            
                            for (Member member : members) {
                                if (member.getMemberId() == memChoice2) {
                                    isValid = true;
                                    selectedMember = member;
                                    break;
                                } //compares input member ID to the member list
                            }
                            if (isValid) {
                                System.out.println("Member details");
                                System.out.println("Member ID: " + selectedMember.getMemberId() + " || Member Name: " + selectedMember.getName());
                                System.out.println("Rented books");
                                if (selectedMember.getBorrowedBooks().size() == 0) {
                                    // Print a message to show that there are no borrowed books
                                    System.out.println(selectedMember.getName() + " has not borrowed any books from the library.");
                                  }
                                else {
                                    System.out.println(selectedMember.getBorrowedBooks());
                                }
                                }


                            break;
                        case 2: // Search member
                            System.out.println("Search");

                            break;
                        case 3: // Add member
                            System.out.println("");

                            break;
                        case 0:
                            break;

                        default:
                            System.out.print("Invalid choice");
                            delayOutput(300);
                            System.out.println();
                            break;
                    }

                    if (memChoice == 0) break;
                       }

                    break;

                case 0:
                    break;
                default:
                    System.out.print("Invalid input");
                    delayOutput(300);
                    System.out.println("\n");

                    break;

            }

            if (choice == 0)
                break;

        }
        sc.close();
        System.out.println("End");
        System.exit(0);

    }

    public static int readChoice(Scanner sc) {
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            choice = -999;
        }
        return choice;
    }

    public static void delayOutput(long ms) {
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void searchBooks(Scanner sc) {
        ArrayList<Book> bookList = BookList();
        boolean searching = true;

        do {
            System.out.println("Search by:\n" +
                    "[1] Book Title\n" +
                    "[2] Author\n" +
                    "[3] Back");

            int searchChoice = readChoice(sc);

            switch (searchChoice) {
                case 1:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    displaySearchResults(bookList, searchTitle, "Title");
                    break;

                case 2:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = sc.nextLine();
                    displaySearchResults(bookList, searchAuthor, "Author");
                    break;

                case 0:
                    searching = false;
                    break;
            }
        } while (searching);
    }
    public static void displaySearchResults(ArrayList<Book> bookList, String searchTerm, String searchType) {
        System.out.println("Search Results:");
        System.out.println("==============================================================================");
        System.out.printf("%-4s%-23s%-40s%-20s%n", "ID", "Status", "Title", "Author");
        System.out.println("==============================================================================");

        for (Book book : bookList) {
            String searchField = searchType.equalsIgnoreCase("Title") ? book.getTitle() : book.getAuthor();
            if (searchField.equalsIgnoreCase(searchTerm)) {
                String availability = book.getIsAvailable() ? "Available" : "Not Available";
                String idFormatted = String.format("%-4d", book.getId());
                String availabilityFormatted = String.format("%-23s", availability);
                String titleFormatted = String.format("%-40s", book.getTitle());
                String authorFormatted = String.format("%-20s", book.getAuthor());

                System.out.println(idFormatted + availabilityFormatted + titleFormatted + authorFormatted);
            }
        }
        System.out.println("==============================================================================");
    }
}