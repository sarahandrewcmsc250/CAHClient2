/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cahclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class FXMLDocumentController implements Initializable {

    private CAHGateway gateway;
    @FXML
    private TextArea textArea;
    @FXML
    private HandPane hand;
    @FXML
    private Button submit;
    
    @FXML
    private void playWC(ActionEvent event) {
        String text = hand.getSelected().getText();
        gateway.playWhite(text);
        hand.removeCard(hand.getSelected());
    }

    public void setGateway(CAHGateway gateway) {
        this.gateway = gateway;

    }

    @Override
    //make a new fxml document
    public void initialize(URL url, ResourceBundle rb) {

    }
}
