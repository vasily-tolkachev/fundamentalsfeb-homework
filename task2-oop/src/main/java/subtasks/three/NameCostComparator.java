package subtasks.three;

import java.util.Comparator;

public class NameCostComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        Comparator<Stationery> c = Comparator.comparing(Stationery::getName);
        c = c.thenComparingInt(Stationery::getCost);
        return c.compare(o1, o2);
    }
}
