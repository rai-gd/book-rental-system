import java.util.ArrayList;
import java.util.List;

/**
* The `Book` class represents a basic data structure for storing information about books.
* It encapsulates three main attributes of a book: its unique identifier (`id`), title, and author.
* This class provides methods to access and manipulate these attributes.
*/
class Book {
	private int id;
	private boolean isAvailable;
    private String title;
	private String author;

	/**
    * Constructor for creating a new `Book` object.
    * Initializes the `id`, `title`, and `author` attributes with the provided values.
    *
    * @param id     The unique identifier for the book.
    * @param title  The title of the book.
    * @param author The author of the book.
    */
	public Book(int id, boolean isAvailable, String title, String author) {
		this.id = id;
		this.isAvailable = isAvailable;
	    this.title = title;
		this.author = author;
	}
	
	/**
    * Gets the unique identifier of the book.
    *
    * @return An integer representing the book's ID.
    */
	public int getId() {
	    return id;
	}

	/**
	 * Determines the status of the the book if available or not.
	 *
	 * @return A boolean value representing the availablity of the book.
	 */
	public boolean isAvailable { return isAvailable; }

	/**
    * Gets the title of the book.
    *
    * @return A string representing the book's title.
    */
    public String getTitle() {
	    return title;
	}

    /**
    * Gets the author of the book.
    * 
	* @return A string representing the book's author.
    */
    public String getAuthor() {
	    return author;
	}

	/**
    * Overrides the default `toString` method to provide a custom string representation of the `Book` object.
	*
    * @return A string containing book details in the format: "Book [id=<id>, title=<title>, author=<author>]".
    */
    @Override
	public String toString() {
	    return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
}