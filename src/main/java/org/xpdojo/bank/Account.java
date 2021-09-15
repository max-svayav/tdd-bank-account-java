package org.xpdojo.bank;

public class Account {
    private int amount;

    public void deposit(final int value) {
        amount += value;
    }

    public int getAmount() {
        return amount;
    }
}
