/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.custome.DamageDetailBO;
import lk.posForBathware.BO.custome.PlaceDamageNote;
import lk.posForBathware.model.DTO.DamageDTO;
import lk.posForBathware.model.DTO.DamageDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.TM.DamageDetailTM;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class DamageFormController implements Initializable {

    @FXML
    private JFXTextField txtDamageId;
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXButton btnRefresh;
    @FXML
    private TableView<DamageDetailTM> tableDamage;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXDatePicker damageDate;

    private static ArrayList<DamageDetailTM> damageDetails = new ArrayList<>();
    @FXML
    private JFXButton btnFind;
    private JFXButton btnRemove;
    @FXML
    private JFXButton btnViewAll;
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnInsert;
    @FXML
    private JFXButton btnAddTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        damageDate.setValue(LocalDate.now());
        setToolTipText();
        loadDamageTable();
        try {
            
            txtDamageId.setText(IDJenerator.getNewID("Damage", "DamegeId", "D"));
            //
        } catch (Exception ex) {
            Logger.getLogger(DamageFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnrefreshAction(ActionEvent event) {
        clearAllFeilds();
    }


    @FXML
    private void btnInsert(ActionEvent event) {

        try {
            PlaceDamageNote placeDamageNote = (PlaceDamageNote) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PLACEDAMAGENOTE);
            boolean isAddedDamageNote = placeDamageNote.addDamageNote(getDamageDTO(), getDamageDetails(), getItemDTODetails(), getItemDetailDetails());
            if (isAddedDamageNote) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Damage Note Added Success...!", ButtonType.OK);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Damage Note Added Failed...!", ButtonType.OK);
                alert.showAndWait();

            }
        } catch (Exception ex) {
            Logger.getLogger(DamageFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String getDate() {
        String value = damageDate.getValue() != null ? damageDate.getValue().toString() : "";
        if (!value.equals(""));

        return value;
    }

    private void getDamageDetail() {
        String damegeid = txtDamageId.getText();
        String itemCode = txtItemCode.getText();
        int damageQty = Integer.parseInt(txtQty.getText());
        String discrip = txtDescription.getText();

        DamageDetailTM damageTM = new DamageDetailTM(damegeid, itemCode, discrip, damageQty, getDate());

        damageDetails.add(damageTM);

        tableDamage.setItems(FXCollections.observableArrayList(damageDetails));
    }

    private void loadDamageTable() {

        tableDamage.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("damageID"));
        tableDamage.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tableDamage.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("discription"));
        tableDamage.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tableDamage.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private void clearAllFeilds() {
        txtDamageId.clear();
        txtItemCode.clear();
        txtDescription.clear();
        txtQty.clear();
        tableDamage.getItems().clear();
        if (tableDamage != null) {
            tableDamage.getSelectionModel().clearSelection();
        }

    }

    private void setToolTipText() {

        btnFind.setTooltip(new Tooltip("Search from damage id"));
//        btnRemove.setTooltip(new Tooltip("Remove from Database"));
        btnViewAll.setTooltip(new Tooltip("All Damages"));
//        btnUpdate.setTooltip(new Tooltip("Update to Database"));
        btnInsert.setTooltip(new Tooltip("Add Damage Item to Database"));
        btnAddTable.setTooltip(new Tooltip("Add to Table"));
        btnRefresh.setTooltip(new Tooltip("Refresh All"));

    }


    @FXML
    private void tableViewKeyPressed(KeyEvent event) {
        if (tableDamage.getSelectionModel().getSelectedIndex() >= 0) {
            if (event.getCode().equals(KeyCode.DELETE)) {
                damageDetails.remove(tableDamage.getSelectionModel().getSelectedIndex());
            }
        }
    }

    @FXML
    private void btnViewAllAction(ActionEvent event) {
        try {
            DamageDetailBO damageDetails = (DamageDetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.DAMAGEDETAIL);
            ArrayList<DamageDetailDTO> allDamageDetail = damageDetails.getAllDamageDetail();
            for (DamageDetailDTO d : allDamageDetail) {
                DamageDetailTM tble = new DamageDetailTM(d.getDamageId(), d.getItemCode(), d.getDiscription(), d.getQty(), d.getDate());
                DamageFormController.damageDetails.add(tble);
                tableDamage.setItems(FXCollections.observableArrayList(DamageFormController.damageDetails));
            }
        } catch (Exception ex) {
            Logger.getLogger(DamageFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void btnAddTableAction(ActionEvent event) {
        getDamageDetail();

    }

    private ArrayList<DamageDTO> getDamageDTO() {
        ArrayList<DamageDTO> list = new ArrayList<>();
        for (DamageDetailTM item : tableDamage.getItems()) {
            DamageDTO damageDto = new DamageDTO(txtDamageId.getText(), item.getDate());
            list.add(damageDto);
        }
        return list;

    }

    private ArrayList<DamageDetailDTO> getDamageDetails() {
        ArrayList<DamageDetailDTO> list = new ArrayList<>();
        for (DamageDetailTM item : tableDamage.getItems()) {
            DamageDetailDTO damageDTO = new DamageDetailDTO(txtDamageId.getText(), item.getItemCode(), item.getDiscription(), item.getQty(), getDate());
            list.add(damageDTO);
        }
        return list;
    }

    private ArrayList<ItemDTO> getItemDTODetails() {
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (DamageDetailTM item : tableDamage.getItems()) {
            ItemDTO items = new ItemDTO();
            items.setItemCode(item.getItemCode());
            items.setQtyOnHand(item.getQty());
            list.add(items);

        }
        return list;
    }

    private ArrayList<ItemDetailDTO> getItemDetailDetails() {
        ArrayList<ItemDetailDTO> list = new ArrayList<>();
        for (DamageDetailTM item : tableDamage.getItems()) {
            ItemDetailDTO items = new ItemDetailDTO();
            items.setItemCode(item.getItemCode());
            items.setQtyOnHand(item.getQty());
            list.add(items);
        }
        return list;
    }

    @FXML
    private void btnFindAction(ActionEvent event) {
        
        
    }


}
