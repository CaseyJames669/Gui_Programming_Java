/**
 * Class: Account
 * 
 * Version: Assignment 5 
 * 
 * Date: 11/13/2012
 *
 * Copyright Notice: 10,000 to use this
 *
 * @author Zach Bladow
 */

public class Book 
{	
	/**
	 * Declare All Variables of string type
	 */
	private String Book;
	private String Author;

    /**
     * Default Constructor for Book
     * Setting Variables to "" nothing
     */
    public Book()
    {    	
    	setBook("");
    	setAuthor("");
    }


    /**
     * returns Book Book
     * @return string
     */
	public String getBook() {
		return Book;
	}

	/**
	 * sets Book Book
	 * @param Book the Book is set
	 */
	public void setBook(String book) {
		Book = book;
	}

    /**
     * returns Book Author
     * @return string
     */
	public String getAuthor() {
		return Author;
	}

	/**
	 * sets Book Author
	 * @param Author the Author is set
	 */
	public void setAuthor(String author) {
		Author = author;
	}
	
}
