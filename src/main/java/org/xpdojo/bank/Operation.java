package org.xpdojo.bank;

public class Operation {

    private final OperationType operationType;

    private Operation(OperationType operationType) {
        this.operationType = operationType;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    public static Operation createDeposit() {
        return new Operation(OperationType.Deposit);
    }

    public static Operation createWithdrawal() {
        return new Operation(OperationType.Withdrawal);
    }

    public static Operation createTransfer() {
        return new Operation(OperationType.Transfer);
    }
}
