package com.library.management;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    private static void displayMainMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. Search Book");
        System.out.println("4. Display Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                searchBook();
                break;
            case 4:
                library.displayTransactionHistory();
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        while (true) {
            displayMainMenu();
            int choice = getChoice();
            processChoice(choice);
        }
    }

    private static int getChoice() {
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
        return choice;
    }

    private static void borrowBook() {
        Member member = null;
        while (member == null) {
            System.out.print("Enter member ID: ");
            String memberId = scanner.nextLine();
            member = library.findMemberById(memberId);

            if (member == null) {
                System.out.println("Member not found. Please try again.");
            }
        }

        System.out.print("Enter book title or ISBN: ");
        String query = scanner.nextLine();
        Book book = library.searchBook(query);

        if (book != null && book.isAvailable()) {
            library.borrowBook(generateTransactionID(), new Date(), member, book);
            System.out.println("Book '" + book.getTitle() + "' borrowed by " + member.getName());
        } else {
            System.out.println("Book is not available.");
        }
    }

    private static void returnBook() {
        Member member = null;
        while (member == null) {
            System.out.print("Enter member ID: ");
            String memberId = scanner.nextLine();
            member = library.findMemberById(memberId);

            if (member == null) {
                System.out.println("Member not found. Please try again.");
            }
        }

        System.out.print("Enter book title or ISBN: ");
        String query = scanner.nextLine();
        Book book = library.searchBook(query);

        if (book != null && member.hasBorrowedBook(book)) {
            library.returnBook(generateTransactionID(), new Date(), member, book);
            System.out.println("Book '" + book.getTitle() + "' returned by " + member.getName());
        } else {
            System.out.println("Book was not borrowed by the member.");
        }
    }

    private static void searchBook() {
        System.out.print("Enter book title or ISBN: ");
        String query = scanner.nextLine();
        Book book = library.searchBook(query);

        if (book != null) {
            System.out.printf("Book found: %s by %s\n", book.getTitle(), book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static String generateTransactionID() {
        return "T" + System.currentTimeMillis();
    }
}
