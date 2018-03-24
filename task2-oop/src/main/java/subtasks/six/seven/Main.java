package subtasks.six.seven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(subtasks.one.Main.class);

    public static void main(String... args) {
        Submarine submarine = new Submarine();
        submarine.startMoving();
        log.info("Submarine is moving somewhere");
        submarine.stopMoving();
    }
}
