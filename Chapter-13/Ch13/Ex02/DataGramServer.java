package Ch13.Ex02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DataGramServer {
    public static void main(String [] args) throws SocketException {
        DatagramPacket packet = null;
        DatagramSocket socket = new DatagramSocket(1111);
        byte [] b;
        try{
            while(true){
                /* Receive the packet from the client */
                b = new byte[256];
                packet = new DatagramPacket(b, b.length);
                socket.receive(packet);
                String received = new String(packet.getData()).trim();
                System.out.println(received);
                /* Send the new packet to the client */
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                b = received.getBytes();
                packet = new DatagramPacket(b, b.length, address, port);
                socket.send(packet);
            }
        } catch(IOException e){ e.printStackTrace(); }
        socket.close();
    }
}
