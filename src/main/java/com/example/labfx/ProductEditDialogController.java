package com.example.labfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField sizeLengthField;
    @FXML
    private TextField sizeWidthField;
    @FXML
    private TextField sizeHeightField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField мanufacturerNameField;
    @FXML
    private TextField мanufacturerCountryField;
    @FXML
    private TextField мanufacturerContactField;
    @FXML
    private TextField мanufacturerPhoneField;


    private Stage dialogStage;
    private Product product;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setPerson(Product product) {
        this.product = product;

        nameField.setText(product.getName());
        weightField.setText(Float.toString(product.getWeight()));

        sizeLengthField.setText(Float.toString(product.getSize().getLength()));
        sizeWidthField.setText(Float.toString(product.getSize().getWidth()));
        sizeHeightField.setText(Float.toString(product.getSize().getHeight()));

        мanufacturerNameField.setText(product.getМanufacturer().getName());
        мanufacturerCountryField.setText(product.getМanufacturer().getCountry());
        мanufacturerContactField.setText(product.getМanufacturer().getContact_person());
        мanufacturerPhoneField.setText(product.getМanufacturer().getPhone());

        if(product.getName().length() == 0){
            sizeLengthField.setText("");
            sizeWidthField.setText("");
            sizeHeightField.setText("");
            weightField.setText("");
        }
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            product.setName(nameField.getText());
            product.setWeight(Float.parseFloat(weightField.getText()));

            product.getSize().setLength(Float.parseFloat(sizeLengthField.getText()));
            product.getSize().setWidth(Float.parseFloat(sizeWidthField.getText()));
            product.getSize().setHeight(Float.parseFloat(sizeHeightField.getText()));

            product.getМanufacturer().setName(мanufacturerNameField.getText());
            product.getМanufacturer().setCountry(мanufacturerCountryField.getText());
            product.getМanufacturer().setContact_person(мanufacturerContactField.getText());
            product.getМanufacturer().setPhone(мanufacturerPhoneField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (мanufacturerNameField.getText() == null || мanufacturerNameField.getText().length() == 0) {
            errorMessage += "No valid мanufacturer name!\n";
        }
        if (мanufacturerCountryField.getText() == null || мanufacturerCountryField.getText().length() == 0) {
            errorMessage += "No valid мanufacturer country!\n";
        }
        if (мanufacturerContactField.getText() == null || мanufacturerContactField.getText().length() == 0) {
            errorMessage += "No valid мanufacturer contact!\n";
        }
        if (мanufacturerPhoneField.getText() == null || мanufacturerPhoneField.getText().length() == 0) {
            errorMessage += "No valid мanufacturer phone!\n";
        }

        if (weightField.getText() == null || weightField.getText().length() == 0) {
            errorMessage += "No valid weight!\n";
        } else {
            try {
                Float.parseFloat(weightField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid weight (must be an float)!\n";
            }
        }


        if (sizeLengthField.getText() == null || sizeLengthField.getText().length() == 0) {
            errorMessage += "No valid size length!\n";
        } else {
            try {
                Float.parseFloat(sizeLengthField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid size length (must be an float)!\n";
            }
        }
        if (sizeWidthField.getText() == null || sizeWidthField.getText().length() == 0) {
            errorMessage += "No valid size width!\n";
        } else {
            try {
                Float.parseFloat(sizeWidthField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid size width (must be an float)!\n";
            }
        }
        if (sizeHeightField.getText() == null || sizeHeightField.getText().length() == 0) {
            errorMessage += "No valid size height!\n";
        } else {
            try {
                Float.parseFloat(sizeHeightField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid size height (must be an float)!\n";
            }
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


}
