package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;

public class CompanyCreateController {

    @FXML
    private TextField streetField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField houseNumberField;

    @FXML
    private RadioButton streetRadio;

    @FXML
    private TextField postalCodeField;

    @FXML
    private Button addCompanyButton;

    @FXML
    private TextField flatNumberField;

    @FXML
    private RadioButton avenueRadio;

    @FXML
    private TextField cityNameField;

    @FXML
    private TextField nipNumberField;

    @FXML
    private RadioButton squareRadio;
    private StreetPrefix streetPrefix;

    @FXML
    void choosePrefixOnAction(ActionEvent event) {
        if (event.getSource() instanceof RadioButton) {
            RadioButton currentPrefixRadioButton = (RadioButton) event.getSource();//rzutowanie typow
            String buttonName = currentPrefixRadioButton.getText();
            switch (buttonName) {
                case "Ulica":
                    streetPrefix = StreetPrefix.STREET;
                    break;
                case "Aleja":
                    streetPrefix = StreetPrefix.AVENUE;
                    break;
                case "Plac":
                    streetPrefix = StreetPrefix.SQUARE;
                    break;
            }
        }

    }


    @FXML
    void addCompanyOnAction(ActionEvent event) {
        Company company = new Company();
        company.setName(companyNameField.getText());
        Address address = new Address();
        address.setStreetPrefix(streetPrefix);
        address.setStreetName(streetField.getText());
        address.setHouseNumber(houseNumberField.getText());
        address.setFlatNumber(flatNumberField.getText());
        address.setPostalCode(postalCodeField.getText());
        address.setCity(cityNameField.getText());
        company.setAddress(address);
        company.setNIP(nipNumberField.getText());

        System.out.println(company);
    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squareRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);
    }


}

