package utility;

import entity.Building;
import entity.DBMethods;

import java.util.List;

public class BuildingsCountCalculator {

    public static Integer calculateBuildingsCount() {
        List<Building> buildings = DBMethods.getBuildings();

        return buildings.size();
    }

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