package utility;

import entity.ApartmentOwner;
import entity.DBMethods;
import javafx.collections.ObservableList;

public class ApartmentOwnerCountCalculator {

    public static Integer calculateApartmentOwnerCount() {
        ObservableList<ApartmentOwner> allApartmentOwners = DBMethods.getApartmentOwners();

        return allApartmentOwners.size();
    }

}
