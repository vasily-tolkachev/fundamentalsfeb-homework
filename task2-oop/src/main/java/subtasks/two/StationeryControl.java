package subtasks.two;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import subtasks.three.four.*;

class StationeryControl {
    private static final Logger log = LogManager.getLogger(subtasks.three.four.Main.class);
    private static Map<Integer, EmployeeStationery> employeeStationeryMap = new HashMap<>();

    void addStationeryItemToEmployee(Integer employeeId, Stationery stationeryItem) {
        if (!employeeStationeryMap.containsKey(employeeId)) {
            employeeStationeryMap.put(employeeId, new EmployeeStationery().addStationeryItem(stationeryItem));
        } else {
            employeeStationeryMap.get(employeeId).addStationeryItem(stationeryItem);
        }
    }

    Integer getCostOfEmployeesStationery(Integer employeeID) {
        return employeeStationeryMap.get(employeeID).getCostEmployeeStationery();
    }

    void printStationeryReport() {
        int costOfAllStationary = 0;
        StringBuilder builder = new StringBuilder();
        if (!employeeStationeryMap.isEmpty()) {
            for (Map.Entry<Integer, EmployeeStationery> entry :
                    employeeStationeryMap.entrySet()) {
                builder.append("\nEmployee ID ").append(entry.getKey());
                Integer fullCostForOne = entry.getValue().getCostEmployeeStationery();
                builder.append("\nAll his stationary cost is ")
                        .append(fullCostForOne);
                costOfAllStationary += fullCostForOne;
            }
        }
        builder.append("\nCost of all stationary is ")
                .append(costOfAllStationary)
                .append('\n');
        log.info("\nStationery report:{}\n", builder.toString());
    }


}


