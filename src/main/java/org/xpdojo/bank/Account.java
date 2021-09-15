package org.xpdojo.bank;

public class Account {
    private int amount;

    public void deposit(final int value) {
        amount += value;
    }

    public int getAmount() {
        return amount;
    }

    public void withdraw(final int value) {
        if (0 == amount) {
            throw new IllegalStateException();
        }
        amount -= value;
    }
}
