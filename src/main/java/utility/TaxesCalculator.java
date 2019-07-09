package utility;

import entity.ApartmentOwner;
import entity.Building;
import entity.DBMethods;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaxesCalculator {

    public static Double calculatePaidTaxes(LocalDate dateToCheck) {
        Double totalTaxes = 0.0;
        List<ApartmentOwner> apartmentOwners = DBMethods.getApartmentOwners();

        for (ApartmentOwner aptOwner : apartmentOwners) {
            Building building = DBMethods.getBuildingForApartmentOwner(aptOwner);

            Double tax = building.getTax();


            List<Date> sqlDates = DBMethods.getPaymentDatesForApartmentOwnerSQL(aptOwner);
            Date checkDate = Date.valueOf(dateToCheck);

            for (Date sqlDate : sqlDates) {
                if (sqlDate.getMonth() == checkDate.getMonth()) {
                    totalTaxes += tax;
                }
            }
        }

        return totalTaxes;
    }

    public static Double caclulateUnpaidTaxes(LocalDate startPeriod, LocalDate endPeriod) {
        Double totalUnpaidTaxes = 0.0;

        List<ApartmentOwner> apartmentOwners = DBMethods.getApartmentOwners();
        //startPeriod.getMo

        return totalUnpaidTaxes;
    }
}
