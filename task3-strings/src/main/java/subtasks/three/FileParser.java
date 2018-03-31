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
    private static final Logger log = LogManager.getLogger(FileParser.class);

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

    static boolean areReferencesConsistent(CharSequence text) {
        Pattern linkPattern = Pattern.compile("\\([Рр]ис.\\s*(\\d+)|рисунк[еа]\\s*(\\d+)");
        Matcher linkMatcher = linkPattern.matcher(text);
        int previousRef = 0;
        boolean areConsistent = true;
        while (linkMatcher.find()) {
            int ref = 0;
            areConsistent = previousRef < ref;
            if (linkMatcher.group(2) == null) {
                ref = Integer.parseInt(linkMatcher.group(1));
            } else if (linkMatcher.group(1) == null) {
                ref = Integer.parseInt(linkMatcher.group(2));
            }
            previousRef = ref;
        }
        return areConsistent;
    }

    static List<String> getReferenceSentences(String text) {
        List<String> referenceSentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile("([А-Я]([^?!.(]|\\([^)]+\\))*[.?!])");
        Matcher sentenceMatcher = sentencePattern.matcher(text);
        Pattern linkPattern = Pattern.compile("(\\([Рр]ис.\\s*\\d+)|(рисунк[еа]\\s*\\d+)");
        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            if (linkPattern.matcher(sentence).find()) {
                referenceSentences.add(sentence);
            }
        }
        return referenceSentences;
    }
}
