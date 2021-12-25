package Ch08.Pr01;

import java.io.*;

public class InputTest {
    public static void main(String [] args) throws IOException {
        boolean isRead = true;
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        try {
            while(str != null){
                System.out.println(str);
                str = br.readLine();
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
            isRead = false;
        }
        catch(IOException e){
            System.out.println(e.toString());
            isRead = false;
        }
        finally{
            if(isRead){
                fr.close();
                br.close();
            }
        }
    }
}
