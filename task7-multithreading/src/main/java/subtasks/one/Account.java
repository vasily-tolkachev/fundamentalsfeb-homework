package subtasks.one;

import java.util.Objects;

public class Account {
    private long balance;

    Account(long balance) {
        this.balance = balance;
    }

    void increase(long value) {
        this.balance += value;
    }

    void decrease(long value) {
        this.balance -= value;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return balance == account.balance;
    }

    @Override
    public int hashCode() {

        return Objects.hash(balance);
    }
}
