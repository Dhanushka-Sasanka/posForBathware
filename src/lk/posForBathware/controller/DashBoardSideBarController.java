/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.posForBathware.main.main;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class DashBoardSideBarController implements Initializable {

    @FXML
    private AnchorPane dashAnchor;
    @FXML
    private JFXButton btnContacts;
    @FXML
    private JFXButton btnSignout;

    public AnchorPane getDashAnchor() {
        return dashAnchor;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/LoadingPage.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAction(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/Contact.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSales(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/PurchesOrder.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPurchase(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/SupplierOrderForm.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnItem(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/ItemForm.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnGRN(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/GrnFrom.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSRN(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/SrnForm.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPayments(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/Contact.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnReports(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/Reports.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSystem(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/Contact.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnDamage(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/DamageForm.fxml"));
            getDashAnchor().getChildren().clear();
            getDashAnchor().getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardSideBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnListAction(ActionEvent event) {

    }

    @FXML
    private void btnSignoutAction(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/SignOutScreen.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.dashAnchor.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            main.getMovebleStage(root, stage);
            main.getMovebleStageLocation(root);
            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
