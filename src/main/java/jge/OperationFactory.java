package jge;

import java.time.Instant;

public class OperationFactory {


    public static Operation createDeposit(Instant depositInstant, float amount, float finalBalance) {
        assert amount > 0;
        return new Operation(OperationType.deposit, depositInstant, amount, finalBalance);
    }

    public static Operation createWithdrawal(Instant withdrawalInstant, float amount, float finalBalance) {
        assert amount > 0;
        return new Operation(OperationType.withdrawal, withdrawalInstant, amount, finalBalance);
    }
}
