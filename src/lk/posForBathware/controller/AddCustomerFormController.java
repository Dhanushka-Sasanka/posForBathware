/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseEvent;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.custome.CreditCustomerBO;
//import lk.posForBathware.BO.custome.;
import lk.posForBathware.model.entity.CreditCustomer;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtMobileNo;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private TableView<CreditCustomer> customerTable;
    @FXML
    private JFXButton insertBtn;
    @FXML
    private JFXButton btnViewAll;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnFind;
    @FXML
    private JFXButton btnNicFind;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton btnRefresh;
    @FXML
    private TableColumn<CreditCustomer, String> colCusId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getToolTipTexts();
            getAllCreditCustomers();
            txtCustomerId.setText(IDJenerator.getNewID("CCustomer", "CustomerId","c"));

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getToolTipTexts() {
        insertBtn.setTooltip(new Tooltip("Add Customer to Database"));
        btnDelete.setTooltip(new Tooltip("Delete Customer from Database"));
        btnFind.setTooltip(new Tooltip("Search from CustomerID"));
        btnViewAll.setTooltip(new Tooltip("View all Customers"));
        btnNicFind.setTooltip(new Tooltip("Search from NIC"));
        btnUpdate.setTooltip(new Tooltip("Update Customer Data"));
        homeBtn.setTooltip(new Tooltip("Return to home"));
        btnRefresh.setTooltip(new Tooltip("Refresh all"));

    }

    @FXML
    private void insertBtn(ActionEvent event) {

        try {
            String id = txtCustomerId.getText();
            String name = txtCustomerName.getText();
            String nic = txtNic.getText();
            int tele = Integer.parseInt(txtMobileNo.getText());
            String email = txtEmail.getText();

            CreditCustomer ccustomer = new CreditCustomer(id, name, nic, tele, email);

            CreditCustomerBO superBO = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            boolean isAdded = superBO.addCustomer(ccustomer);

            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer Added Success...!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllCreditCustomers();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void viewAllBtnAction(ActionEvent event) {
        try {
            getAllCreditCustomers();

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllCreditCustomers() throws Exception {

        CreditCustomerBO customer = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
        ArrayList<CreditCustomer> allCreditCustomer = customer.getAllCreditCustomer();

        customerTable.setItems(FXCollections.observableArrayList(allCreditCustomer));

        customerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId_PK"));
        customerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        customerTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("teleNo"));
        customerTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void setAllFeildsClear() {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtNic.clear();
        txtMobileNo.clear();
        txtEmail.clear();

    }

    @FXML
    private void updateBtnAction(ActionEvent event) {
        try {
            String cusId = txtCustomerId.getText();
            String cusName = txtCustomerName.getText();
            String cusNic = txtMobileNo.getText();
            int cusTeleNo = Integer.parseInt(txtMobileNo.getText());
            String cusEmail = txtEmail.getText();

            CreditCustomer customer = new CreditCustomer(cusId, cusName, cusNic, cusTeleNo, cusEmail);

            CreditCustomerBO customerBO = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            boolean isUpdateCustomer = customerBO.updateCustomer(customer);
            if (isUpdateCustomer) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated Sucsess..!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllCreditCustomers();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void deleteBtnAction(ActionEvent event) {
        try {
            String id = txtCustomerId.getText();

            CreditCustomerBO creditCustomerBO = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            boolean isDeleteCustomer = creditCustomerBO.deleteCustomer(id);
            if (isDeleteCustomer) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer Deleted success...!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllCreditCustomers();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnFindAction(ActionEvent event) {
        try {
            String id = txtCustomerId.getText();

            CreditCustomerBO credicustomer = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            CreditCustomer searchCustomer = credicustomer.searchCustomer(id);
            if (searchCustomer != null) {
                txtCustomerId.setText(searchCustomer.getCustomerId_PK());
                txtCustomerName.setText(searchCustomer.getCustomerName());
                txtNic.setText(searchCustomer.getNic());
                txtMobileNo.setText(Integer.toString(searchCustomer.getTeleNo()));
                txtEmail.setText(searchCustomer.getEmail());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NO Such Customer..!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllCreditCustomers();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getSelectedIndexValues() {
        customerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CreditCustomer>() {
            @Override
            public void changed(ObservableValue<? extends CreditCustomer> observable, CreditCustomer oldValue, CreditCustomer newValue) {
                if (observable.getValue() != null) {
                    CreditCustomer value = observable.getValue();
                    txtCustomerId.setText(value.getCustomerId_PK());
                    txtCustomerName.setText(value.getCustomerName());
                    txtNic.setText(value.getNic());
                    txtMobileNo.setText(Integer.toString(value.getTeleNo()));
                    txtEmail.setText(value.getEmail());
                }
            }
        });

    }

    @FXML
    private void txtFeildAction(ActionEvent event) {
        btnFindAction(event);
    }

    @FXML
    private void mouseClicked(MouseEvent event) {
        getSelectedIndexValues();
    }

    @FXML
    private void btnNicFindAction(ActionEvent event) {
        try {
            String nic = txtNic.getText();
            CreditCustomerBO creditCustomer = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            CreditCustomer searchCustomer = creditCustomer.searchFromNic(nic);
            if (searchCustomer != null) {
                txtCustomerId.setText(searchCustomer.getCustomerId_PK());
                txtCustomerName.setText(searchCustomer.getCustomerName());
                txtNic.setText(searchCustomer.getNic());
                txtMobileNo.setText(Integer.toString(searchCustomer.getTeleNo()));
                txtEmail.setText(searchCustomer.getEmail());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NO Such Customer..!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllCreditCustomers();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
//        System.exit(0);
//        Platform.exit();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnrefreshAction(ActionEvent event) {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtNic.clear();
        txtMobileNo.clear();
        txtEmail.clear();
        customerTable.getItems().clear();
        

    }

}
