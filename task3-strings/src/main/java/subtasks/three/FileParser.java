package subtasks.three;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileParser {
    private static final Logger log = LogManager.getLogger(Main.class);

    private FileParser() {}

    static String readFileToString(InputStream inputStream) {
        StringBuilder textBuilder = new StringBuilder();
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                inputStream, Charset.forName("Windows-1251")))
        ) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                textBuilder.append(string);
            }
        } catch (FileNotFoundException e) {
            log.info("Main.readFileToString file not found");
        } catch (IOException e) {
            log.info("Main.readFileToString file IOException");
        }
        return textBuilder.toString();
    }

    static List<String> splitBySentences(CharSequence text) {
        List<String> sentences = new ArrayList<>();
        Pattern p = Pattern.compile("([А-Я]([^?!.(]|\\([^)]+\\))*[.?!])");
        Matcher m = p.matcher(text);
        while (m.find()) {
            sentences.add(m.group());
        }
        return sentences;
    }
}
