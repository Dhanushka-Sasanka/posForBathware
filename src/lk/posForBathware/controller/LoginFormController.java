/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
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
public class LoginFormController implements Initializable {
    
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView closeBtn;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXTextField txtUserName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000),mainAnchor);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    
    @FXML
    private void mouseExited(MouseEvent event) throws IOException {
    }
    
    @FXML
    
    private void mouseEnterd(MouseEvent event) {
        
    }
    
    @FXML
    private void closeBtn(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void loginBtn(ActionEvent event) throws IOException, InterruptedException {
        if (isPasswordCorect()) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/DashBoardSideBar.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) this.mainAnchor.getScene().getWindow();
            
            main.getMovebleStage(root, stage);
            main.getMovebleStageLocation(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
        } else {
            
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your Username or Password Incorrect Try Again ...! ", ButtonType.PREVIOUS);
                  
            alert.showAndWait();
            
            allFieldsClear();
            
        }
        
    }
    
    private boolean isPasswordCorect() {
        String userName = txtUserName.getText();
        String passWord = txtPassword.getText();
        return userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin") ? true : false;
        
    }
    
    private void allFieldsClear() {
        txtUserName.clear();
        txtPassword.clear();
        
    }

}
