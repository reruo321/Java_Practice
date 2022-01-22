package Ch13.Ex03;

import java.io.InputStream;
import java.net.URL;

public class URLExample {
    public static void main(String [] args) throws Exception {
        URL url = new URL("http://www.google.co.kr");
        System.out.println(url.getHost() + "의 내용:\n");
        InputStream is = url.openStream();
        int ch;
        while((ch = is.read()) != -1)
            System.out.print((char) ch);
        System.out.println();
    }
}
