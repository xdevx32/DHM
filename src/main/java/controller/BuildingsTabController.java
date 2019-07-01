package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BuildingsTabController implements Initializable {

    public TableView apartmentOwnerTableView;

    public TableColumn apartmentOwnerNameColumn;

    public TableColumn apartmentOwnerEgnColumn;

    public TextField apartmentOwnerNameTextField;

    public TextField apartmentOwnerEgnTextField;

    public TableView buildingTableView;

    public TableColumn buildingIdColumn;

    public TableColumn buildingFloorsColumn;

    public TableColumn buildingAddressColumn;

    public TableColumn buildingApartmentsCountColumn;

    public TableColumn buildingsAreaColumn;

    public TableColumn buildingSharedPartsColumn;

    public TextField buildingAddressTextField;

    public TextField buildingFloorsTextField;

    public TextField buildingApartmentsTextField;

    public TextField buildingAreaTextField;

    public TextField buildingSharedPartsTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void saveBuildingData(ActionEvent actionEvent) {
    }

    public void deleteBuildingData(ActionEvent actionEvent) {
    }

    public void saveApartmentOwnerData(ActionEvent actionEvent) {
    }

    public void deleteApartmentOwnerData(ActionEvent actionEvent) {
    }
}
