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
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class SignOutScreenController implements Initializable {

    @FXML
    private AnchorPane signOutAncor;
    @FXML
    private JFXButton btnExit;
    @FXML
    private JFXButton btnSignout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000),signOutAncor);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    private void btnExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnSignOut(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/LoginForm.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.signOutAncor.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            main.getMovebleStage(root, stage);
            main.getMovebleStageLocation(root);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SignOutScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
