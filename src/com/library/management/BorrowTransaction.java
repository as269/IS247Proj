package com.library.management;

import java.util.Date;

public class BorrowTransaction extends Transaction {
    private Book book;
    private Member member;

    public BorrowTransaction(String transactionID, Date transactionDate, Book book, Member member) {
        super(transactionID, transactionDate);
        this.book = book;
        this.member = member;
    }

    @Override
    public void process() {
        // Implement borrowing logic here
        if (book.isAvailable() && member.canBorrow()) {
            member.borrowBook(book);
            book.setAvailable(false);
            System.out.println(member.getName() + " has borrowed " + book.getTitle());
        } else {
            System.out.println("Cannot borrow the book.");
        }
    }
}
