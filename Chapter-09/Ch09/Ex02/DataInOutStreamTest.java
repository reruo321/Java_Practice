package Ch09.Ex02;

import java.io.*;

public class DataInOutStreamTest {
    public static void main(String [] args) throws IOException {
        String filename = "09E02data.txt";
        FileOutputStream fout = new FileOutputStream(filename);
        DataOutputStream dout = new DataOutputStream(fout);
        dout.writeUTF("테스트");
        dout.writeInt(100);
        dout.writeDouble(57.278);
        dout.writeChar('M');
        fout.close();
        dout.close();

        FileInputStream fin = new FileInputStream(filename);
        DataInputStream din = new DataInputStream(fin);
        System.out.println(din.readUTF());
        System.out.println(din.readInt());
        System.out.println(din.readDouble());
        System.out.println(din.readChar());
        fin.close();
        din.close();
    }
}
