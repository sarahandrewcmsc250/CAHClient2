/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cahclient;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class FXMLSubmitHandleController implements Initializable {
    private CAHGateway gateway;    
    private int room;
    @FXML
    TextField txtHandle;
    @FXML
    ChoiceBox<String> cbxChatRooms;

    public void submit(ActionEvent event){
        gateway.sendHandle(txtHandle.getText());
        gateway.sendLobby(room);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Welcome");
            stage.setOnCloseRequest(evt->System.exit(0));
            FXMLDocumentController controller = loader.getController();
            controller.setGateway(this.gateway);
            stage.show();
            txtHandle.getScene().getWindow().hide();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void setRoom(Object selectedRoom){
        room = Integer.parseInt(selectedRoom.toString());
    }
    
    public void setGateway(CAHGateway gateway){
        this.gateway = gateway;
        cbxChatRooms.setItems(gateway.getLobbies());
        cbxChatRooms.getSelectionModel().selectedItemProperty().addListener((obersvable, oldValue, newValue)->this.setRoom(newValue));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
}
