package subtasks.three;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final String SOURCE_FILE = "task4-IO/src/main/java/subtasks/three/textUTF-8.txt";
    private static final String RESULT_FILE = "task4-IO/src/main/java/subtasks/three/textUTF-16.txt";

    public static void main(String... args) {
        File srcFile = new File(SOURCE_FILE);
        File destFile = new File(RESULT_FILE);
        copyWithRecoding(srcFile, destFile);
    }

    static void copyWithRecoding(File source, File destination) {
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(source), Charset.forName("UTF-8")));
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(destination), Charset.forName("UTF-16")
                        )
                )
        ) {
            destination.createNewFile();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            log.info("File not found");
        } catch (IOException e) {
            log.info("IOException");
        }
    }
}
