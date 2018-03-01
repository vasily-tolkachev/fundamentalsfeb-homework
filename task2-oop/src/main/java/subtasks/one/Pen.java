package subtasks.one;

import java.util.Objects;

class Pen {
    private String inkColor;
    private String material;
    private int price;

    Pen(String inkColor, String material, int price) {
        this.inkColor = inkColor;
        this.material = material;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price &&
                Objects.equals(inkColor, pen.inkColor) &&
                Objects.equals(material, pen.material);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + price;
        result = 31 * result + (inkColor == null ? 0 : inkColor.hashCode());
        result = 31 * result + (material == null ? 0 : material.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Pen{inkColor='%s', material='%s', price=%d}", inkColor, material, price);
    }
}
