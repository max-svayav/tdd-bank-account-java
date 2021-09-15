package org.xpdojo.bank;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

public class SlipPrinter {

    final TimeKeeper keeper;
    final Writer io;

    public SlipPrinter(Writer io, TimeKeeper keeper) {
        this.io = io;
        this.keeper = keeper;
    }

    public void printSlip(Account account) throws IOException {
        io.write(keeper.getTime().toString());
        io.write(" ");
        io.write(String.valueOf(account.getAmount()));
    }
}
