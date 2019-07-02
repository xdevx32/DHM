package utility;

import javafx.scene.control.Alert;

public class AlertErrorUtility {
    public static void showCustomAlert(String text) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setHeaderText(text);
        a.show();
    }
}
