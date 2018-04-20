package subtasks.one;

public class Operation {
    private Operation() {
    }

    public static void apply(Account account, OperationType type, long value) {
        if (type == OperationType.DEPOSIT) {
            account.increase(value);
        } else if (type == OperationType.WITHDRAW) {
            account.decrease(value);
        }
    }

}