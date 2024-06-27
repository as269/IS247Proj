public void borrowBook(String title, String memberName) {
    Book foundBook = null;
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
            foundBook = book;
            break;
        }
    }
    if (foundBook != null) {
        Member foundMember = null;
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                foundMember = member;
                break;
            }
        }
        if (foundMember != null) {
            // Create and process the borrow transaction
            BorrowTransaction transaction = new BorrowTransaction(
                    generateTransactionID(), new Date(), foundBook, foundMember);
            transaction.process();
        } else {
            System.out.println("Member " + memberName + " not found.");
        }
    } else {
        System.out.println("Book " + title + " is not available.");
    }
}
