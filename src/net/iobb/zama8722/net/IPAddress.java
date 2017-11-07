/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Seiya
 */
public class IPAddress extends Thread {
    
    public String ret;

    public IPAddress() {

    }
    
    public void run(){
        this.renewIPAddress();
    }

    public String getIPAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String ip = address.getHostAddress();
            return ip;
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public void renewIPAddress() {
        if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
            int result = 1;
            try {
                ProcessBuilder pb = new ProcessBuilder("open", "/Applications/System Preferences.app");
                Process p = pb.start();
                p.waitFor();
                result = p.exitValue();
            } catch (IOException | InterruptedException e) {
                this.ret = "処理に失敗しました。";
            }

            if (result == 0) {
                this.ret = "システム環境設定->ネットワーク より設定";
            } else {
                this.ret = "処理に失敗しました。";
            }
        } else if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            int result = 1;
            try {
                ProcessBuilder pb = new ProcessBuilder("ipconfig", "/renew");
                Process p = pb.start();
                p.waitFor();
                result = p.exitValue();
            } catch (IOException | InterruptedException ex) {
                this.ret = "処理に失敗しました。";
            }

            if (result == 0) {
                this.ret = "処理が完了しました。";
            } else {
                this.ret = "処理に失敗しました。";
            }
        } else {
            this.ret = "対応していないOSです。";
        }
    }

}
