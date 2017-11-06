/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iobb.zama8722.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

}
