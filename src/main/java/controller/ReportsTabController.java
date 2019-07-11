package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import utility.ApartmentOwnerCountCalculator;
import utility.ApartmentsCountCalculator;
import utility.BuildingsCountCalculator;
import utility.TaxesCalculator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 *
 *  This is a class that represents the controller logic for Reports tab.
 *
 * @author Angel Kukushev
 *
 */
public class ReportsTabController implements Initializable {

    public Label buildingCountLabel;

    public DatePicker reportDatePicker;

    public Label apartmentCountLabel;

    public Label taxesToPayLabel;

    public Label apartmentOwnerCountLabel;

    public Label servicedBuildingCountLabel;

    public Label paidTaxesLabel;

    /**
     * Initialize method for the controller.
     *
     * Sets initial data from calling the utility classes for calculation.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportDatePicker.setValue(LocalDate.now());
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());
        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
        apartmentOwnerCountLabel.setText(ApartmentOwnerCountCalculator.calculateApartmentOwnerCount().toString());
        paidTaxesLabel.setText(TaxesCalculator.calculatePaidTaxes(LocalDate.now()).toString());
        taxesToPayLabel.setText(TaxesCalculator.calculateUnpaidTaxes(LocalDate.now()).toString());
    }

    /**
     * Method that get called when date picker value changes.
     * Used to update all fields on the report page with newly calculated values
     * for the selected date.
     */
    @FXML
    public void changeReportDatePicker(ActionEvent actionEvent) {
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());
        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
        apartmentOwnerCountLabel.setText(ApartmentOwnerCountCalculator.calculateApartmentOwnerCount().toString());
        paidTaxesLabel.setText(TaxesCalculator.calculatePaidTaxes(reportDatePicker.getValue()).toString());
        taxesToPayLabel.setText(TaxesCalculator.calculateUnpaidTaxes(reportDatePicker.getValue()).toString());
    }
}
