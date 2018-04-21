package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        final int accountNumber = 10;
        final long balanceLimitTestValue = 100000;
        final int transactionLimitTestValue = 10000;

        Set<Long> accountIdList = new HashSet<>();
        for (int i = 0; i < accountNumber; i++) {
            long accountId = accountManager.createNewAccount(generateInitialBalance(balanceLimitTestValue));
            accountIdList.add(accountId);
        }
        accountManager.printAccounts();

        final int operationNumber = accountNumber * 1;
        accountManager.applyOperations(createOperationListForTest(accountIdList, operationNumber, transactionLimitTestValue));
    }

    private static void prepare() {
    }

    private static List<Operation> createOperationListForTest(Set<Long> accountIdList, int operationNumber, int transactionLimit) {
        List<Operation> operations = new ArrayList<>();
        Random random = new Random();
        Object[] idArray =  accountIdList.toArray();
        long accountId;
        OperationType type;
        int transactionValue;
        for (int i = 0; i < operationNumber; i++) {
            accountId = (long)idArray[random.nextInt(accountIdList.size())];
            if (accountId % 2 == 0) {
                type = OperationType.DEPOSIT;
            } else {
                type = OperationType.WITHDRAW;
            }
            transactionValue = random.nextInt(transactionLimit);
            operations.add(new Operation(accountId, type, transactionValue));
        }

        for (Operation operation : operations) {
            System.out.println(operation);
        }

        return operations;
    }

    private static long generateInitialBalance(long limit) {
        return  (long) (Math.random() * limit);
    }
}
