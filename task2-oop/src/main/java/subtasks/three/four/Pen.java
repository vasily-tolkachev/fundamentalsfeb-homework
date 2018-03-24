package subtasks.three.four;

import java.util.Objects;

public class Pen extends Stationery {
    private final String inkColor;

    public Pen(int cost, String inkColor) {
        super(cost, "Pen");
        this.inkColor = inkColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pen pen = (Pen) o;
        return Objects.equals(inkColor, pen.inkColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inkColor);
    }
}
