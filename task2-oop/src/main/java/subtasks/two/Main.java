package subtasks.two;

import subtasks.three.four.*;

class Main {
    public static void main(String... args) {
        Stationery pencil1 = new Pencil(100, "pencilType1");
        Stationery pencil2 = new Pencil(200, "pencilType2");
        Stationery pencil3 = new Pencil(300, "pencilType3");
        Stationery pencil4 = new Pencil(400, "pencilType4");
        Stationery pen1 = new Pen(100, "color1");
        Stationery pen2 = new Pen(200, "color2");
        Stationery eraser1 = new Eraser(100, "type1");
        Stationery eraser2 = new Eraser(200, "type2");
        Stationery ruler1 = new Ruler(100, "type1");
        Stationery ruler2 = new Ruler(200, "type2");
        StationeryControl stationeryControl = new StationeryControl();
        stationeryControl.addStationeryItemToEmployee(1, pencil1);
        stationeryControl.addStationeryItemToEmployee(1, pencil2);
        stationeryControl.addStationeryItemToEmployee(2, pencil3);
        stationeryControl.addStationeryItemToEmployee(3, pencil4);

        stationeryControl.addStationeryItemToEmployee(3, pen1);
        stationeryControl.addStationeryItemToEmployee(2, pen2);

        stationeryControl.addStationeryItemToEmployee(2, eraser1);
        stationeryControl.addStationeryItemToEmployee(2, eraser2);

        stationeryControl.addStationeryItemToEmployee(3, ruler1);
        stationeryControl.addStationeryItemToEmployee(1, ruler2);

        stationeryControl.printStationeryReport();
    }
}