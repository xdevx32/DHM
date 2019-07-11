package utility;

import entity.ApartmentOwner;
import entity.Building;
import entity.DBMethods;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * This is a class that is used to hold methods for calculating taxes.
 *
 */
public class TaxesCalculator {

    /**
     * Calculates how many taxes are paid by a given date.
     *
     * @param dateToCheck This is the date given for checking.
     * @return totalTaxes Is the value of the taxes that are paid.
     */
    public static Double calculatePaidTaxes(LocalDate dateToCheck) {
        Double totalTaxes = 0.0;
        List<ApartmentOwner> apartmentOwners = DBMethods.getApartmentOwners();

        for (ApartmentOwner aptOwner : apartmentOwners) {
            Building building = DBMethods.getBuildingForApartmentOwner(aptOwner);

            Double tax = building.getTax();


            List<Date> sqlDates = DBMethods.getPaymentDatesForApartmentOwnerSQL(aptOwner);
            Date checkDate = Date.valueOf(dateToCheck);

            for (Date sqlDate : sqlDates) {
                if ((sqlDate.getMonth() == checkDate.getMonth()) && (sqlDate.getYear() == checkDate.getYear())) {
                    totalTaxes += tax;
                }
            }
        }

        return totalTaxes;
    }

    /**
     * Calculates how many taxes are NOT paid by a given date.
     *
     *
     * @param dateToCheck This is the date given for checking.
     * @return totalTaxes Is the value of the taxes that are NOT paid.
     */
    public static Double calculateUnpaidTaxes(LocalDate dateToCheck) {
        Double totalUnpaidTaxes = 0.0;

        List<ApartmentOwner> apartmentOwners = DBMethods.getApartmentOwners();

        for (ApartmentOwner aptOwner : apartmentOwners) {
            Building building = DBMethods.getBuildingForApartmentOwner(aptOwner);

            Double tax = building.getTax();
            Boolean payFlag = false;

            List<Date> sqlDates = DBMethods.getPaymentDatesForApartmentOwnerSQL(aptOwner);

            Date checkDate = Date.valueOf(dateToCheck);

            for (Date sqlDate : sqlDates) {
                if ((sqlDate.getMonth() == checkDate.getMonth()) && (sqlDate.getYear() == checkDate.getYear())) {
                    payFlag = true;
                }
            }

            if (!payFlag) {
                totalUnpaidTaxes += tax;
            }
        }


        return totalUnpaidTaxes;
    }
}
