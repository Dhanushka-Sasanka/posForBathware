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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.custome.GRNFillingReportBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.BatchDetailDTO;
import lk.posForBathware.model.DTO.GRNDTO;
import lk.posForBathware.model.DTO.GRNDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.TM.GrnDetailTM;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class GrnFromController implements Initializable {

    @FXML
    private JFXTextField txtBatchId;
    @FXML
    private JFXTextField txtDiscription;
    @FXML
    private JFXButton btnInsert;
    @FXML
    private JFXTextField txtGrnId;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtItemDiscription;
    @FXML
    private JFXDatePicker grnDate;

    private ArrayList<GrnDetailTM> grnDetailList = new ArrayList<>();
    @FXML
    private JFXButton brnAddTable;
    @FXML
    private TableView<GrnDetailTM> grnTable;
    @FXML
    private TableColumn<GrnDetailTM, String> batchIDCol;
    @FXML
    private TableColumn<?, ?> grnIdCol;
    @FXML
    private TableColumn<?, ?> itemCodeCol;
    @FXML
    private TableColumn<?, ?> disCol;
    @FXML
    private TableColumn<?, ?> unitPriceCol;
    @FXML
    private TableColumn<?, ?> qtyCol;
    @FXML
    private JFXTextField txtBrand;
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
            grnDate.setValue(LocalDate.now());
            txtGrnId.setText(IDJenerator.getNewID("GRN", "GRNID", "G"));
            //getTbldata();
        } catch (Exception ex) {
            Logger.getLogger(GrnFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insertBtnAction(ActionEvent event) {
//        getData();
//        getTbldata();

        try {
            String batchId = txtBatchId.getText();
            String grnId = txtGrnId.getText();
            String grnDiscription = txtDiscription.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            int qty = Integer.parseInt(txtQty.getText());
            String itemCode = txtItemCode.getText();
            String itemDiscription = txtItemDiscription.getText();
            String brand = txtBrand.getText();

            BatchDTO batchDTO = new BatchDTO(batchId, unitPrice);

            GRNDTO grndto = new GRNDTO(grnId, grnDiscription, getDate());

//            ArrayList<BatchDetailDTO> batchDataList = getBatchdata();
            ItemDTO itemDTO = new ItemDTO(itemCode, brand, qty, unitPrice, itemDiscription);

//            ArrayList<GRNDetailDTO> grnDataList = getGRNData();
            GRNFillingReportBO grnFillingReport = (GRNFillingReportBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.GRNFILLINGREPORT);
            boolean isGrnAdded = grnFillingReport.putGRNReport(batchDTO, grndto, getBatchdata(), itemDTO, getGRNData() , getItemDetail());
            if (isGrnAdded) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Grn Added Success ...!", ButtonType.OK);
                alert.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Grn Added Failed ...!", ButtonType.OK);
                alert.show();
            }

        } catch (Exception ex) {
            Logger.getLogger(GrnFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadFilDataToTable() {
        grnTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchID"));
        grnTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("grnID"));
        grnTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        grnTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discription"));
        grnTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        grnTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

    @FXML
    private void btnAddTable(ActionEvent event) {
        String batchId = txtBatchId.getText();
        String grnId = txtGrnId.getText();

        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        String itemCode = txtItemCode.getText();
        String itemDiscription = txtItemDiscription.getText();

        GrnDetailTM grnDetailTM = new GrnDetailTM(batchId, grnId, itemCode, itemDiscription, unitPrice, qty);

        grnDetailList.add(grnDetailTM);

        grnTable.setItems(FXCollections.observableArrayList(grnDetailList));
        loadFilDataToTable();
    }

    private ArrayList<BatchDetailDTO> getBatchdata() {

        ArrayList<BatchDetailDTO> batchDetailslist = new ArrayList<>();
        for (GrnDetailTM batchData : grnTable.getItems()) {
//          String date = getDate();
            BatchDetailDTO batchDetailDTO = new BatchDetailDTO(batchData.getBatchID(), batchData.getGrnID(), batchData.getQty(), batchData.getUnitPrice(), getDate());
            batchDetailslist.add(batchDetailDTO);

        }
        return batchDetailslist;

    }

    private ArrayList<GRNDetailDTO> getGRNData() {

        ArrayList<GRNDetailDTO> grnDetailslist = new ArrayList<>();
        for (GrnDetailTM grnData : grnTable.getItems()) {
//          String date = getDate();
            GRNDetailDTO grndetailDTO = new GRNDetailDTO(grnData.getGrnID(), grnData.getItemCode(), grnData.getQty(), grnData.getUnitPrice(), getDate());
            grnDetailslist.add(grndetailDTO);

        }
        return grnDetailslist;

    }

    private ArrayList<ItemDetailDTO> getItemDetail() {
        ArrayList<ItemDetailDTO> list = new ArrayList<>();
        for (GrnDetailTM item : grnTable.getItems()) {
            ItemDetailDTO itemDetail = new ItemDetailDTO(item.getItemCode(), item.getBatchID(), item.getQty());
            list.add(itemDetail);
        }
        return list;

    }

//    private void getData() {
//        ArrayList<String> columnData = new ArrayList<>();
//
//        for (GrnDetailTM item : grnTable.getItems()) {
//            //            columnData.add(batchIDCol.getCellObservableValue(item).getValue());
//
//        }
//        System.out.println(columnData);
//    }
    private String getDate() {
        String value = grnDate.getValue() != null ? grnDate.getValue().toString() : "";
        if (!value.equals(""));

        return value;
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnrefreshAction(ActionEvent event) {
        txtBatchId.clear();
        txtGrnId.clear();
        txtDiscription.clear();
        txtUnitPrice.clear();
        txtQty.clear();
        txtItemCode.clear();
        txtItemDiscription.clear();
        txtBrand.clear();
    }
}
