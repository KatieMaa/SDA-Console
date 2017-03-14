package pl.sda.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

        @FXML
        private Button submit;

        @FXML
        private PasswordField passwordField;

        @FXML
        private TextField loginTextField;

        @FXML
        void submitOnAction(ActionEvent event) {
            System.out.println(loginTextField.getText());
            System.out.println(passwordField.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Hello");
            alert.show();

            /**
             * 1.powolujemy do zycia UserService
             * 2. Tworzymy Usera z polami pobranych fieldow
             * 3.metoda Authenticate
             * 4.Sprawdzenie czy haslo jest dobre(if)
             */
        }
    }

