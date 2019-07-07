package controller;

import entity.ApartmentOwner;
import entity.Building;
import entity.DBMethods;
import entity.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import utility.AlertErrorUtility;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BuildingsTabController implements Initializable {

    private Model model = Model.getInstance();

    public ListView<LocalDate> paymentsListView;

    public DatePicker paymentDate;

    public TextField taxTextField;

    public ImageView taxInfoImg;

    public ImageView paymentInfoImg;

    public Button saveOrChangeTaxButton;

    public TableColumn buildingTaxColumn;

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
        //TODO or Not TODO
        final ObservableList<ApartmentOwner> apartmentOwnerData = FXCollections.observableArrayList(DBMethods.getApartmentOwners());

        apartmentOwnerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        apartmentOwnerEgnColumn.setCellValueFactory(new PropertyValueFactory<>("egn"));

        apartmentOwnerTableView.setItems(apartmentOwnerData);

        ObservableList<Building> buildingData = model.getBuildingsObservableList();

        buildingIdColumn.setCellValueFactory(new PropertyValueFactory<>("idBuilding"));
        buildingNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        buildingAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        buildingFloorsColumn.setCellValueFactory(new PropertyValueFactory<>("floors"));
        buildingApartmentsCountColumn.setCellValueFactory(new PropertyValueFactory<>("apartmentsCount"));
        buildingAreaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        buildingSharedPartsColumn.setCellValueFactory(new PropertyValueFactory<>("sharedParts"));
        buildingTaxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));

        buildingTableView.setItems(buildingData);


        File file = new File("src/main/resources/info-black.png");
        Image image = new Image(file.toURI().toString());
        taxInfoImg.setImage(image);

        final Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "1. Изберете сграда от таблицата\n" +
                "2. Въведете сумата на такса\n" +
                "3. Използвайте бутона за да запазите или обновите данните."
        );
        tooltip.setFont(new Font(12));
        tooltip.setWidth(6);
        tooltip.setAutoHide(false);

        final Tooltip tooltip2 = new Tooltip();
        tooltip2.setText(
                "1. Изберете живущ от таблицата\n" +
                        "2. Изберете дата на плащане\n" +
                        "3. Използвайте бутона за да запазите плащането."
        );
        tooltip2.setFont(new Font(12));
        tooltip2.setWidth(6);
        tooltip2.setAutoHide(false);

        Tooltip.install(paymentInfoImg, tooltip2);

        // Event Listener

        ObservableList<LocalDate> paymentDatesForAptartmentOwnerOL = model.getPaymentDatesForApartmentOwnerOL();
        paymentsListView.setItems(paymentDatesForAptartmentOwnerOL);

        apartmentOwnerTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                apartmentOwnerTableView.getSelectionModel();
                List<LocalDate> dates = DBMethods.getPaymentDatesForApartmentOwner(newSelection);
                model.setPaymentDatesForApartmentOwnerOL(dates);
            }
        });
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

            model.addBuildingToArrayList(buildingObject);

            buildingTableView.getItems().add(buildingObject);
            buildingNameTextField.clear();
            buildingAddressTextField.clear();
            buildingFloorsTextField.clear();
            buildingApartmentsTextField.clear();
            buildingAreaTextField.clear();
            buildingSharedPartsTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    public void deleteBuildingData(ActionEvent actionEvent) {
        Building selectedObject = buildingTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            buildingTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteBuilding(selectedObject.getIdBuilding());
            model.removeBuildingFromArrayList(selectedObject);
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

    public void saveOrChangeTaxButton(ActionEvent actionEvent) {
        if ((taxTextField.getText() != null && !taxTextField.getText().isEmpty())) {

            Double tax = Double.parseDouble(taxTextField.getText());

            Building selectedBuilding = buildingTableView.getSelectionModel().getSelectedItem();

            selectedBuilding.setTax(tax);

            DBMethods.addTaxToBuilding(selectedBuilding, tax);

            model.setBuildingsObservableList(DBMethods.getBuildings());

        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }

    }

    public void savePaymentAction(ActionEvent actionEvent) {
        if ((paymentDate.getValue() != null)) {

            ApartmentOwner selectedApartmentOwner = apartmentOwnerTableView.getSelectionModel().getSelectedItem();

            DBMethods.addPaymentToApartmentOwner(selectedApartmentOwner, paymentDate.getValue());

            model.setPaymentDatesForApartmentOwnerOL(DBMethods.getPaymentDatesForApartmentOwner(selectedApartmentOwner));

        } else {
            AlertErrorUtility.showCustomAlert("Моля, изберете дата на плащане.");
        }
    }
}