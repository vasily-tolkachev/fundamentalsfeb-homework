package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Account account1 = new Account(1, 330);
        Account account2 = new Account(2, 1330);

        Operation.apply(account1, OperationType.DEPOSIT, 200);
        Operation.apply(account2, OperationType.WITHDRAW, 200);

        System.out.println("account1.getBalance() = " + account1.getBalance());
        System.out.println("account2.getBalance() = " + account2.getBalance());
    }
}