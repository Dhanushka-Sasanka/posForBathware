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
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.BO.custome.SupplierBO;
import lk.posForBathware.model.DTO.SupplierDTO;
import lk.posForBathware.model.entity.Supplier;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class AddSupplierFormController implements Initializable {

    @FXML
    private JFXTextField txtSuplierID;
    @FXML
    private JFXTextField txtSupplierName;
    @FXML
    private JFXTextField txtCompany;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtTeleNo;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXButton btnFind;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private TableView<SupplierDTO> supllierTable;
    @FXML
    private JFXButton btnViewAll;
    @FXML
    private JFXButton btnInsert;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnNicFind;
    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton btnRefresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getToolTipTexts();
            getAllSuppliers();
            txtSuplierID.setText(IDJenerator.getNewID("Supplier", "SupplierID", "S"));
        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getToolTipTexts() {

        btnInsert.setTooltip(new Tooltip("Add Supplier to Database"));
        btnDelete.setTooltip(new Tooltip("Delete Supplier from Database"));
        btnFind.setTooltip(new Tooltip("Search from SupplierID"));
        btnViewAll.setTooltip(new Tooltip("View all Suppliers"));
        btnNicFind.setTooltip(new Tooltip("Search from NIC"));
        btnUpdate.setTooltip(new Tooltip("Update Supplier Data"));
        homeBtn.setTooltip(new Tooltip("Return to home"));
        btnRefresh.setTooltip(new Tooltip("Refresh all"));

    }

    @FXML
    private void btnTxtSupID(ActionEvent event) {
        btnFindAction(event);

    }

    @FXML
    private void btnFindAction(ActionEvent event) {

        try {
            txtTeleNo.setEditable(false);
            String inputId = txtSuplierID.getText();
            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);
            SupplierDTO supplier = supplierBO.searchSupplier(inputId);
            if (supplier != null) {
                txtSuplierID.setText((supplier.getSupplierID()));
                txtSupplierName.setText((supplier.getSupplierName()));
                txtCompany.setText((supplier.getCompany()));
                txtNic.setText((supplier.getNic()));
                txtTeleNo.setText((Integer.toString(supplier.getTeleNo())));
                txtEmail.setText((supplier.getEmail()));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No Such a Supplier..!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllSuppliers();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
        try {
            txtSuplierID.setDisable(false);
            SupplierDTO inputValues = getInputValues();
            SupplierDTO supplier = new SupplierDTO(inputValues.getSupplierID(), inputValues.getSupplierName(), inputValues.getCompany(), inputValues.getNic(), inputValues.getTeleNo(), inputValues.getEmail());

            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);
            boolean isUpdateSupplier = supplierBO.updateSupplier(supplier);
            if (isUpdateSupplier) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Supplier Updated ...!", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void tbleMouseClicked(MouseEvent event) {
        supllierTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SupplierDTO>() {
            @Override
            public void changed(ObservableValue<? extends SupplierDTO> observable, SupplierDTO oldValue, SupplierDTO newValue) {
                if (observable.getValue() != null) {
                    SupplierDTO value = observable.getValue();
                    txtSuplierID.setText(value.getSupplierID());
                    txtSupplierName.setText(value.getSupplierName());
                    txtCompany.setText(value.getCompany());
                    txtNic.setText(value.getNic());
                    txtTeleNo.setText(Integer.toString(value.getTeleNo()));
                    txtEmail.setText(value.getEmail());
                }
            }
        });
    }

    @FXML
    private void btnViewAllAction(ActionEvent event) {
        getAllSuppliers();
    }

    @FXML
    private void btnInsertAction(ActionEvent event) {
        try {
            SupplierDTO inputValues = getInputValues();
            SupplierDTO supplier = new SupplierDTO(inputValues.getSupplierID(), inputValues.getSupplierName(), inputValues.getCompany(), inputValues.getNic(), inputValues.getTeleNo(), inputValues.getEmail());

            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);

            boolean addSupplier = supplierBO.addSupplier(supplier);

            if (addSupplier) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Supplier Added Success..!", ButtonType.OK);
                alert.show();
                getAllSuppliers();
                setAllFeildsClear();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
        try {
            String id = txtSuplierID.getText();
            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);
            boolean isDeleteSupplier = supplierBO.deleteSupplier(id);
            if (isDeleteSupplier) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Supplier Delete Succssfuly...!", ButtonType.OK);
                alert.show();
                getAllSuppliers();

            }

        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SupplierDTO getInputValues() {
        String supplierID = txtSuplierID.getText();
        String supplierName = txtSupplierName.getText();
        String company = txtCompany.getText();
        String nic = txtNic.getText();
        int teleNo = Integer.parseInt(txtTeleNo.getText());
        String email = txtEmail.getText();

        SupplierDTO supplierDTO = new SupplierDTO(supplierID, supplierName, company, nic, teleNo, email);

        return supplierDTO;
    }

    private void getAllSuppliers() {
        try {
            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);
            ArrayList<SupplierDTO> allSupplier = supplierBO.getAllSupplier();
            supllierTable.setItems(FXCollections.observableArrayList(allSupplier));

            supllierTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
            supllierTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
            supllierTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Company"));
            supllierTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
            supllierTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("teleNo"));
            supllierTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));
        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setAllFeildsClear() {

        txtSuplierID.clear();
        txtSupplierName.clear();
        txtCompany.clear();
        txtNic.clear();
        txtTeleNo.clear();
        txtEmail.clear();
        if (supllierTable.getItems() != null) {
            supllierTable.getItems().clear();
        }
    }

    @FXML
    private void txtNicAction(ActionEvent event) {
        btnNicFindAction(event);
    }

    @FXML
    private void btnNicFindAction(ActionEvent event) {
        try {
            String nicNo = txtNic.getText();
            SupplierBO supplierBO = (SupplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPPLIER);
            SupplierDTO searchFromNic = supplierBO.searchFromNic(nicNo);
            if (searchFromNic != null) {
                txtSuplierID.setText((searchFromNic.getSupplierID()));
                txtSupplierName.setText((searchFromNic.getSupplierName()));
                txtCompany.setText((searchFromNic.getCompany()));
                txtNic.setText((searchFromNic.getNic()));
                txtTeleNo.setText((Integer.toString(searchFromNic.getTeleNo())));
                txtEmail.setText((searchFromNic.getEmail()));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No Such a Supplier..!", ButtonType.OK);
                alert.show();
                setAllFeildsClear();
                getAllSuppliers();
            }

        } catch (Exception ex) {
            Logger.getLogger(AddSupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
//        System.exit(0);
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void refreshBtn(ActionEvent event) {
        setAllFeildsClear();
    }

}
