package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OperationReader {
    private static final Logger log = LogManager.getLogger(OperationReader.class);

    private OperationReader() {}

    static List<Operation> getOperations(File file) {
        List<Operation> operationList = new ArrayList<>();
        try {
            operationList = parseOperations(getStringListFromFile(file));
        } catch (ParseException e) {
            log.info(e.getMessage());
        }
        return operationList;
    }

    private static List<Operation> parseOperations(List<String> stringList) throws ParseException {
        List<Operation> operationList = new ArrayList<>();
        for (String string : stringList) {
            string = string.trim();
            if (!string.matches("(^Operation*\\{*accountId=\\d+, *type=\\w+, *value=\\d+ *}$)")) {
                throw new ParseException("ParseException on string [" + string + "]", 0);
            }
            long accountId = Long.parseLong(getValue("accountId", string));
            OperationType type = OperationType.valueOf(getValue("type", string));
            long value = Long.parseLong(getValue("value", string));
            operationList.add(new Operation(accountId, type, value));
        }
        return operationList;
    }

    private static String getValue(String valueToGet, String string) throws ParseException {
        Matcher matcher = Pattern.compile(valueToGet + "=.*?(?=[,}])").matcher(string);
        if (matcher.find()) {
            return matcher.group().split("=")[1];
        } else {
            throw new ParseException("ParseException on string [" + string + "]", 0);
        }
    }

    private static List<String> getStringListFromFile(File file) {
        List<String> stringList = new ArrayList<>();
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(file))
        ) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringList.add(string);
            }
        } catch (FileNotFoundException e) {
            log.info("OperationReader.getStringListFromFile file not found");
        } catch (IOException e) {
            log.info("OperationReader.getStringListFromFile IOException");
        }
        return stringList;
    }
}
