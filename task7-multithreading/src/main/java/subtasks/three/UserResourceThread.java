package subtasks.three;

import java.util.ArrayList;
import java.util.List;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        ThreadGroup group = new ThreadGroup("IntSettersGetters");

        List<IntegerSetterGetter> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new IntegerSetterGetter(group, "" + i, res));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(3000);

        for (IntegerSetterGetter integerSetterGetter : threads) {
            integerSetterGetter.stopThread();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
