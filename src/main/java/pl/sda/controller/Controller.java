package pl.sda.controller;

import javafx.scene.control.Alert;

/**
 * Created by RENT on 2017-03-16.
 */
public class Controller {

    protected void showErrorAlert(String message) {
        showAlert(Alert.AlertType.ERROR, message);
    }

    protected void showConfirmationAllert(String message) {
        showAlert(Alert.AlertType.CONFIRMATION, message);
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).show();
    }
}

