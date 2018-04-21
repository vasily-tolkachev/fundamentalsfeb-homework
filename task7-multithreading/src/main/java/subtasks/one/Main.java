package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        final int accountNumber = 100;
        Set<Long> accountIdList = new HashSet<>();
        for (int i = 0; i < accountNumber; i++) {
            long accountId = accountManager.createNewAccount();
            accountIdList.add(accountId);
        }
        accountManager.printAccounts();

        accountManager.applyOperations(createOperationListForTest(accountIdList));
    }

    static List<Operation> createOperationListForTest(Set<Long> accountIdList) {
        return new ArrayList<>();
    }
}
