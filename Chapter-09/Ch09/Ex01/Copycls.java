package Ch09.Ex01;

import java.io.*;

public class Copycls {
    private InputStream in;
    private OutputStream out;
    private byte [] b;
    public Copycls(InputStream in, OutputStream out){
        this(in, out, 1024);
    }
    public Copycls(InputStream in, OutputStream out, int size){
        this.in = in;
        this.out = out;
        b = new byte[size];
    }
    public void Copy() throws IOException{
        int databyte = 0;
        while((databyte = in.read(b)) != -1){   // While databyte = in.read(b) does not finish to read input,
            out.write(b, 0, databyte);   // output "databyte" byte of data, to offset "0" of "b" array
        }
        in.close();
        out.close();
    }
}
