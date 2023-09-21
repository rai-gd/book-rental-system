class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

     public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
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

}