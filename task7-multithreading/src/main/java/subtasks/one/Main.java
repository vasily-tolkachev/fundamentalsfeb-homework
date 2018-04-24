package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String OPERATIONS_FILE = "task7-multithreading/src/main/java/subtasks/one/operations.txt";

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
        Map<Long, Account> accountsInInitialState = accountManager.getAccountsCopy();
        accountManager.printAccounts();

        final int operationNumber = accountNumber * 10;
        List<Operation> operationListForTest = createOperationListForTest(
                accountIdList, operationNumber, transactionLimitTestValue
        );

        File operationFile = new File(OPERATIONS_FILE);
        writeOperationListToFile(operationListForTest, operationFile);

        List<Operation> operationList = OperationReader.getOperations(operationFile);
        for (Operation operation : operationList) {
            System.out.println(operation);
        }

        accountManager.applyOperations(operationList);
        //accountManager.printAccounts();
        System.out.println("Single thread account manager control sum = " + accountManager.getCheckSumForTest());


        accountManager = new ConcurrentAccountManager(accountsInInitialState);
        accountManager.applyOperations(operationList);
        //accountManager.printAccounts();
        System.out.println("Concurrent account manager control sum = " + accountManager.getCheckSumForTest());
    }

    private static void writeOperationListToFile(List<Operation> operationListForTest, File file) {
        StringBuilder builder = new StringBuilder();
        for (Operation operation : operationListForTest) {
            builder.append(operation).append('\n');
        }

        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
            file.createNewFile();
            bufferedWriter.write(builder.toString());
        } catch (IOException e) {
            log.info("IOException");
        }
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

        return operations;
    }

    private static long generateInitialBalance(long limit) {
        return  (long) (Math.random() * limit);
    }
}
