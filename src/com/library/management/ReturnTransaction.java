package com.library.management;

import java.util.Date;

/**
 * Represents a return transaction of a borrowed book by a member.
 */
public class ReturnTransaction extends Transaction {
    private final Book book;
    private final Member member;
    private final Date transactionDate;

    /**
     * Constructs a ReturnTransaction object with specified details.
     * @param book The book being returned.
     * @param member The member returning the book.
     */
    public ReturnTransaction(Book book, Member member) {
        super();
        this.book = book;
        this.member = member;
        this.transactionDate = new Date();
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
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * Processes the return transaction.
     * Checks if the member has borrowed the book and updates availability.
     */
    @Override
    public void process() {
        if (member.hasBorrowedBook(book)) {
            book.setAvailable(true);
            member.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }
}
