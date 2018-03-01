package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        final String blackStr = "black";
        final String wooden = "wooden";
        Pen firstPen =  new Pen(blackStr, wooden, 1200);
        Pen secondPen =  new Pen(blackStr, wooden, 1200);
        Pen thirdPen =  new Pen(blackStr, wooden, 1200);
        Pen fourthPen =  new Pen("orange", "plastic", 50);

        log.info("firstPen.equals(firstPen) {}", firstPen.equals(firstPen));

        log.info("firstPen.equals(secondPen) {}", firstPen.equals(secondPen));
        log.info("secondPen.equals(firstPen) {}", secondPen.equals(firstPen));

        log.info("firstPen.equals(fourthPen) {}", firstPen.equals(thirdPen));
        log.info("secondPen.equals(fourthPen) {}", secondPen.equals(thirdPen));

        log.info("firstPen.equals(fourthPen): {}", firstPen.equals(fourthPen));
        log.info("secondPen.equals(fourthPen): {}", secondPen.equals(fourthPen));
        log.info("thirdPen.equals(fourthPen): {}", thirdPen.equals(fourthPen));

        log.info("firstPen.hashCode(): {}", firstPen.hashCode());
        log.info("secondPen.hashCode(): {}", secondPen.hashCode());
        log.info("thirdPen.hashCode(): {}", thirdPen.hashCode());
        log.info("fourthPen.hashCode(): {}", fourthPen.hashCode());

        log.info("firstPen to string: {}", firstPen);
    }
}


