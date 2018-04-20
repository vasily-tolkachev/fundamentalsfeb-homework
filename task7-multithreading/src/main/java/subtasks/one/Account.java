package subtasks.one;

public class Account {
    private long balance;
    private final long id;

    public Account(long id, long balance) {
        this.balance = balance;
        this.id = id;
    }

    public void increase(long value) {
        this.balance += value;
    }

    public void decrease(long value) {
        this.balance -= value;
    }

    public long getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }
}
