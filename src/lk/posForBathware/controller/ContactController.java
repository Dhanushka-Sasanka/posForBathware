/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.posForBathware.main.main;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class ContactController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void lblExited(MouseEvent event) {
        Object image = event.getSource();
        ScaleTransition sclpnl = new ScaleTransition(Duration.millis(1000), (Node) image);
        sclpnl.setFromX(1.0);
        sclpnl.setFromY(1.0);
        sclpnl.play();
    }

    @FXML
    private void lblEnterd(MouseEvent event) {
        Object image = event.getSource();
        ScaleTransition sclpnl = new ScaleTransition(Duration.millis(1000), (Node) image);
        sclpnl.setFromX(1.1);
        sclpnl.setFromY(1.1);
        sclpnl.play();
    }

    @FXML
    private void lblCustomerClicked(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/AddCustomerForm.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            main.getMovebleStage(root, stage);
            main.getMovebleStageLocation(root);
            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void lblSupplierClicked(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/AddSupplierForm.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            main.getMovebleStage(root, stage);
            main.getMovebleStageLocation(root);
            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
