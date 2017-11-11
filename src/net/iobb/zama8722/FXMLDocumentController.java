/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.iobb.zama8722.net.IPAddress;

/**
 *
 * @author Seiya
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label ipaddress;
    @FXML
    private Label renewIPNavigator;
    @FXML
    private Label pingNavigator;
    @FXML
    private TextField inputUrl;
    
    IPAddress ip;

    @FXML
    private void getIPAddress() {
        ip = new IPAddress();
        String a = ip.getIPAddress();
        ipaddress.setText(a);
    }

    @FXML
    private void renewIPAddress() {
        ip = new IPAddress();
        ip.thrmode = 0;
        ip.start();
        renewIPNavigator.setText("しばらくお待ちください。");
        try {
            ip.join();
        } catch (InterruptedException ex) {
            renewIPNavigator.setText("予期せぬエラー");
        }
        renewIPNavigator.setText(ip.ret);
    }

    @FXML
    private void actionPing() {
        ip = new IPAddress();
        ip.thrmode = 1;
        ip.url = inputUrl.getText();
        ip.start();
        pingNavigator.setText("接続中");
        try {
            ip.join();
        } catch (InterruptedException ex) {
            pingNavigator.setText("予期せぬエラー");
        }
        pingNavigator.setText(ip.ret);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ip = new IPAddress();
        ip.ret = "";
        ip.thrmode = 0;
        ip.url = "";
        ipaddress.setText(ip.getIPAddress());
    }

}
