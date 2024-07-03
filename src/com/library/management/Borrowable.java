package com.library.management;

/**
 * Interface representing borrowable items in the library.
 */
public interface Borrowable {
    /**
     * Borrow a specified book.
     * @param book The book to be borrowed.
     */
    void borrowBook(Book book);

    /**
     * Return a specified book.
     * @param book The book to be returned.
     */
    void returnBook(Book book);
}
