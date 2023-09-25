// import java.util.Scanner;

// public class LibrarySystem {
//     public static void main(String[] args) {
//         String divider = "--------------------------";

//         // Create a library
//         Library library = new Library();

//         // Initialize hard-coded members
//         Member member1 = new Member(12, "Matsuo");
//         Member member2 = new Member(23, "Hikari");
//         Member member3 = new Member(34, "MinMin");
//         Member member4 = new Member(41, "Hayate");
//         library.addMember(member1);
//         library.addMember(member2);
//         library.addMember(member3);
//         library.addMember(member4);

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Welcome..");
//         while (true) {

//             System.out.print("[1] View Books\n" +
//                     "[2] View Members\n" +
//                     "[0] Exit\n" +
//                     "Enter choice: ");// menu 1
//             int choice = readChoice(sc);

//             switch (choice) {
//                 case 1: // View books
//                     while (true) {
//                         // Print book list
//                         System.out.println(divider);
//                         System.out.printf("%5s%5s%15s%n", " ", "Title", "Author");// pwede wala format
//                         System.out.println("1 title author");// replace

//                         // Print menu
//                         System.out.println(divider);
//                         System.out.print("[1] Select book\n" +
//                                 "[2] Search Book\n" +
//                                 "[3] Add book\n" +
//                                 "[0] Back\n" +
//                                 "Enter choice: ");

//                         int bookChoice = readChoice(sc);

//                         switch (bookChoice) {
//                             case 1: // Select book
//                                 System.out.println("Enter book number: ");

//                                 break;
//                             case 2: // Search book
//                                 System.out.println("Search: ");

//                                 break;
//                             case 3: // Add book
//                                 System.out.println("Enter...");

//                                 break;

//                             case 0:
//                                 break;

//                             default:
//                                 System.out.print("Invalid choice");
//                                 delayOutput(300);
//                                 System.out.println();
//                                 break;

//                         }

//                         if (bookChoice == 0)
//                             break;
//                     }

//                     break;
//                 case 2: // View members
//                     while (true) {
//                         // Print members
//                         System.out.println(divider);
//                         System.out.printf("%5s%5s%n", " ", "Name");// pwede wala format
//                         System.out.println("1 Name");// replace

//                         // Print menu
//                         System.out.println(divider);
//                         System.out.print("[1] Select member\n" +
//                                 "[2] Search member\n" +
//                                 "[3] Add member\n" +
//                                 "[0] Back\n" +
//                                 "Enter choice: ");

//                         int memChoice = readChoice(sc);
//                         switch (memChoice) {
//                             case 1: // Select member
//                                 // Print list of members
//                                 System.out.println(divider);
//                                 System.out.println("Members:");
//                                 library.displayMembers();

//                                 // Select a member
//                                 System.out.print("Enter member ID: ");
//                                 int memberId = readChoice(sc);
//                                 Member selectedMember = library.getMemberById(memberId);

//                                 if (selectedMember != null) {
//                                     // View borrowed books of the selected member
//                                     library.viewBorrowedBooks(selectedMember);
//                                 } else {
//                                     System.out.println("Member not found.");
//                                 }
//                                 break;
//                             case 2: // Search member
//                                 System.out.println("Search");

//                                 break;
//                             case 3: // Add member
//                                 System.out.println("");

//                                 break;
//                             case 0:
//                                 break;

//                             default:
//                                 System.out.print("Invalid choice");
//                                 delayOutput(300);
//                                 System.out.println();
//                                 break;
//                         }

//                         if (memChoice == 0) break;
//                     }

//                     break;

//                 case 0:
//                     break;
//                 default:
//                     System.out.print("Invalid input");
//                     delayOutput(300);
//                     System.out.println("\n");

//                     break;

//             }

//             if (choice == 0)
//                 break;

//         }
//         sc.close();
//         System.out.println("End");
//         System.exit(0);

//     }

//     public static int readChoice(Scanner sc) {
//         int choice;
//         try {
//             choice = Integer.parseInt(sc.nextLine());
//         } catch (Exception e) {
//             choice = -999;
//         }
//         return choice;
//     }

//     public static void delayOutput(long ms) {
//         for (int i = 0; i < 3; i++) {
//             System.out.print(".");
//             try {
//                 Thread.sleep(ms);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
//      public static void viewBorrowedBooks(Library library, Member member) {
//         List<Book> borrowedBooks = member.getBorrowedBooks();
//         System.out.println("Borrowed Books by " + member.getName() + ":");
//         for (Book book : borrowedBooks) {
//             System.out.println(book);
//         }
//     }

//     public static void displayAvailableBooks(Library library) {
//         List<Book> availableBooks = library.getAvailableBooks();
//         System.out.println("Available Books:");
//         for (Book book : availableBooks) {
//             System.out.println(book);
//         }
//     }
// }

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        String divider = "--------------------------";

        // Create a library
        Library library = new Library();

        // Initialize hard-coded members
        Member member1 = new Member(12, "Matsuo");
        Member member2 = new Member(23, "Hikari");
        Member member3 = new Member(34, "MinMin");
        Member member4 = new Member(41, "Hayate");
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
        library.addMember(member4);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        while (true) {
            System.out.print("[1] View Books\n" +
                    "[2] View Members\n" +
                    "[3] Borrow Book\n" +
                    "[4] Return Book\n" +
                    "[0] Exit\n" +
                    "Enter choice: ");

            int choice = readChoice(sc);

            switch (choice) {
                case 1: // View books
                    System.out.println(divider);
                    System.out.println("Available Books:");
                    for (Book book : library.getAvailableBooks()) {
                        System.out.println(book);
                    }
                    break;
                case 2: // View members
                    System.out.println(divider);
                    System.out.println("Members:");
                    for (Member member : library.getMembers()) {
                        System.out.println(member);
                    }
                    break;
                case 3: // Borrow Book
                    System.out.print("Enter member ID: ");
                    int memberId = readChoice(sc);
                    Member borrower = library.getMemberById(memberId);
                    if (borrower == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    System.out.print("Enter book ID to borrow: ");
                    int bookId = readChoice(sc);
                    Book bookToBorrow = library.getBookById(bookId);
                    if (bookToBorrow == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    library.borrowBook(borrower, bookToBorrow);
                    System.out.println("Book borrowed successfully.");
                    break;
                case 4: // Return Book
                    System.out.print("Enter member ID: ");
                    int returnMemberId = readChoice(sc);
                    Member returnMember = library.getMemberById(returnMemberId);
                    if (returnMember == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    System.out.print("Enter book ID to return: ");
                    int returnBookId = readChoice(sc);
                    Book bookToReturn = library.getBookById(returnBookId);
                    if (bookToReturn == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    library.returnBook(returnMember, bookToReturn);
                    System.out.println("Book returned successfully.");
                    break;

                case 5: // Search Member (Added option)
                    System.out.print("Enter member ID to search: ");
                    int searchMemberId = readChoice(sc);
                    Member searchMember = library.getMemberById(searchMemberId);
                    if (searchMember == null) {
                        System.out.println("Member not found.");
                    } else {
                        System.out.println("Borrowed Books by " + searchMember.getName() + ":");
                        List<Book> borrowedBooks = searchMember.getBorrowedBooks();
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No books borrowed.");
                        } else {
                            for (Book book : borrowedBooks) {
                                System.out.println(book);
                            }
                        }
                    }
                    break;

                case 0:
                    sc.close();
                    System.out.println("Thank you for using the Library Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
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
}
