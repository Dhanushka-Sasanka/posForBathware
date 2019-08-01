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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.BO.custome.PlaceSrnBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.DTO.SRNDTO;
import lk.posForBathware.model.DTO.SRNDetailDTO;
import lk.posForBathware.model.TM.SrnDetailTM;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class SrnFormController implements Initializable {

    @FXML
    private JFXTextField txtSrnId;
    @FXML
    private JFXTextField txtBatch;
    @FXML
    private JFXTextField txtDisciption;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXButton brnAddTable;
    @FXML
    private TableView<SrnDetailTM> srnTable;
    @FXML
    private JFXDatePicker clander;
    @FXML
    private JFXButton btnRefresh;

    private static ArrayList<SrnDetailTM> srnData = new ArrayList<>();
    @FXML
    private TableColumn<?, ?> batchCol;
    @FXML
    private JFXButton btnInsert;
    @FXML
    private JFXTextField txtItemCode;
    private static ArrayList<SRNDetailDTO> srnDetailList = new ArrayList<>();
    private static ArrayList<ItemDTO> itemCodeList = new ArrayList<>();
    private static ArrayList<BatchDTO> batchList = new ArrayList<>();
    private static ArrayList<ItemDetailDTO> itemDetailList = new ArrayList<>();
    private static ArrayList<ItemDTO> itemDtoList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            clander.setValue(LocalDate.now());
            txtSrnId.setText(IDJenerator.getNewID("SRN", "SRNID","S"));
        } catch (Exception ex) {
            Logger.getLogger(SrnFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnAddTable(ActionEvent event) {
        getDataToTable();
        loadDataToTable();
    }

    @FXML
    private void btnInsertAction(ActionEvent event) {

        try {
            PlaceSrnBO placeSrnBO = (PlaceSrnBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PLACESRN);
            String srnid = txtSrnId.getText();
            String batchid = txtBatch.getText();
            String itemCode = txtItemCode.getText();
            String discription = txtDisciption.getText();
            int qty = Integer.parseInt(txtQty.getText());
            SRNDTO srndto = new SRNDTO(srnid);

            boolean isAddedSrnNote = placeSrnBO.addSrnNote(srndto, getTableData(), getBatchIdColomnData(), getItemCodeColomnData(), getItemData(), getItemDTO());
            if (isAddedSrnNote) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "SRN Note Added success..!", ButtonType.OK);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "SRN Note Added Failed..!", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(SrnFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnrefreshAction(ActionEvent event) {
        txtSrnId.clear();
        txtBatch.clear();
        txtItemCode.clear();
        txtDisciption.clear();
        txtQty.clear();

    }

    private void getDataToTable() {

        String srnid = txtSrnId.getText();
        String batchid = txtBatch.getText();
        String itemCode = txtItemCode.getText();
        String discription = txtDisciption.getText();
        int qty = Integer.parseInt(txtQty.getText());

        SrnDetailTM srnDetail = new SrnDetailTM( batchid, itemCode, discription, qty, getDate());
        srnData.add(srnDetail);
        srnTable.setItems(FXCollections.observableArrayList(srnData));

    }

    private void loadDataToTable() {
    
        srnTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchID"));
        srnTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        srnTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("discription"));
        srnTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        srnTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private String getDate() {
        String value = clander.getValue() != null ? clander.getValue().toString() : "";
        if (!value.equals(""));
        return value;

    }

    private ArrayList<SRNDetailDTO> getTableData() {

        for (SrnDetailTM item : srnTable.getItems()) {
            SRNDetailDTO srnDetail = new SRNDetailDTO( txtSrnId.getText() ,item.getBatchID(), item.getDiscription(), item.getQty(), item.getDate());
            srnDetailList.add(srnDetail);
        }
        return srnDetailList;
    }

    private ArrayList<BatchDTO> getBatchIdColomnData() {

        for (SrnDetailTM srn : srnTable.getItems()) {
            BatchDTO batchdto = new BatchDTO();
            batchdto.setBatchID(srn.getBatchID());
            batchList.add(batchdto);
        }
        return batchList;
    }

    private ArrayList<ItemDTO> getItemCodeColomnData() {

        for (SrnDetailTM srn : srnTable.getItems()) {
            ItemDTO itemdto = new ItemDTO();
            itemdto.setItemCode(srn.getItemCode());
            itemCodeList.add(itemdto);
        }
        return itemCodeList;
    }

    private ArrayList<ItemDetailDTO> getItemData() {

        for (SrnDetailTM srn : srnTable.getItems()) {
            ItemDetailDTO item = new ItemDetailDTO(srn.getItemCode(), srn.getBatchID(), srn.getQty());
            itemDetailList.add(item);
        }
        return itemDetailList;
    }

    private ArrayList<ItemDTO> getItemDTO() {

        for (SrnDetailTM srn : srnTable.getItems()) {
            ItemDTO item = new ItemDTO();
            item.setItemCode(srn.getItemCode());
            item.setQtyOnHand(srn.getQty());

            itemDtoList.add(item);
        }
        return itemDtoList;

    }
}
