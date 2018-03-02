package subtasks.three;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationery that = (Stationery) o;
        return cost == that.cost &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, name);
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
