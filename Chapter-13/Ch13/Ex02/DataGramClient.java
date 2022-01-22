package Ch13.Ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DataGramClient {
    public static void main(String [] args){
        byte [] b = new byte[256];
        String host = "localhost";
        String send = null;
        DatagramPacket packet = null;
        BufferedReader in;
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(host);
            in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("송신: ");
            while((send = in.readLine()) != null){
                b = send.getBytes();
                packet = new DatagramPacket(b, b.length, address, 1111);
                socket.send(packet);
                packet = new DatagramPacket(b, b.length);
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println("수신: " + received);
                System.out.print("송신: ");
            }
            socket.close();
        } catch(IOException e){ e.printStackTrace(); }
    }
}
