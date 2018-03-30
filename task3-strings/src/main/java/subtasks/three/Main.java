package subtasks.three;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String FILE_NAME = "/Java.SE.03.Information handling_task_attachment.html";

    public static void main(String... args) {
        InputStream inputStream = Main.class.getResourceAsStream(FILE_NAME);
        List<String> sentences = FileParser.splitBySentences(FileParser.readFileToString(inputStream));
        log.info("Size", sentences.size());
    }

}
