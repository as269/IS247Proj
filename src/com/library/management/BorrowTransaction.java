package com.library.management;

import java.util.Date;

public class BorrowTransaction extends Transaction {
    private final Book book;
    private final Member member;
    private final Date transactionDate;

    public BorrowTransaction(String transactionID, Date transactionDate, Book book, Member member) {
        super();
        this.book = book;
        this.member = member;
        this.transactionDate = transactionDate;
    }

    public Book getBook() {
        return book;
    }
    public Member getMember() {
        return member;
    }
    public Date getTransactionDate(){
        return transactionDate;
    }

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
