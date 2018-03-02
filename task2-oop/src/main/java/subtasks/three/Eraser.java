package subtasks.three;

class Eraser extends Stationery {
    private final String eraserType;

    Eraser(int cost, String eraserType) {
        super(cost, "Eraser");
        this.eraserType = eraserType;
    }

    public String getEraserType() {
        return eraserType;
    }
}
