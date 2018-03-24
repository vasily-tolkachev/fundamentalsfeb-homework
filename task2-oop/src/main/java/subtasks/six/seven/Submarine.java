package subtasks.six.seven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import subtasks.one.Main;

class Submarine {
    private static final Logger log = LogManager.getLogger(Main.class);
    private Engine engine = new Engine();

    class Engine {
        boolean engineIsWorking = false;

        void turnOnEngine() {
            if (!engineIsWorking) {
                engineIsWorking = true;
                log.info("The engine's turned on");
            }
        }

        void turnOffEngine() {
            if (engineIsWorking) {
                engineIsWorking = false;
                log.info("The engine's turned off");
            }
        }
    }

    void startMoving() {
        engine.turnOnEngine();
    }

    void stopMoving() {
        engine.turnOffEngine();
    }
}
