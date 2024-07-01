package com.library.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Library {
    private ArrayList<Book> books;
    private Map<String, Member> members;
    private ArrayList<Transaction> transactions;
    private Stack<Transaction> transactionHistory;

    public Library() {
        books = new ArrayList<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
        transactionHistory = new Stack<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberID(), member);
    }

    public Member findMemberById(String memberId) {
        return members.get(memberId);
    }

    public void borrowBook(String transactionID, Date transactionDate, Member member, Book book) {
        BorrowTransaction borrowTransaction = new BorrowTransaction(transactionID, transactionDate, book, member);
        borrowTransaction.process();
        transactions.add(borrowTransaction);
        transactionHistory.push(borrowTransaction);
    }

    public void returnBook(String transactionID, Date transactionDate, Member member, Book book) {
        ReturnTransaction returnTransaction = new ReturnTransaction(book, member);
        returnTransaction.process();
        transactions.add(returnTransaction);
        transactionHistory.push(returnTransaction);
    }

    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getISBN().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }


    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            if (transaction instanceof BorrowTransaction) {
                BorrowTransaction borrowTransaction = (BorrowTransaction) transaction;
                System.out.printf("Date: %s, Member: %s borrowed Book: %s\n",
                        borrowTransaction.getTransactionDate(), borrowTransaction.getMember().getName(),
                        borrowTransaction.getBook().getTitle());
            } else if (transaction instanceof ReturnTransaction) {
                ReturnTransaction returnTransaction = (ReturnTransaction) transaction;
                System.out.printf("Date: %s, Member: %s returned Book: %s\n",
                        returnTransaction.getTransactionDate(), returnTransaction.getMember().getName(),
                        returnTransaction.getBook().getTitle());
            }
        }
    }

}
