package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utility.ApartmentsCountCalculator;
import utility.BuildingsCountCalculator;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportsTabController implements Initializable {

    public Label buildingCountLabel;

    public Label apartmentCountLabel;

    public Label taxesToPayLabel;

    public Label apartmentOwnerCountLabel;

    public Label servicedBuildingCountLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());

        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
    }

    @FXML
    void refreshData(ActionEvent event) {
        apartmentCountLabel.setText(ApartmentsCountCalculator.calculateApartmentsCount().toString());

        buildingCountLabel.setText(BuildingsCountCalculator.calculateBuildingsCount().toString());
        servicedBuildingCountLabel.setText(BuildingsCountCalculator.calculateServicedBuildingsCount().toString());
    }

}
