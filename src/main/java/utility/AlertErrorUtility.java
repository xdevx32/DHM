package utility;

import javafx.scene.control.Alert;

/**
 * This is a class which has only one functionality - showing alerts.
 *
 */
public class AlertErrorUtility {
    /**
     * Show alert method that wraps the logic for popping up an alert.
     *
     * @param text This is the custom string that get passed and shown on the screen.
     */
    public static void showCustomAlert(String text) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setHeaderText(text);
        a.show();
    }
}
