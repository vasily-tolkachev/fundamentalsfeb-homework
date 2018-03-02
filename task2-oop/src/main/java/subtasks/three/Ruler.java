package subtasks.three;

import java.util.Objects;

class Ruler extends Stationery {
    private final String rulerType;

    Ruler(int cost, String type) {
        super(cost, "Ruler");
        this.rulerType = type;
    }

    public String getRulerType() {
        return rulerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ruler ruler = (Ruler) o;
        return Objects.equals(rulerType, ruler.rulerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rulerType);
    }
}
