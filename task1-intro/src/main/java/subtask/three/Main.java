package subtask.three;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        final double leftBorder = 2;
        final double rightBorder = 3;
        final double step = 0.05;
        double x = leftBorder;

        StringBuilder builder = new StringBuilder();
        while (x <= rightBorder){
            builder.append('\n').append("Argument is: ").append(x).append("   ");
            builder.append("Function value is: ").append(Math.tan(2 * x) - 3);
            x += step;
        }
        log.info(builder.toString());
    }
}


