package com.library.management;

import java.util.ArrayList;

/**
 * Represents a member of the library who can borrow books.
 */
public class Member implements Borrowable {
    private String name;
    private String memberID;
    private ArrayList<Book> borrowedBooks;

    /**
     * Constructs a Member object with specified name and member ID.
     * @param name The name of the member.
     * @param memberID The ID of the member.
     */
    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Retrieves the name of the member.
     * @return The name of the member.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the ID of the member.
     * @return The ID of the member.
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * Allows the member to borrow a specified book.
     * @param book The book to borrow.
     */
    @Override
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Allows the member to return a specified book.
     * @param book The book to return.
     */
    @Override
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    /**
     * Checks if the member has borrowed a specified book.
     * @param book The book to check.
     * @return true if the member has borrowed the book, false otherwise.
     */
    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    /**
     * Returns a string representation of the Member object.
     * @return A string representation of the Member object.
     */
    @Override
    public String toString() {
        return String.format("Name: %s, MemberID: %s", name, memberID);
    }
}
