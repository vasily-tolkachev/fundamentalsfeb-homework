package subtasks.one;

import java.util.Objects;

public class Operation {
    private Long accountId;
    private OperationType type;
    private long value;

    Operation(Long accountId, OperationType type, long value) {
        this.accountId = accountId;
        this.type = type;
        this.value = value;
    }

    public void apply(Account account) {
        if (type == OperationType.DEPOSIT) {
            account.increase(value);
        } else if (type == OperationType.WITHDRAW) {
            account.decrease(value);
        }
    }

    public Long getAccountId() {
        return accountId;
    }

    public OperationType getType() {
        return type;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return value == operation.value &&
                Objects.equals(accountId, operation.accountId) &&
                type == operation.type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "accountId=" + accountId +
                ", type=" + type +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountId, type, value);
    }
}