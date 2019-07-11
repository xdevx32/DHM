package controller;

import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.AlertErrorUtility;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 *  This is a class that represents the controller logic for Companies and employees.
 *
 * @author Angel Kukushev
 *
 */
public class CompaniesAndEmployeesTabController implements Initializable {

    private Model model = Model.getInstance();

    public TextField employeeNameTextField;

    public ListView<Building> buildingsForAnEmployeeListView;

    public TextField employeeEgnTextField;

    public TableView<Employee> employeeTableView;

    public TableColumn<Object, Object> employeeNameColumn;

    public TableColumn<Object, Object> employeeEgnColumn;

    public TableColumn<Object, Object> employeeCompanyColumn;

    public ComboBox<Company> selectCompanyComboBox;

    public TableColumn<Object, Object> companyIdColumn;

    public TableColumn<Object, Object> companyNameColumn;

    public TableView<Company> companyTableView;

    public TextField companyNameTextField;

    public ComboBox<Building> selectBuildingComboBox;

    public Button addBuildingToAnEmployeeButton;

    /**
     * Initialize method for the controller.
     *
     * Loads the data from the model object and sets it to the UI elements.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Добавя данни в таблицата за компании
        companyIdColumn.setCellValueFactory(new PropertyValueFactory<>("idCompany"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        companyTableView.setItems(model.getCompaniesObservableList());

        // Добавя данни в таблицата за работници
        final ObservableList<Employee> employeeData = FXCollections.observableArrayList(DBMethods.getEmployees());

        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeEgnColumn.setCellValueFactory(new PropertyValueFactory<>("egn"));
        employeeCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));

        employeeTableView.setItems(employeeData);

        // Добавя данни в падащото меню за избиране на компания в която работи служител

        selectCompanyComboBox.setItems(model.getCompaniesObservableList());

        selectBuildingComboBox.setItems(model.getBuildingsObservableList());

        // Event Listener

        ObservableList<Building> buildingsForEmployeeData = model.getBuildingsForEmployeeOL();
        buildingsForAnEmployeeListView.setItems(buildingsForEmployeeData);

        employeeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                employeeTableView.getSelectionModel();
                List<Building> buildings = DBMethods.getBuildingsForEmployee(newSelection);
                model.setBuildingsForEmployeeOL(buildings);
            }
        });
    }

    /**
     * Method for saving all employee data from the input fields on button click.
     */
    public void saveEmployeeData(ActionEvent actionEvent) {
        if ((employeeNameTextField.getText() != null && !employeeNameTextField.getText().isEmpty())
                && (employeeEgnTextField.getText() != null && !employeeEgnTextField.getText().isEmpty())) {

            String employeeName = employeeNameTextField.getText();
            String employeeEgn = employeeEgnTextField.getText();
            Company employeeCompany = selectCompanyComboBox.getValue();
            Building employeeBuilding = selectBuildingComboBox.getValue();

            Integer employeeId = DBMethods.addEmployee(employeeName, employeeEgn, employeeCompany, employeeBuilding);
            Employee employeeObject = DBMethods.getEmployee(employeeId);

            employeeTableView.getItems().add(employeeObject);
            employeeNameTextField.clear();
            employeeEgnTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    /**
     * Method for deleting a selected employee.
     */
    public void deleteEmployeeData(ActionEvent actionEvent) {
        Employee selectedObject = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            employeeTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteEmployee(selectedObject.getIdEmployee());
        }
    }

    /**
     * Method for saving all company data from the input fields on button click.
     */
    public void saveCompanyData(ActionEvent actionEvent) {
        if ((companyNameTextField.getText() != null && !companyNameTextField.getText().isEmpty())) {

            String companyName = companyNameTextField.getText();

            Integer companyId = DBMethods.addCompany(companyName);
            Company companyObject = DBMethods.getCompany(companyId);

            model.addCompanyToArrayList(companyObject);
            companyTableView.getItems().add(companyObject);
            companyNameTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    /**
     * Method for deleting a selected company.
     */
    public void deleteCompanyData(ActionEvent actionEvent) {
        Company selectedObject = companyTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            companyTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteCompany(selectedObject.getIdCompany());
            model.removeCompanyFromArrayList(selectedObject);
        }
    }

    /**
     * Method that assigns a building to an employee.
     */
    public void addBuildingToAnEmployeeAction(ActionEvent actionEvent) {
        Building selectedBuilding = selectBuildingComboBox.getValue();

        Employee employee = employeeTableView.getSelectionModel().getSelectedItem();

        DBMethods.addBuildingToAnEmployee(selectedBuilding, employee);
    }
}
