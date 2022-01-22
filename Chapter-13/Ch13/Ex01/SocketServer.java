package Ch13.Ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String [] args){
        ServerSocket ss;
        Socket sc;
        BufferedReader in;
        PrintWriter out;

        try{
            ss = new ServerSocket(1111);
            sc = ss.accept();
            while(true){
                in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                out = new PrintWriter(sc.getOutputStream(), true);
                String inLine = in.readLine();
                if(inLine == null)
                    break;
                System.out.println("수신: " + inLine);
                out.println(inLine);
                System.out.println("송신: " + inLine);
            }
        } catch(IOException e){ e.printStackTrace(); }
    }
}
