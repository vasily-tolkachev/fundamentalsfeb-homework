package subtasks.two;

import subtasks.three.four.Stationery;

import java.util.ArrayList;
import java.util.List;

class EmployeeStationery {
    private List<Stationery> stationeryList;

    EmployeeStationery() {
        this.stationeryList = new ArrayList<>();
    }

    EmployeeStationery addStationeryItem(Stationery stationeryItem) {
        stationeryList.add(stationeryItem);
        return this;
    }

    int getCostEmployeeStationery() {
        int fullCost = 0;
        for (Stationery stationery : stationeryList) {
            fullCost += stationery.getCost();
        }
        return fullCost;
    }
}
