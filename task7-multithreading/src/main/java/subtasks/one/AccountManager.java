package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

class AccountManager {
    private static final Logger log = LogManager.getLogger(Main.class);
    private final Map<Long, Account> accounts;

    AccountManager() {
        this.accounts = new HashMap<>();
    }

    long createNewAccount(long initialBalance) {
        Random random = new Random();
        long newID;
        do {
            do {
                newID = random.nextLong();
            } while (random.nextLong() == Long.MIN_VALUE);
            newID = Math.abs(newID);
        } while (accounts.containsKey(newID));
        accounts.put(newID, new Account(initialBalance));
        return newID;
    }

    void printAccounts() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
            builder.append("\nAccount ID: ").append(entry.getKey()).append(" ").append(entry.getValue());
        }
        log.info("\nAccount list:{}\n", builder.toString());
    }

    void applyOperations(List<Operation> operationList) {
        for (Operation operation: operationList) {
            if (accounts.containsKey(operation.getAccountId())) {
                operation.apply(accounts.get(operation.getAccountId()));
            }
        }
    }

    long getCheckSumForTest() {
        long sum = 0;
        for (Account account : accounts.values()) {
            sum += account.getBalance();
        }
        return sum;
    }
}
