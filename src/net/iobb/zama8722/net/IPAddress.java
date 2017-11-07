/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Seiya
 */
public class IPAddress {

    public IPAddress() {

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

    public String renewIPAddress() {
        if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
            int ret;
            try {
                ProcessBuilder pb = new ProcessBuilder("open", "/Applications/System Preferences.app");
                Process p = pb.start();
                p.waitFor();
                ret = p.exitValue();
            } catch (IOException | InterruptedException e) {
                return "処理に失敗しました。";
            }

            if (ret == 0) {
                return "システム環境設定->ネットワーク より設定";
            } else {
                return "処理に失敗しました。";
            }
        } else if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            int ret;
            try {
                ProcessBuilder pb = new ProcessBuilder("ipconfig", "/renew");
                Process p = pb.start();
                p.waitFor();
                ret = p.exitValue();
            } catch (IOException | InterruptedException ex) {
                return "処理に失敗しました。";
            }

            if (ret == 0) {
                return "処理が完了しました。";
            } else {
                return "処理に失敗しました。";
            }
        } else {
            return "対応していないOSです。";
        }
    }

}
