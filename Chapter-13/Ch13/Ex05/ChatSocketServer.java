package Ch13.Ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatSocketServer {
    public static void main(String [] args){
        BufferedReader in, stdin;
        PrintWriter out;
        String inLine = null;
        Socket sc;
        try {
            ServerSocket ss = new ServerSocket(1111);
            sc = ss.accept();
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            stdin = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(sc.getOutputStream(), true);
            while(true){
                inLine = in.readLine();
                if(inLine == null || inLine.equalsIgnoreCase("bye")){
                    System.out.println("클라이언트가 연결을 끊었습니다. 채팅을 종료합니다...");
                    out.println("Disconnected...");
                    sc.close();
                    in.close();
                    stdin.close();
                    out.close();
                    ss.close();
                    System.exit(0);
                }
                System.out.println("수신: " + inLine);
                System.out.print("송신: ");
                inLine = stdin.readLine();
                out.println(inLine);
            }
        } catch(IOException e){ e.printStackTrace(); }
    }
}
