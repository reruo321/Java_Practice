package Ch13.Ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String [] args){
        Socket sc;
        BufferedReader in, stdin;
        PrintWriter out;
        String inLine = null;
        String host = "localhost";
        try{
            sc = new Socket(host, 1111);
            out = new PrintWriter(sc.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            stdin = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("송신: ");
            while((inLine = stdin.readLine()) != null){
                out.println(inLine);
                System.out.println("수신: " + in.readLine());
                System.out.print("송신: ");
            }
            in.close();
            out.close();
            sc.close();
        } catch(IOException e){ e.printStackTrace(); }
    }
}
