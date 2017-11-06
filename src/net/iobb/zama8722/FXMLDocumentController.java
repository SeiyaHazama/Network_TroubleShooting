/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.iobb.zama8722.net.IPAddress;

/**
 *
 * @author Seiya
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label ipaddress;
    
    @FXML
    private void getIPAddress(ActionEvent event) {
        IPAddress ip = new IPAddress();
        String a = ip.getIPAddress();
        ipaddress.setText(a);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
