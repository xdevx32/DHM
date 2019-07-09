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

public class ReportsTabController implements Initializable {

    public Label buildingCountLabel;

    public DatePicker reportDatePicker;

    public Label apartmentCountLabel;

    public Label taxesToPayLabel;

    public Label apartmentOwnerCountLabel;

    public Label servicedBuildingCountLabel;

    public Label paidTaxesLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportDatePicker.setValue(LocalDate.now());
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());
        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
        apartmentOwnerCountLabel.setText(ApartmentOwnerCountCalculator.calculateApartmentOwnerCount().toString());
        paidTaxesLabel.setText(TaxesCalculator.calculatePaidTaxes(LocalDate.now()).toString());
    }

    @FXML
    void refreshData(ActionEvent event) {
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());
        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
        apartmentOwnerCountLabel.setText(ApartmentOwnerCountCalculator.calculateApartmentOwnerCount().toString());
        paidTaxesLabel.setText(TaxesCalculator.calculatePaidTaxes(reportDatePicker.getValue()).toString());
    }

    public void changeReportDatePicker(ActionEvent actionEvent) {

    }
}
