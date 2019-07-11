package utility;

import entity.Building;
import entity.DBMethods;

import java.util.List;

/**
 * This is a class with a single functionality used for calculations.
 *
 */
public class ApartmentsCountCalculator {

    /**
     * This is a method that returns the total number of apartments in all buildings.
     *  1. Gets a list of all buildings
     *  2. Adds the apartment count for each building to aptCount to get the total.
     *
     * @return aptCount This is the integer value that represents the desired data.
     */
    public static Integer calculateApartmentsCount() {
        List<Building> allBuildings = DBMethods.getBuildings();
        Integer aptCount = 0;

        for (Building building : allBuildings) {
            aptCount += building.getApartmentsCount();
        }

        return aptCount;
    }

}