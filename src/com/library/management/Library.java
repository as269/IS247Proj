import com.library.management.Book;

import java.util.ArrayList;

public void Library() {
    books = new ArrayList<>();
    members = new ArrayList<>();
}

public void addBook(String title, String author) {
    books.add(new Book(title, author));
}

public void addMember(String name) {
    members.add(new Member(name));
}

public void borrowBook(String title, String memberName) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
            book.borrowBook();
            System.out.println(memberName + " has borrowed " + title);
            return;
        }
    }
    System.out.println(title + " is not available.");
}

public void returnBook(String title) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
            book.returnBook();
            System.out.println(title + " has been returned.");
            return;
        }
    }
    System.out.println(title + " was not borrowed.");
}

public void displayBooks() {
    for (Book book : books) {
        System.out.println(book);
    }
}

public void displayMembers() {
    for (Member member : members) {
        System.out.println(member);
    }
}

public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display Books");
        System.out.println("6. Display Members");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                library.addBook(title, author);
                break;
            case 2:
                System.out.print("Enter member name: ");
                String name = scanner.nextLine();
                library.addMember(name);
                break;
            case 3:
                System.out.print("Enter book title to borrow: ");
                title = scanner.nextLine();
                System.out.print("Enter member name: ");
                name = scanner.nextLine();
                library.borrowBook(title, name);
                break;
            case 4:
                System.out.print("Enter book title to return: ");
                title = scanner.nextLine();
                library.returnBook(title);
                break;
            case 5:
                library.displayBooks();
                break;
            case 6:
                library.displayMembers();
                break;
            case 7:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}