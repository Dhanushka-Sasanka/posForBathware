/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.BO.custome.QueryBO;
import lk.posForBathware.model.TM.ItemFormTM;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class ItemFormController implements Initializable {

    @FXML
    private TableView<ItemFormTM> itemDetailTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            QueryBO queryBO = (QueryBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.QUERY);
            ArrayList<ItemFormTM> allItemDetail = queryBO.allItemDetail();

            itemDetailTable.setItems(FXCollections.observableArrayList(allItemDetail));
            
            
            itemDetailTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchId"));
            itemDetailTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            itemDetailTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("brand"));
            itemDetailTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discription"));
            itemDetailTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            itemDetailTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        } catch (Exception ex) {
            Logger.getLogger(ItemFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
