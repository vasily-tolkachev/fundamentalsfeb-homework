package subtasks.three;

class Ruler extends Stationery {
    private final String rulerType;

    Ruler(int cost, String type) {
        super(cost, "Ruler");
        this.rulerType = type;
    }

    public String getRulerType() {
        return rulerType;
    }
}
