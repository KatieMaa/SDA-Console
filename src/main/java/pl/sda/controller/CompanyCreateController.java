package pl.sda.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import pl.sda.pdf.PdfFactory;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.StreetPrefix;
import pl.sdacademy.service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyCreateController extends Controller {

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
    public Company addCompanyOnAction() {
        return bindToModel();
    }

    private Company bindToModel() {
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
        DataService dataService = new DataService();
        dataService.printOutCompanyInfo(company);
        return company;
    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squareRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);

    }

    private void validate() {
        Pattern zipPattern = Pattern.compile("(^\\d{2}-\\d{3}$)");
        Matcher zipMatcher = zipPattern.matcher(postalCodeField.getText());
        if (zipMatcher.find()) {
            String zip = zipMatcher.group(1);
            showConfirmationAllert("Postal code is correct");
        } else {
            showErrorAlert("Sorry!Wrong postal code");
        }
    }

    @FXML
    void makePDFOnAction(ActionEvent event) {
        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.pdfFromCompany(addCompanyOnAction());
    }

    @FXML
    void validateOnAction(ActionEvent event) {
        validate();
    }
}

