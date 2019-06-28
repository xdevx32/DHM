package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import java.net.URL;
import java.util.ResourceBundle;


public class LandingPageController implements Initializable {

    @FXML
    private TabPane LandingPageTabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // This lambda expression catches the event when switching tabs
        // So it is excellent for refreshing data, if any of it is changed
        // Set a global boolean "dataChanged = 0" and switch it to 1 if any changes happen
        // then turn it again to 0 when the data is refreshed at all places.
        //        LandingPageTabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
        //            System.err.println("changed tab");
        //        });
    }

}
