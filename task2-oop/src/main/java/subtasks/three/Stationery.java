package subtasks.three;

abstract class Stationery {
    private final int cost;
    private final String name;

    Stationery(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    int getCost() {
        return cost;
    }

    String getName() {
        return name;
    }
}
