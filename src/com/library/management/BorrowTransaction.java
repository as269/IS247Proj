package com.library.management;

import java.util.Date;

public class BorrowTransaction extends Transaction {
    private Book book;
    private Member member;

    public BorrowTransaction(String transactionID, Date transactionDate) {
        super(transactionID, transactionDate);
    }

    @Override
    public void process() {

    }

    // Specific methods for borrow transaction will be added later
}
