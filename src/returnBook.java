public void returnBook(String title) {
    Book foundBook = null;
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
            foundBook = book;
            break;
        }
    }
    if (foundBook != null) {
        Member foundMember = null;
        for (Member member : members) {
            if (member.hasBorrowed(foundBook)) {
                foundMember = member;
                break;
            }
        }
        if (foundMember != null) {
            // Create and process the return transaction
            ReturnTransaction transaction = new ReturnTransaction(
                    generateTransactionID(), new Date(), foundBook, foundMember);
            transaction.process();
        } else {
            System.out.println("Member who borrowed " + title + " not found.");
        }
    } else {
        System.out.println("Book " + title + " was not borrowed.");
    }
}
