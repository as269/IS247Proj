package com.library.management;

import java.util.Date;

public abstract class Transaction {
    private String transactionID;
    private Date transactionDate;

    public Transaction(String transactionID, Date transactionDate) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Abstract method to be implemented by subclasses
    public abstract void process();
}
