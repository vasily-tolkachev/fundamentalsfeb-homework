package subtasks.three.four;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        List<Stationery> stationeryList = new ArrayList<>();

        stationeryList.add(new Pen(40, "Blue"));
        stationeryList.add(new Pencil(50, "Graphite sticks pencils"));
        stationeryList.add(new Ruler(20, "Desk ruler"));
        stationeryList.add(new Eraser(100, "Pencil eraser"));
        stationeryList.add(new Pen(10, "Blue"));
        stationeryList.add(new Pencil(150, "Graphite sticks pencils"));
        stationeryList.add(new Ruler(120, "Desk ruler"));
        stationeryList.add(new Eraser(90, "Pencil eraser"));

        log.info("\nWithout any sorting:\n{}", getColumnList(stationeryList));

        stationeryList.sort(new NameComparator());
        log.info("\nSorting by name:\n{}", getColumnList(stationeryList));

        stationeryList.sort(new CostComparator());
        log.info("\nSorting by cost:\n{}", getColumnList(stationeryList));

        stationeryList.sort(new NameCostComparator());
        log.info("\nSorting by name and cost:\n{}", getColumnList(stationeryList));
    }

    private static String getColumnList(List<Stationery> list) {
        StringBuilder sBuilder = new StringBuilder();
        for (Stationery element : list) {
            sBuilder.append(element).append('\n');
        }
        return sBuilder.toString();
    }
}


