package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CompaniesAndEmployeesTabController implements Initializable {

    public TextField employeeNameTextField;

    public TextField employeeEgnTextField;

    public TableView employeeTableView;

    public TableColumn employeeNameColumn;

    public TableColumn employeeEgnColumn;

    public TableColumn employeeCompanyColumn;

    public ComboBox selectCompanyComboBox;

    public TableColumn companyIdColumn;

    public TableColumn companyNameColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void saveEmployeeData(ActionEvent actionEvent) {
    }

    public void deleteEmployeeData(ActionEvent actionEvent) {
    }

    public void saveCompanyData(ActionEvent actionEvent) {
    }

    public void deleteCompanyData(ActionEvent actionEvent) {
    }
}
