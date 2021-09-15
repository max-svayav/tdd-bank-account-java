package org.xpdojo.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private int amount;
    private ArrayList<Operation> operations = new ArrayList<>();

    public void deposit(final int value) {
        amount += value;
        operations.add(new Operation());
    }

    public int getAmount() {
        return amount;
    }

    public void withdraw(final int value) {
        if (0 > amount - value) {
            throw new IllegalStateException();
        }
        amount -= value;
        operations.add(new Operation());
    }

    public void transfer(final Account to, int value) {
        if (0 > this.amount - value) {
            throw new IllegalStateException();
        }
        to.amount += value;
        to.operations.add(new Operation());
        this.amount -= value;
        this.operations.add(new Operation());
    }

    public List<Operation> getOperations() {
        return (List<Operation>) operations.clone();
    }
}
