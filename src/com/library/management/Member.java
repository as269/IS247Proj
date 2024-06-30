package com.library.management;

import java.util.ArrayList;

public class Member implements Borrowable {
    private String name;
    private String memberID;
    private ArrayList<Book> borrowedBooks;

    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMemberID() {
        return memberID;
    }

    @Override
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, MemberID: %s", name, memberID);
    }
}
