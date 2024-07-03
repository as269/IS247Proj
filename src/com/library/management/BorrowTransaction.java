package com.library.management;

import java.util.Date;

/**
 * Represents a borrowing transaction of a book by a member.
 */
public class BorrowTransaction extends Transaction {
    private final Book book;
    private final Member member;
    private final Date transactionDate;

    /**
     * Constructs a BorrowTransaction object with specified details.
     * @param transactionID The ID of the transaction.
     * @param transactionDate The date of the transaction.
     * @param book The book being borrowed.
     * @param member The member borrowing the book.
     */
    public BorrowTransaction(String transactionID, Date transactionDate, Book book, Member member) {
        super();
        this.book = book;
        this.member = member;
        this.transactionDate = transactionDate;
    }

    /**
     * Retrieves the book involved in the transaction.
     * @return The book involved in the transaction.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Retrieves the member involved in the transaction.
     * @return The member involved in the transaction.
     */
    public Member getMember() {
        return member;
    }

    /**
     * Retrieves the date of the transaction.
     * @return The date of the transaction.
     */
    public Date getTransactionDate(){
        return transactionDate;
    }

    /**
     * Processes the borrowing transaction.
     * Checks if the book is available and assigns it to the member if so.
     */
    @Override
    public void process() {
        if (book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }
}
