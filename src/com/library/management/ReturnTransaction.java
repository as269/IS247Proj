package com.library.management;

import java.util.Date;

public class ReturnTransaction extends Transaction {
    private final Book book;
    private final Member member;
    private final Date transactionDate;

    public ReturnTransaction(Book book, Member member) {
        super();
        this.book = book;
        this.member = member;
        this.transactionDate = new Date();
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

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
