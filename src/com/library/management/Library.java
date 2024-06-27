package com.library.management;

import java.util.ArrayList;
import java.util.Date;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }
/*
    public void borrowBook(String transactionID, Date transactionDate, Member member, Book book) {
        BorrowTransaction borrowTransaction = new BorrowTransaction(transactionID, transactionDate, book, member);
        borrowTransaction.process();
        transactions.add(borrowTransaction);
    }

    public void returnBook(String transactionID, Date transactionDate, Member member, Book book) {
        ReturnTransaction returnTransaction = new ReturnTransaction(transactionID, transactionDate, book, member);
        returnTransaction.process();
        transactions.add(returnTransaction);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    } */
}
