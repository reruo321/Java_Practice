package Ch09.Ex04;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class ReaderWriterTest {
    public static void main(String [] args) throws IOException {
        FileReader fr = new FileReader("09E04reader.txt");
        OutputStreamWriter w = new OutputStreamWriter(System.out);

        char [] ch = new char[100];
        int n = 0;
        while( (n = fr.read(ch, 0, 60)) != -1){
            w.write(ch, 6, n);
        }
        System.out.println("Default Charset: " + Charset.defaultCharset().displayName());   // This represents the name of the default charset of this JVM.
        fr.close();
        w.close();
    }
}
