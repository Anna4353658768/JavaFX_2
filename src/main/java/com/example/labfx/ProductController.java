package com.example.labfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProductController {
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> manufacturerColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label manufacturerCodeLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label contactPersonLabel;
    @FXML
    private Label phoneLabel;


    private MainApp mainApp;

    public ProductController() {
    }


    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        manufacturerColumn.setCellValueFactory(cellData -> cellData.getValue().getМanufacturer().nameProperty());

        showPersonDetails(null);

        productTable.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> showPersonDetails(newValue))
        );

    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        productTable.setItems(mainApp.getPersonData());
    }


    private void showPersonDetails(Product product) {
        if (product != null) {
            // Заполняем метки информацией из объекта person.
            nameLabel.setText(product.getName());
            weightLabel.setText(Float.toString(product.getWeight()));
            manufacturerCodeLabel.setText(product.getМanufacturer().getName());
            countryLabel.setText(product.getМanufacturer().getCountry());
            contactPersonLabel.setText(product.getМanufacturer().getContact_person());
            phoneLabel.setText(product.getМanufacturer().getPhone());
            sizeLabel.setText(SizeUtil.format(product.getSize()));
        } else {
            nameLabel.setText("");
            weightLabel.setText("");
            manufacturerCodeLabel.setText("");
            countryLabel.setText("");
            contactPersonLabel.setText("");
            phoneLabel.setText("");
            sizeLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewPerson() {
        Product tempPerson = new Product("",0F,0F,0F,0F,"","","","");
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }


    @FXML
    private void handleEditPerson() {
        Product selectedPerson = productTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


}