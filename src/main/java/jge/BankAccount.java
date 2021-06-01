package jge;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {

    private final List<Operation> history;
    private float balance;

    public BankAccount(float balance){
        this.balance = balance;
        history = new ArrayList<>();
    }

    public void deposit(float deposit) {
        assert deposit>0;
        balance+=deposit;
        history.add(OperationFactory.createDeposit(Instant.now(), deposit, balance));
    }

    public float readBalance() {
        return balance;
    }

    public void withdrawal(float withdrawalValue) {
        assert withdrawalValue > 0;
        balance-= withdrawalValue;
    }

    public List<Operation> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
