/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    IPAddress ip = new IPAddress();
    
    @FXML
    private Label ipaddress;
    
    @FXML
    private Label renewIPNavigator;
    
    @FXML
    private void getIPAddress() {
        String a = ip.getIPAddress();
        ipaddress.setText(a);
    }
    
    @FXML
    private void renewIPAddress(){
        ip.thrmode = 0;
        ip.start();
        renewIPNavigator.setText("しばらくお待ちください。");
        try {
            ip.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        renewIPNavigator.setText(ip.ret);
    }
    
    public void printIPNavigator(String message){
        renewIPNavigator.setText(message);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ipaddress.setText(ip.getIPAddress());
    }    
    
}
