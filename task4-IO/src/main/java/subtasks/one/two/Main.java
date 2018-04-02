package subtasks.one.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String SOURCE_FILE = "task4-IO/src/main/java/subtasks/one/two/Main.java";
    private static final String CHAR_STREAM_RESULT = "task4-IO/src/main/java/subtasks/one/two/result_char.txt";
    private static final String BYTE_STREAM_RESULT = "task4-IO/src/main/java/subtasks/one/two/result_byte.txt";
    private static final Map<String, Integer> keywords = new HashMap<>();

    public static void main(String... args) {
        File file = new File(SOURCE_FILE);

        //Char stream case
        ReaderWriter readerWriter = new CharReaderWriter();

        List<String> words = getWords(readerWriter.readFile(file));

        for (String word : words) {
            if (keywords.containsKey(word)) {
                keywords.put(word, keywords.get(word) + 1);
            }
        }
        String result = getResultString();
        readerWriter.writeResult(result, new File(CHAR_STREAM_RESULT));

        //Byte stream case
        readerWriter = new ByteReaderWriter();

        words = getWords(readerWriter.readFile(file));

        for (Map.Entry<String, Integer> entry: keywords.entrySet()) {
            entry.setValue(0);
        }

        for (String word : words) {
            if (keywords.containsKey(word)) {
                keywords.put(word, keywords.get(word) + 1);
            }
        }
        result = getResultString();
        readerWriter.writeResult(result, new File(BYTE_STREAM_RESULT));
    }

    private static String getResultString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        int totalNumber = 0;
        for (Map.Entry<String, Integer> entry : keywords.entrySet()) {
            int numberOfKeyWords = entry.getValue();
            if (numberOfKeyWords != 0) totalNumber += numberOfKeyWords;
            stringBuilder.append(entry.getKey()).append(" ").append(numberOfKeyWords).append('\n');
        }
        stringBuilder.append("Total number of keywords is ").append(totalNumber);
        return stringBuilder.toString();
    }

    private static List<String> getWords(String text) {
        List<String> referenceSentences = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("[a-z\\\\\"]+");
        Matcher wordMatcher = wordPattern.matcher(text);
        while (wordMatcher.find()) {
            referenceSentences.add(wordMatcher.group());
        }
        return referenceSentences;
    }

    static {
        keywords.put("abstract", 0);
        keywords.put("continue", 0);
        keywords.put("for", 0);
        keywords.put("new", 0);
        keywords.put("switch", 0);
        keywords.put("default", 0);
        keywords.put("if", 0);
        keywords.put("do", 0);
        keywords.put("boolean", 0);
        keywords.put("synchronized", 0);
        keywords.put("package", 0);
        keywords.put("goto", 0);
        keywords.put("assert", 0);
        keywords.put("private", 0);
        keywords.put("this", 0);
        keywords.put("break", 0);
        keywords.put("double", 0);
        keywords.put("implements", 0);
        keywords.put("protected", 0);
        keywords.put("throw", 0);
        keywords.put("byte", 0);
        keywords.put("transient", 0);
        keywords.put("return", 0);
        keywords.put("instanceof", 0);
        keywords.put("enum", 0);
        keywords.put("case", 0);
        keywords.put("throws", 0);
        keywords.put("public", 0);
        keywords.put("import", 0);
        keywords.put("else", 0);
        keywords.put("catch", 0);
        keywords.put("class", 0);
        keywords.put("void", 0);
        keywords.put("static", 0);
        keywords.put("interface", 0);
        keywords.put("final", 0);
        keywords.put("char", 0);
        keywords.put("try", 0);
        keywords.put("short", 0);
        keywords.put("int", 0);
        keywords.put("extends", 0);
        keywords.put("finally", 0);
        keywords.put("long", 0);
        keywords.put("strictfp", 0);
        keywords.put("volatile", 0);
        keywords.put("const", 0);
        keywords.put("float", 0);
        keywords.put("native", 0);
        keywords.put("super", 0);
        keywords.put("while", 0);
    }
}
