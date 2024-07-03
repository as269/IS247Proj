package com.library.management;

/**
 * Represents a book in the library system.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    /**
     * Constructs a Book object with specified title, author, and ISBN.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The ISBN of the book.
     */
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
    }

    /**
     * Constructs a Book object with specified title and author.
     * Default ISBN is set to "Unknown".
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) { // Method overloading
        this(title, author, "Unknown");
    }

    /**
     * Returns the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the ISBN of the book.
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     * @param ISBN The new ISBN to set.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Checks if the book is available for borrowing.
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of the book.
     * @param available true to set the book as available, false otherwise.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a string representation of the Book object.
     * @return A string representation of the Book object.
     */
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, ISBN: %s, Available: %s", title, author, ISBN, available);
    }
}
