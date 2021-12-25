package Ch08.Ex02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyTest {
    static boolean isOpened = true;
    static FileReader fr;
    static BufferedReader br;
    public static void main(String [] args) throws IOException {
        fr = new FileReader(args[0]);
        br = new BufferedReader(fr);
        String str = br.readLine();
        try {
            while(str != null) {
                System.out.println(str);
                str = br.readLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("파일이 없습니다." + e.toString());
            isOpened = false;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("배열의 인덱스 오류입니다." + e.toString());
            isOpened = false;
        } finally{
            System.out.println();
            if(isOpened) {
                System.out.println("파일을 닫습니다.");
                fr.close();
                br.close();
            }
            System.out.println("finally블럭 수행..");
            System.out.println("처리 종료..");
        }

    }
}
