package com.library.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Represents a library with books, members, and transaction management.
 */
public class Library {
    private ArrayList<Book> books;
    private Map<String, Member> members;
    private ArrayList<Transaction> transactions;
    private Stack<Transaction> transactionHistory;

    /**
     * Constructs a Library object with initial empty lists and maps.
     */
    public Library() {
        books = new ArrayList<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
        transactionHistory = new Stack<>();
    }

    /**
     * Adds a book to the library's collection.
     * @param book The book to add to the library.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Adds a member to the library's member database.
     * @param member The member to add to the library.
     */
    public void addMember(Member member) {
        members.put(member.getMemberID(), member);
    }

    /**
     * Finds a member by their ID.
     * @param memberId The ID of the member to find.
     * @return The member object if found, null otherwise.
     */
    public Member findMemberById(String memberId) {
        return members.get(memberId);
    }

    /**
     * Initiates a borrowing transaction for a member to borrow a book.
     * @param transactionID The ID of the transaction.
     * @param transactionDate The date of the transaction.
     * @param member The member borrowing the book.
     * @param book The book being borrowed.
     */
    public void borrowBook(String transactionID, Date transactionDate, Member member, Book book) {
        BorrowTransaction borrowTransaction = new BorrowTransaction(transactionID, transactionDate, book, member);
        borrowTransaction.process();
        transactions.add(borrowTransaction);
        transactionHistory.push(borrowTransaction);
    }

    /**
     * Initiates a return transaction for a member to return a book.
     * @param transactionID The ID of the transaction.
     * @param transactionDate The date of the transaction.
     * @param member The member returning the book.
     * @param book The book being returned.
     */
    public void returnBook(String transactionID, Date transactionDate, Member member, Book book) {
        ReturnTransaction returnTransaction = new ReturnTransaction(book, member);
        returnTransaction.process();
        transactions.add(returnTransaction);
        transactionHistory.push(returnTransaction);
    }

    /**
     * Searches for a book in the library by title or ISBN.
     * @param query The title or ISBN of the book to search for.
     * @return The book object if found, null otherwise.
     */
    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getISBN().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Displays the transaction history of the library.
     */
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
