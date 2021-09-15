package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Account subject;

    @Test
    public void accountStartsEmpty() {
        subject = new Account();
        assertEquals(0, subject.getAmount());
    }

    @Test
    public void depositAnAmount() {
        subject = new Account();
        subject.deposit(100);
        assertEquals(100, subject.getAmount());
    }

    @Test
    public void depositMultipleAmounts() {
        subject = new Account();
        subject.deposit(100);
        subject.deposit(100);
        assertEquals(200, subject.getAmount());
    }

}
