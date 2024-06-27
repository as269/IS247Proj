package com.library.management;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            /*switch (choice) {
                case 1:
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    Member member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        Book book = library.searchBook(bookTitle);
                        if (book != null) {
                            library.borrowBook(generateTransactionID(), new Date(), member, book);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextLine();
                    member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        Book book = library.searchBook(bookTitle);
                        if (book != null) {
                            library.returnBook(generateTransactionID(), new Date(), member, book);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    Book book = library.searchBook(title);
                    if (book != null) {
                        System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }*/
        }
    }

    /*private static Member findMember(Library library, String memberId) {
        for (Member member : library.getMembers()) {
            if (member.getMemberID().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }*/

    private static String generateTransactionID() {
        return "T" + System.currentTimeMillis();
    }
}
