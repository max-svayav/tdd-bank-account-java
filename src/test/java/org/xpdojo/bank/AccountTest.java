package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void withdrawAnAmount() {
        subject = new Account();
        final int val = 100;
        subject.deposit(val);
        final int initial = subject.getAmount();
        subject.withdraw(100);
        assertEquals(initial - val, subject.getAmount());
    }

    @Test
    public void cantWithdrawBeforeDepositing() {
        assertThrows(IllegalStateException.class, () -> {
            subject = new Account();
            subject.withdraw(100);
        });
    }

    @Test
    public void cantWithdrawMoreTHanAvailable() {
        assertThrows(IllegalStateException.class, () -> {
            subject = new Account();
            final int val = 100;
            subject.deposit(val);
            final int amount = subject.getAmount();
            subject.withdraw(amount + 1);
        });
    }

    @Test
    public void canTransferFromAnAccount() {
        final Account from = new Account();
        final Account to = new Account();
        final int value = 100;
        from.deposit(value);
        final int fromAmount = from.getAmount();
        final int toAmount = to.getAmount();
        from.transfer(to, value);
        assertEquals(toAmount + value, to.getAmount());
        assertEquals(fromAmount - value, from.getAmount());
    }

    @Test
    public void cantTransferMoreThanAvailable() {
        assertThrows(IllegalStateException.class, () -> {
            final Account from = new Account();
            final Account to = new Account();
            from.transfer(to, from.getAmount() + 1);
        });
    }

    @Test
    public void timeKeeperCanBeConfigureToADate() {
        final TimeKeeper keeper = new TimeKeeper();
        final LocalDateTime now = LocalDateTime.now();
        keeper.setTime(now);
        assertEquals(now, keeper.getTime());
    }

    @Test
    public void canPrintSlip() throws IOException {
        final TimeKeeper keeper = new TimeKeeper();
        final LocalDateTime now = LocalDateTime.now();
        keeper.setTime(now);
        final StringWriter writer = new StringWriter();
        final SlipPrinter printer = new SlipPrinter(writer, keeper);
        final Account account = new Account();
        printer.printSlip(account);
        final String s = writer.toString();
        assertTrue(s.startsWith(now.toString()));
        assertTrue(s.endsWith(String.valueOf(account.getAmount())));
    }

    @Test
    public void accountStartOutWithEmptyOperationsList() {
        final Account account = new Account();
        assertTrue(account.getOperations().isEmpty());
    }



}
