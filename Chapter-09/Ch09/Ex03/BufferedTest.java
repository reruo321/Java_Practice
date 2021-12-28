package Ch09.Ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferedTest {
    public static void main(String [] args) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(System.in);
        BufferedOutputStream bout = new BufferedOutputStream(System.out);
        byte [] b = new byte[100];
        int n = 0;
        while( (n = bin.read(b)) != -1 ){
            bout.write(b, 0, n);
            bout.flush();
        }
        bin.close();
        bout.close();
    }
}
