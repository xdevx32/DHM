package controller;

import entity.Company;
import entity.DBMethods;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.AlertErrorUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class CompaniesAndEmployeesTabController implements Initializable {

    public TextField employeeNameTextField;

    public TextField employeeEgnTextField;

    public TableView<Employee> employeeTableView;

    public TableColumn<Object, Object> employeeNameColumn;

    public TableColumn<Object, Object> employeeEgnColumn;

    public TableColumn employeeCompanyColumn;

    public ComboBox<Company> selectCompanyComboBox;

    public TableColumn<Object, Object> companyIdColumn;

    public TableColumn<Object, Object> companyNameColumn;

    public TableView<Company> companyTableView;

    public TextField companyNameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Добавя данни в таблицата за компании
        final ObservableList<Company> companyData = FXCollections.observableArrayList(DBMethods.getCompanies());

        companyIdColumn.setCellValueFactory(new PropertyValueFactory<>("idCompany"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        companyTableView.setItems(companyData);

        // Добавя данни в таблицата за работници
        final ObservableList<Employee> employeeData = FXCollections.observableArrayList(DBMethods.getEmployees());

        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeEgnColumn.setCellValueFactory(new PropertyValueFactory<>("egn"));

        employeeTableView.setItems(employeeData);

        // Добавя данни в падащото меню за избиране на компания в която работи служител
        selectCompanyComboBox.getItems().clear();

        selectCompanyComboBox.getItems().addAll(companyData);
    }

    public void saveEmployeeData(ActionEvent actionEvent) {
        if ((employeeNameTextField.getText() != null && !employeeNameTextField.getText().isEmpty())
                && (employeeEgnTextField.getText() != null && !employeeEgnTextField.getText().isEmpty())) {

            String employeeName = employeeNameTextField.getText();
            String employeeEgn = employeeEgnTextField.getText();

            Integer employeeId = DBMethods.addEmployee(employeeName, employeeEgn);
            Employee employeeObject = DBMethods.getEmployee(employeeId);

            employeeTableView.getItems().add(employeeObject);
            employeeNameTextField.clear();
            employeeEgnTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    public void deleteEmployeeData(ActionEvent actionEvent) {
        Employee selectedObject = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            employeeTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteEmployee(selectedObject.getIdEmployee());
        }
    }

    public void saveCompanyData(ActionEvent actionEvent) {
        if ((companyNameTextField.getText() != null && !companyNameTextField.getText().isEmpty())) {

            String companyName = companyNameTextField.getText();

            Integer companyId = DBMethods.addCompany(companyName);
            Company companyObject = DBMethods.getCompany(companyId);

            companyTableView.getItems().add(companyObject);
            companyNameTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    public void deleteCompanyData(ActionEvent actionEvent) {
        Company selectedObject = companyTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            companyTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteCompany(selectedObject.getIdCompany());
        }
    }
}
