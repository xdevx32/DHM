package utility;

import entity.Building;
import entity.DBMethods;

import java.util.List;

public class ApartmentsCountCalculator {

    public static Integer calculateApartmentsCount() {
        List<Building> allBuildings = DBMethods.getBuildings();
        Integer aptCount = 0;

        for (Building building : allBuildings) {
            aptCount += building.getApartmentsCount();
        }

        return aptCount;
    }

}