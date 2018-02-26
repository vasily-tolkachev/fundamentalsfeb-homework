package subtask.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        double eps = 0.001;
        int index = 1;
        double a = (double) 1 / (int) Math.pow(index, 2);

        StringBuilder builder = new StringBuilder();
        while (a > eps) {
            a = (double) 1 / (int) Math.pow((index + 1), 2);
            index++;
            builder.append('\n').append(a);
        }
        builder.append("\nThe smallest element is ").append(a);
        builder.append("\nAn index of the smallest element of the sequence is ").append(index);
        log.info(builder.toString());

    }
}



