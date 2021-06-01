package jge;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Operation {


    private final OperationType operationType;
    private final Instant operationInstant;
    private final float amount;
    private final float finalBalance;


    Operation(final OperationType operationType,
              final Instant operationInstant,
              final float amount,
              final float finalBalance) {
        this.operationType = operationType;
        this.operationInstant = operationInstant;
        this.amount = amount;
        this.finalBalance = finalBalance;
    }

    @Override
    public String toString() {
        return String.format("%s the %s of %s final balance %s",
                operationType.name(),
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                        .format(Date.from(operationInstant)),
                amount,
                finalBalance);
    }
}
