package codebase.udp;

import codebase.connectors.impl.UdpNetworkConnector;

public class UdpExample {
    public static void main(String [] args) {
        UdpNetworkConnector connector = new UdpNetworkConnector();
        connector.init();
    }
}
