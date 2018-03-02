package subtasks.three;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        ArrayList<Stationery> stationeryList = new ArrayList<>();

        stationeryList.add(new Pen(40));
        stationeryList.add(new Pencil(50));
        stationeryList.add(new Ruler(20));
        stationeryList.add(new Eraser(100));

        for (Stationery element: stationeryList) {
            log.info("{} that costs {}",element.getName(), element.getCost());
        }
    }
}


