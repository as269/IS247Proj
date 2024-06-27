import java.util.ArrayList;
import java.util.Scanner;

public class LibraryRecursion {
    private ArrayList categories;
    private ArrayList members;

    public LibraryRecursion() {
        categories = new ArrayList<>();
        members = new ArrayList<>();
    }
    // add a top-level category to library
    public void addCategory(Category category) {
        categories.add(category);
    }

    // add member to the library
    public void addMember(String name) {
        members.add(new Member(name));
    }

    // recursive method to display categories and books
    public void displayCategories() {
        for (Category category : categories) {
            displayCategory(category, 0);
        }
    }

    // helper method to recursively display category and its contents
    private void displayCategory(Category category, int indent) {
// Indentation for hierarchical display
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Category: " + category.getName());

// display all books in current category
        for (Book book : category.getBooks()) {
            for (int i = 0; i < indent + 1; i++) {
                System.out.print(" ");
            }
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        }

// recursively display all subcategories
        for (Category subcategory : category.getSubcategories()) {
            displayCategory(subcategory, indent + 1);
        }
    }

    // display members in library
    public void displayMembers() {
        for (Member member : members) {
            System.out.println(member.getName());
        }
    }

    // add a book to specific category
    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter category name: ");
        String categoryName = scanner.nextLine();
        Category category = findOrCreateCategory(categoryName);
        category.addBook(new Book(title, author, "default-ISBN")); // Example with default ISBN
    }

    // borrow a book
    public void borrowBook(Scanner scanner) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
// Implement the borrow logic here
    }

    // return a book
    public void returnBook(Scanner scanner) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
// Implement the return logic here
    }

    // recursive method to search for book by title in all categories
    public Book searchBook(String title) {
        for (Category category : categories) {
            Book book = searchBookInCategory(category, title);
            if (book != null) {
                return book;
            }
        }
        return null; // Book not found
    }

    // helper method to recursively search for book within category
    private Book searchBookInCategory(Category category, String title) {
        for (Book book : category.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        for (Category subcategory : category.getSubcategories()) {
            Book book = searchBookInCategory(subcategory, title);
            if (book != null) {
                return book;
            }
        }
// book not found in this category or subcategories
        return null;
    }

    // Helper method to find or create a category
    private Category findOrCreateCategory(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        Category newCategory = new Category(categoryName);
        addCategory(newCategory);
        return newCategory;
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        LibraryRecursion library = new LibraryRecursion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Categories");
            System.out.println("6. Display Members");
            System.out.println("7. Search Book");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.addMember(name);
                    break;
                case 3:
                    library.borrowBook(scanner);
                    break;
                case 4:
                    library.returnBook(scanner);
                    break;
                case 5:
                    library.displayCategories();
                    break;
                case 6:
                    library.displayMembers();
                    break;
                case 7:
                    System.out.print("Enter book title to search: ");
                    String title = scanner.nextLine();
                    Book book = library.searchBook(title);
                    if (book != null) {
                        System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}