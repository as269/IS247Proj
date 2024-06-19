package com.library.management;

public interface Borrowable {
    void borrowBook(Book book);
    void returnBook(Book book);
}
