package subtasks.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String SOURCE_FILE = "task7-multithreading/src/main/java/subtasks/two/prop.properties";

    public static void main(String[] args) {
        PropertiesReader propertiesReader = new PropertiesReader();
        File file = new File(SOURCE_FILE);
        Map<String, String> propertiesMap = new ConcurrentHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(file);
            propertiesReader.load(inputStream, propertiesMap);
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
            log.info(e);
            e.printStackTrace();
        } catch (IOException e) {
            log.info("IOException at method main");
            log.info(e);
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> result : propertiesMap.entrySet()) {
            builder.append('\n').append("Key: ").append(result.getKey()).append('\n');
            builder.append("Value: ").append(result.getValue()).append('\n');
        }
        log.info(builder.toString());
    }
}