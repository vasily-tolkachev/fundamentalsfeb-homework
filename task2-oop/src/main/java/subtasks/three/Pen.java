package subtasks.three;

class Pen extends Stationery {
    private String inkColor = "black";

    Pen(int cost) {
        super(cost, "Pen");
    }

    Pen(int cost, String inkColor) {
        super(cost, "Pen");
        this.inkColor = inkColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }
}
