package utility;

import entity.Building;
import entity.DBMethods;

import java.util.List;

/**
 * This is a class with a single functionality used for calculations.
 *
 */
public class BuildingsCountCalculator {

    /**
     * Method that calculates how many buildings are registered.
     *
     * @return Integer which represents the desired value.
     */
    public static Integer calculateBuildingsCount() {
        List<Building> buildings = DBMethods.getBuildings();

        return buildings.size();
    }

    /**
     * Method that calculates how many buildings have service.
     * If a building has an employee that maintains it, that means
     * it is serviced. Otherwise, the building won't be counted.
     *
     * @return Integer which represents the desired value.
     */
    public static Integer calculateServicedBuildingsCount() {
        List<Building> buildings = DBMethods.getBuildings();

        Integer servicedBuildingsCount = 0;

        // Get employees for building..
        for (Building building : buildings) {
            if (building.getHasService()) {
                servicedBuildingsCount += 1;
            }
        }

        return servicedBuildingsCount;
    }

}