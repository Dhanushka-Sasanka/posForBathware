/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.custome.DamageDetailBO;
import lk.posForBathware.dbConnection.DBConnection;
import lk.posForBathware.model.DTO.DamageDetailDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class ReportsController implements Initializable {

    @FXML
    private JFXButton brnAddTable1;
    @FXML
    private JFXButton brnAddTable11;
    @FXML
    private JFXButton brnAddTable111;
    @FXML
    private JFXButton btnDamageItemRep;
    @FXML
    private JFXButton brnAddTable11111;
    @FXML
    private JFXButton brnAddTable111111;
    @FXML
    private JFXButton brnAddTable1111111;
    @FXML
    private JFXButton brnAddTable1111;
    @FXML
    private JFXButton brnAddTable11111111;
    @FXML
    private JFXDatePicker reportDate;

    private Connection connection;
    @FXML
    private JFXButton btnAllInvoices;
    @FXML
    private JFXButton btnGrnNotes;
    @FXML
    private JFXButton btnSrnNotes;
    @FXML
    private JFXButton btnCreditCustomers;
    @FXML
    private JFXButton btnItemDeatil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reportDate.setValue(LocalDate.now());
        connection = DBConnection.getDBConnection().getConnection();
    }

    @FXML
    private void btnAddTable(ActionEvent event) {
    }

    @FXML
    private void btnDamageItemRep(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/posForBathware/Reports/damgeitem.jasper");
            HashMap map = new HashMap();

            JasperPrint jp = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(jp, false);
            String date = getDate();
            map.put("date", date);
        } catch (JRException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String getDate() {
        String value = reportDate.getValue() != null ? reportDate.getValue().toString() : "";
        if (!value.equals(""));

        return value;
    }

    @FXML
    private void btnAllInvoices(ActionEvent event) {
    }

    @FXML
    private void btnGrnNotes(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/posForBathware/Reports/GRNnote.jasper");
            HashMap map = new HashMap();

            JasperPrint jp = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(jp, false);

        } catch (JRException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSrnNotes(ActionEvent event) {
    }

    @FXML
    private void btnCreditCustomer(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/posForBathware/Reports/CrditCustomers.jasper");
            HashMap map = new HashMap();

            JasperPrint jp = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }

    @FXML
    private void btntemDetail(ActionEvent event) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/posForBathware/Reports/ItemDetails.jasper");
            HashMap map = new HashMap();

            JasperPrint jp = JasperFillManager.fillReport(is, map, connection);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
