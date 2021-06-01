package jge;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Test
    void ICanCreateDepositOperation() {
        final Instant now = Instant.now();
        OperationFactory.createDeposit(now, 12f, 12f);
    }

    @Test
    void CreateDepositOperationWithNegativeAmountThrowException() {
        final Instant now = Instant.now();
        assertThrows(AssertionError.class,
                () -> OperationFactory.createDeposit(now, -12f, 12f));
    }

    @Test
    void ICanInstantiateDepositOperation() {
        final Operation deposit = OperationFactory.createDeposit(Instant.now(), 12f, 12f);
        assertNotNull(deposit);
    }

    @Test
    void ICanCreateWithdrawalOperation() {
        OperationFactory.createDeposit(Instant.now(), 12f, 0f);
    }

    @Test
    void CreateWithdrawalOperationWithNegativeAmountThrowException() {
        final Instant now = Instant.now();
        assertThrows(AssertionError.class,
                () -> OperationFactory.createDeposit(now, -12f, 0f));
    }

    @Test
    void ICanInstantiateWithdrawalOperation() {
        final Operation withdrawal = OperationFactory.createWithdrawal(Instant.now(), 12f, 0f);
        assertNotNull(withdrawal);
    }

    @Test
    void ICanWriteHumanReadableWithdrawal() throws ParseException {
        final Instant operationInstant = simpleDateFormat.parse("31/05/2021 23:12:00").toInstant();
        final Operation withdrawal = OperationFactory.createWithdrawal(operationInstant, 806f, -806f);
        assertEquals("withdrawal the 31/05/2021 23:12:00 of 806.0 final balance -806.0",
                withdrawal.toString());
    }

    @Test
    void ICanWriteHumanReadableDeposit() throws ParseException {
        final Instant operationInstant = simpleDateFormat.parse("31/05/2021 23:56:00").toInstant();
        final Operation withdrawal = OperationFactory.createDeposit(operationInstant, 62f, 2806f);
        assertEquals("dosit the 31/05/2021 23:56:00 of 62.0 final balance 2806.0",
                withdrawal.toString());
    }


}
