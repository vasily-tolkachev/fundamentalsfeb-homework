package subtasks.three;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private static final Logger log = LogManager.getLogger(IntegerSetterGetter.class);
    private final SharedResource resource;
    private boolean reader;
    private boolean running;

    private Random rand = new Random();

    public IntegerSetterGetter(ThreadGroup group, String name, SharedResource resource) {
        super(group, name);
        this.resource = resource;
        reader = false;
    }

    public void stopThread() {
        running = false;
    }

    public boolean isReader() {
        return reader;
    }

    public void run() {
        running = true;
        try {
            while (running) {
                synchronized (resource) {
                    int action = rand.nextInt(1000);
                    if (lastWriter() || action % 2 == 0) {
                        reader = false;
                        setIntegersIntoResource();
                    } else {
                        reader = true;
                        getIntegersFromResource();
                    }
                }
            }
            log.info("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean lastWriter() {
        ThreadGroup group = currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount() + 10];
        group.enumerate(threads);
        int nonReadersCount = 0;
        for (Thread thread : threads) {
            if (thread != null && !((IntegerSetterGetter) thread).isReader()) {
                nonReadersCount++;
            }
        }
        return nonReadersCount == 1;
    }

    private void getIntegersFromResource() throws InterruptedException {
        log.info("Поток " + getName() + " хочет извлечь число.");
        Integer number = resource.getElement();
        while (number == null) {
            log.info("Поток " + getName() + " ждет пока очередь заполнится.");
            resource.wait();
            log.info("Поток " + getName() + " возобновил работу.");
            number = resource.getElement();
        }
        log.info("Поток " + getName() + " извлек число " + number);
    }

    private void setIntegersIntoResource() {
        Integer number = rand.nextInt(500);
        resource.setElement(number);
        log.info("Поток " + getName() + " записал число " + number);
        resource.notify();
    }
}

