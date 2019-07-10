package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *  Singleton class for keeping and acessing observable lists and lists holding.
 *
 *
 * @author Angel Kukushev
 */
public class Model {

    // Lists and ObservableLists

    /*
    *
    * Buildings
    *
    */
    ObservableList<Building> buildingsObservableList = FXCollections.observableArrayList();

    List<Building> buildingsList = DBMethods.getBuildings();


    /*
    *
    * Buildings for an employee
    *
    */
    ObservableList<Building> buildingsForEmployeeOL = FXCollections.observableArrayList();

    List<Building> buildingsForEmployeeList = new ArrayList<Building>(0);

    /*
    *
    * Companies
    *
    */

    ObservableList<Company> companiesObservableList = FXCollections.observableArrayList();

    List<Company> companiesList = DBMethods.getCompanies();

    /*
    *
    *  Payment dates for selected apartment owner
    *
    */

    ObservableList<LocalDate> paymentDatesForApartmentOwnerOL = FXCollections.observableArrayList();

    List<LocalDate> paymentDatesForApartmentOwnerList = new ArrayList<LocalDate>(0);

    /*
    *
    *  Apartment owners for selected building
    *
    */

    ObservableList<ApartmentOwner> apartmentOwnersForBuildingOL = FXCollections.observableArrayList();

    List<ApartmentOwner> apartmentOwnersForBuildingList = new ArrayList<ApartmentOwner>(0);

    /*
    *
    *  End
    *
    */
    // static variable single_instance of type Model
    private static Model single_instance = null;

    // static method to create instance of Singleton class
    public static Model getInstance()
    {
        if (single_instance == null)
            single_instance = new Model();

        return single_instance;
    }

    public Model() {
        buildingsObservableList.setAll(DBMethods.getBuildings());
        companiesObservableList.setAll(DBMethods.getCompanies());
    }

    public ObservableList<Building> getBuildingsObservableList() {
        return buildingsObservableList;
    }

    public ObservableList<Company> getCompaniesObservableList() {
        return companiesObservableList;
    }

    public void setBuildingsObservableList(ArrayList<Building> buildingsList) {
        buildingsObservableList.setAll(buildingsList);
    }

    public void setCompaniesObservableList(ArrayList<Company> companiesArrayList) {
        companiesObservableList.setAll(companiesArrayList);
    }

    public ObservableList<Building> getBuildingsForEmployeeOL() {
        return buildingsForEmployeeOL;
    }

    public ObservableList<LocalDate> getPaymentDatesForApartmentOwnerOL() {
        return paymentDatesForApartmentOwnerOL;
    }

    public ObservableList<ApartmentOwner> getApartmentOwnersForBuildingOL() {
        return apartmentOwnersForBuildingOL;
    }

    public List<Building> getBuildingsList() {
        return buildingsList;
    }

    public List<Company> getCompaniesList() {
        return companiesList;
    }

    public void setBuildingsForEmployeeOL(List<Building> buildingsArrayList) {
        buildingsForEmployeeOL.setAll(buildingsArrayList);
    }

    public void setPaymentDatesForApartmentOwnerOL(List<LocalDate> paymentDatesForApartmentOwnerList) {
        this.paymentDatesForApartmentOwnerOL.setAll(paymentDatesForApartmentOwnerList);
    }

    public void setApartmentOwnersForBuildingOL(List<ApartmentOwner> apartmentOwnersForBuilding) {
        this.apartmentOwnersForBuildingOL.setAll(apartmentOwnersForBuilding);
    }

    public void setBuildingsList(List<Building> buildingsList) {
        this.buildingsList = buildingsList;
    }

    public void setCompaniesList(List<Company> companiesList) {
        this.companiesList = companiesList;
    }

    public void addBuildingToArrayList(Building building) {
        this.buildingsList.add(building);
    }

    public void removeBuildingFromArrayList(Building building) {
        this.buildingsList.remove(building);
    }

    public void addCompanyToArrayList(Company company) {
        this.companiesList.add(company);
    }

    public void removeCompanyFromArrayList(Company company) {
        this.companiesList.remove(company);
    }

}
