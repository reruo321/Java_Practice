package Ch13.Ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSocketClient {
    public static void main(String [] args){
        String host = "localhost";
        BufferedReader in, stdin;
        PrintWriter out;
        String inLine = null;
        String outLine = null;
        try {
            Socket sc = new Socket(host, 1111);
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            stdin = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(sc.getOutputStream(), true);
            System.out.print("송신: ");
            while((outLine = stdin.readLine()) != null){
                out.println(outLine);
                inLine = in.readLine();
                System.out.println("수신: " + inLine);
                if(outLine.equalsIgnoreCase("bye"))
                    break;
                System.out.print("송신: ");
            }
            in.close();
            out.close();
            stdin.close();
            sc.close();
            System.exit(0);
        } catch(IOException e){ e.printStackTrace(); }
    }
}
