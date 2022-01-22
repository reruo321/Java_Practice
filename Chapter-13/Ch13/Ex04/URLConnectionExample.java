package Ch13.Ex04;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String [] args) throws Exception {
        URL url = new URL("http://www.google.co.kr");
        System.out.println(url.getHost() + "의 내용:\n");

        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        int ch;
        while((ch = is.read()) != -1)
            System.out.print((char) ch);
    }
}
