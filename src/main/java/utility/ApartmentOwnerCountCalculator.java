package utility;

import entity.ApartmentOwner;
import entity.DBMethods;
import javafx.collections.ObservableList;

/**
 * This is a class with a single functionality used for calculations.
 *
 */
public class ApartmentOwnerCountCalculator {

    /**
     * Method that calculates how many apartment owners are registered.
     *
     * @return Integer which represents the desired value.
     */
    public static Integer calculateApartmentOwnerCount() {
        ObservableList<ApartmentOwner> allApartmentOwners = DBMethods.getApartmentOwners();

        return allApartmentOwners.size();
    }

}
