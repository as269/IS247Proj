package com.library.management;

/**
 * Abstract class representing a transaction in the library.
 */
public abstract class Transaction {
    /**
     * Processes the transaction (to be implemented by subclasses).
     */
    public abstract void process();
}
