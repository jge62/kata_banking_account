package jge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void iCanCreateBankAccount() {
        new BankAccount(0f);
    }

    @Test
    void iCanMakeDepositOnBankAccount() {
        final BankAccount bankAccount = new BankAccount(0f);
        bankAccount.deposit(100f);
    }

    @Test
    void depositNegativeAmountOnBankAccountThrowException() {
        final BankAccount bankAccount = new BankAccount(0f);
        assertThrows(AssertionError.class,
                () -> bankAccount.deposit(-100f));
    }

    @Test
    void iCanReadBalanceOnBankAccount() {
        final BankAccount bankAccount = new BankAccount(0f);
        assertEquals(0f, bankAccount.readBalance());
    }

    @Test
    void iCanDepositOnBankAccountAndReadDepositValue() {
        final BankAccount bankAccount = new BankAccount(0f);
        bankAccount.deposit(10f);
    }

    @Test
    void iCanWithdrawalOnBankAccount() {
        final BankAccount bankAccount = new BankAccount(0f);
        bankAccount.withdrawal(10f);
    }

    @Test
    void withdrawalNegativeAmountOnBankAccountThrowException() {
        final BankAccount bankAccount = new BankAccount(0f);
        assertThrows(AssertionError.class,
                () -> bankAccount.withdrawal(-100f));
    }

    @Test
    void iCanWithdrawalOnBankAccountAndReadDepositValue() {
        BankAccount bankAccount = new BankAccount(0f);
        bankAccount.withdrawal(10f);
        assertEquals(-10f, bankAccount.readBalance());
    }

    @Test
    void iCanReadDepositOperationInBankAccountHistory() {
        BankAccount bankAccount = new BankAccount(0f);
        bankAccount.deposit(10f);
        assertNotNull(bankAccount.getHistory());
        Assertions.assertEquals(1, bankAccount.getHistory().size());
    }


}
