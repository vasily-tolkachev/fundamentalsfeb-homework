package subtasks.three.four;

import java.util.Comparator;

public class CostComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getCost() - o2.getCost();
    }
}