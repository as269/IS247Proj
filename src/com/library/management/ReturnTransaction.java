package com.library.management;

import java.util.Date;

public class ReturnTransaction extends Transaction {
    private Book book;
    private Member member;

    public ReturnTransaction(String transactionID, Date transactionDate, Book book, Member member) {
        super(transactionID, transactionDate);
        this.book = book;
        this.member = member;
    }

    @Override
    public void process() {
        // Implement returning logic here
        if (member.hasBorrowed(book)) {
            member.returnBook(book);
            book.setAvailable(true);
            System.out.println(book.getTitle() + " has been returned by " + member.getName());
        } else {
            System.out.println(member.getName() + " did not borrow " + book.getTitle());
        }
    }
}
