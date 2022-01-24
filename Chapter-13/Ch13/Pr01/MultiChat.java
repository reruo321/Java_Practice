package Ch13.Pr01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MultiChat {
    private static final String END = "EXIT";
    static final int PORT = 1238;
    static InetAddress address;
    static String name;
    static volatile boolean logout = false;
    public static void main(String [] args){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter your name: ");
                name = scan.nextLine();

                address = InetAddress.getByName("225.0.0.0");
                MulticastSocket sc = new MulticastSocket(PORT);
                sc.setTimeToLive(0);   // set this 1 for a subnet (0 for localhost)
                sc.joinGroup(address);
                Thread t = new Thread(new ReceiverThread(sc, address, PORT));
                t.start();

                System.out.println("Hello, " + name + "! - Address: " + address + ", Port: " + PORT);
                System.out.println("Enter your message.\n");
                while(true){
                    String message;
                    message = scan.nextLine();
                    if(message.equalsIgnoreCase(END)){
                        logout = true;
                        sc.leaveGroup(address);
                        sc.close();
                        break;
                    }
                    message = name + ": " + message;
                    byte [] b = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(b, b.length, address, PORT);
                    sc.send(packet);
                }
            }
        catch(IOException e){
                System.out.println("Socket Error!");
                e.printStackTrace();
            }
    }
}
class ReceiverThread implements Runnable {
    private final MulticastSocket sc;
    private final InetAddress address;
    private final int port;
    private final static int MAX_LEN = 1000;
    public ReceiverThread(MulticastSocket sc, InetAddress address, int port){
        this.sc = sc;
        this.address = address;
        this.port = port;
    }
    public void run(){
        while(!MultiChat.logout){
            byte [] b = new byte[MAX_LEN];
            DatagramPacket packet = new DatagramPacket(b, b.length, address, port);
            String message;
            try{
                sc.receive(packet);
                message = new String(b, 0, packet.getLength());
                if(!message.startsWith(MultiChat.name))
                    System.out.println(message);
            } catch(IOException e){ System.out.println("Disconnected."); }
        }
    }
}
