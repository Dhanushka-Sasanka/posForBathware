/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Danushka
 */
public class main extends Application {

    private static double xOffSet = 0;
    private static double yOffSet = 0;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/posForBathware/view/LoginForm.fxml"));
        Scene sean = new Scene(load);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        main.getMovebleStageLocation(load);
        main.getMovebleStage(load, primaryStage);
        primaryStage.setScene(sean);
        primaryStage.show();

    }

    public static void getMovebleStageLocation(Parent load) {

        load.setOnMousePressed(new EventHandler<MouseEvent>() {                     //moving stage
            @Override
            public void handle(MouseEvent event) {
                xOffSet = event.getSceneX();
                yOffSet = event.getSceneY();
            }
        });
    }

    public static void getMovebleStage(Parent load, Stage primaryStage) {
        load.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffSet);
                primaryStage.setY(event.getScreenY() - yOffSet);
            }
        });

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
