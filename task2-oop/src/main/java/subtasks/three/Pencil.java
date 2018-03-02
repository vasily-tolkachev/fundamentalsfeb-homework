package subtasks.three;

class Pencil extends Stationery {
    private final String pencilType;

    Pencil(int cost, String pencilType) {
        super(cost, "Pencil");
        this.pencilType = pencilType;
    }

    public String getPencilType() {
        return pencilType;
    }
}
