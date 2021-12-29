package Ch09.Pr01;

/* TODO: Copy the contents of input .java file into the copyedFile.java. */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import static java.lang.System.exit;

class NotJavaFileException extends Exception{
    NotJavaFileException(){
        super(".java 파일이 아닙니다.");
    }
}

public class copyingFile {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        FileInputStream fin;
        FileOutputStream fout;
        byte [] b = new byte[120];
        String filename;
        int data;
            try{
                /*
                This will find the file according to the user's String input.
                Beware the directories of the input and output files, and adjust them if you need to do.
                */
                System.out.println("복사할 .java 파일명을 입력하십시오. ");
                filename = scan.nextLine();
                if(!filename.endsWith(".java"))
                    throw new NotJavaFileException();
                fin = new FileInputStream(filename);
                fout = new FileOutputStream(".\\Chapter09\\Ch09\\Pr01\\copyedFile.java");   // Same directory with this solution file. It overwrites the contents.
                while( (data = fin.read(b)) != -1){
                    fout.write(b, 0, data);
                }
                System.out.println(filename + "를 copyedFile.java에 복사했습니다.");
                fin.close();
                fout.close();
            }
            catch(Exception e){
                System.out.println(e.toString());
                exit(0);
            }
    }
}
