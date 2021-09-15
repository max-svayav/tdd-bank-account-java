package org.xpdojo.bank;

import java.util.Collection;
import java.util.Collections;
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

    public void transfer(final Account to, int value) {
        if (0 > this.amount - value) {
            throw new IllegalStateException();
        }
        to.amount += value;
        this.amount -= value;
    }

    public Collection getOperations() {
        return Collections.EMPTY_LIST;
    }
}
