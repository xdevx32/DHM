package controller;

import entity.ApartmentOwner;
import entity.Building;
import entity.DBMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.AlertErrorUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class BuildingsTabController implements Initializable {

    public TableView<ApartmentOwner> apartmentOwnerTableView;

    public TableColumn<Object, Object> apartmentOwnerNameColumn;

    public TableColumn<Object, Object> apartmentOwnerEgnColumn;

    public TextField apartmentOwnerNameTextField;

    public TextField apartmentOwnerEgnTextField;

    public TableView<Building> buildingTableView;

    public TableColumn<Object, Object> buildingIdColumn;

    public TableColumn<Object, Object> buildingFloorsColumn;

    public TableColumn<Object, Object> buildingAddressColumn;

    public TableColumn<Object, Object> buildingApartmentsCountColumn;

    public TableColumn<Object, Object> buildingAreaColumn;

    public TableColumn<Object, Object> buildingSharedPartsColumn;

    public TextField buildingAddressTextField;

    public TextField buildingFloorsTextField;

    public TextField buildingApartmentsTextField;

    public TextField buildingAreaTextField;

    public TextField buildingSharedPartsTextField;

    public TableColumn<Object, Object> buildingNameColumn;

    public TextField buildingNameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<ApartmentOwner> apartmentOwnerData = FXCollections.observableArrayList(DBMethods.getApartmentOwners());

        apartmentOwnerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        apartmentOwnerEgnColumn.setCellValueFactory(new PropertyValueFactory<>("egn"));

        apartmentOwnerTableView.setItems(apartmentOwnerData);


        final ObservableList<Building> buildingData = FXCollections.observableArrayList(DBMethods.getBuildings());

        buildingIdColumn.setCellValueFactory(new PropertyValueFactory<>("idBuilding"));
        buildingNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        buildingAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        buildingFloorsColumn.setCellValueFactory(new PropertyValueFactory<>("floors"));
        buildingApartmentsCountColumn.setCellValueFactory(new PropertyValueFactory<>("apartmentsCount"));
        buildingAreaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        buildingSharedPartsColumn.setCellValueFactory(new PropertyValueFactory<>("sharedParts"));

        buildingTableView.setItems(buildingData);
    }

    public void saveBuildingData(ActionEvent actionEvent) {
        if ((buildingNameTextField.getText() != null && !buildingNameTextField.getText().isEmpty())
                && (buildingAddressTextField.getText() != null && !buildingAddressTextField.getText().isEmpty())
                && (buildingFloorsTextField.getText() != null && !buildingFloorsTextField.getText().isEmpty())
                && (buildingApartmentsTextField.getText() != null && !buildingApartmentsTextField.getText().isEmpty())
                && (buildingAreaTextField.getText() != null && !buildingAreaTextField.getText().isEmpty())
                && (buildingSharedPartsTextField.getText() != null && !buildingSharedPartsTextField.getText().isEmpty())) {

            String buildingName = buildingNameTextField.getText();
            String buildingAddress = buildingAddressTextField.getText();
            Integer buildingFloors = Integer.parseInt(buildingFloorsTextField.getText());
            Integer buildingApartments = Integer.parseInt(buildingApartmentsTextField.getText());
            Double buildingArea = Double.parseDouble(buildingAreaTextField.getText());
            Integer buildingSharedParts = Integer.parseInt(buildingSharedPartsTextField.getText());

            Integer buildingId = DBMethods.addBuilding(buildingName, buildingAddress, buildingFloors,
                    buildingApartments, buildingArea, buildingSharedParts);
            Building buildingObject = DBMethods.getBuilding(buildingId);

            buildingTableView.getItems().add(buildingObject);
            buildingNameTextField.clear();
            buildingNameTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    public void deleteBuildingData(ActionEvent actionEvent) {
        Building selectedObject = buildingTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            buildingTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteBuilding(selectedObject.getIdBuilding());
        }
    }

    public void saveApartmentOwnerData(ActionEvent actionEvent) {
        if ((apartmentOwnerNameTextField.getText() != null && !apartmentOwnerNameTextField.getText().isEmpty())
                && (apartmentOwnerEgnTextField.getText() != null && !apartmentOwnerEgnTextField.getText().isEmpty())) {

            String apartmentOwnerName = apartmentOwnerNameTextField.getText();
            String apartmentOwnerEgn = apartmentOwnerEgnTextField.getText();

            Integer apartmentOwnerId = DBMethods.addApartmentOwner(apartmentOwnerName, apartmentOwnerEgn);
            ApartmentOwner apartmentOwnerObject = DBMethods.getApartmentOwner(apartmentOwnerId);

            apartmentOwnerTableView.getItems().add(apartmentOwnerObject);
            apartmentOwnerNameTextField.clear();
            apartmentOwnerEgnTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    public void deleteApartmentOwnerData(ActionEvent actionEvent) {
        ApartmentOwner selectedObject = apartmentOwnerTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            apartmentOwnerTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteApartmentOwner(selectedObject.getIdApartmentOwner());
        }
    }
}
