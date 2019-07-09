package utility;

import entity.ApartmentOwner;
import entity.Building;
import entity.DBMethods;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

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
                if ((sqlDate.getMonth() == checkDate.getMonth()) && (sqlDate.getYear() == checkDate.getYear())) {
                    totalTaxes += tax;
                }
            }
        }

        return totalTaxes;
    }

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
