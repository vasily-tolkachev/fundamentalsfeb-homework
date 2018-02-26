package subtask.four;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        double[] array = {2.0, 4.0, 0.0, 1.0, 12.3, 0.5, 1.0, 12.3, 7.0, 8.0, 9.0, 5.0, 6.0};
        double currentMax = array[0] + array[array.length - 1];
        for (int i = 1; i <= array.length / 2; i++) {
            double currentSum = array[i] + array[array.length - 1 - i];
            if (currentSum > currentMax) {
                currentMax = currentSum;
            }
        }
        log.info("The maximum is {}", currentMax);
    }
}
