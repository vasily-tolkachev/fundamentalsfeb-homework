package subtasks.three;

import java.util.Objects;

class Eraser extends Stationery {
    private final String eraserType;

    Eraser(int cost, String eraserType) {
        super(cost, "Eraser");
        this.eraserType = eraserType;
    }

    public String getEraserType() {
        return eraserType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eraser eraser = (Eraser) o;
        return Objects.equals(eraserType, eraser.eraserType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eraserType);
    }
}
