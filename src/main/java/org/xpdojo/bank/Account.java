package org.xpdojo.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private int amount;

    public void deposit(final int value) {
        amount += value;
    }

    public int getAmount() {
        return amount;
    }

    public void withdraw(final int value) {
        if (0 > amount - value) {
            throw new IllegalStateException();
        }
        amount -= value;
    }

    public void transfer(final Account to, final Account from, int value) {
        to.amount += value;
        from.amount -= value;
    }
}
