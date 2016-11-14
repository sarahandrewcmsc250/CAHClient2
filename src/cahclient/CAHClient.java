/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cahclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class CAHClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       CAHGateway gateway = new CAHGateway();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSubmitHandle.fxml"));
        Parent root = (Parent) loader.load();   
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle("Welcome");
        FXMLSubmitHandleController controller = loader.getController();
        controller.setGateway(gateway);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
