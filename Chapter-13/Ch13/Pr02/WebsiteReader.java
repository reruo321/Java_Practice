package Ch13.Pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebsiteReader {
    public static void main(String [] args){
        URL url;
        Scanner scan = new Scanner(System.in);
            while (true) {
                try{
                System.out.print("\n\nEnter the URL: ");
                url = new URL(scan.nextLine());
                System.out.println("The contents from " + url + "\n");
                URLConnection con = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                int ch;
                while((ch = reader.read()) != -1){
                    System.out.print((char) ch);
                }
            } catch(IOException e){ System.out.println("URL Loading Error..."); }
        }
    }
}
