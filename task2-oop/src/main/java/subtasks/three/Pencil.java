package subtasks.three;

import java.util.Objects;

class Pencil extends Stationery {
    private final String pencilType;

    Pencil(int cost, String pencilType) {
        super(cost, "Pencil");
        this.pencilType = pencilType;
    }

    public String getPencilType() {
        return pencilType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pencil pencil = (Pencil) o;
        return Objects.equals(pencilType, pencil.pencilType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pencilType);
    }
}
