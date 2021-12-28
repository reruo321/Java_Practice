package Ch09.Ex05;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomFileTest {
    public static void main(String [] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String [] name = {"박미영", "오정희", "김문숙", "진미경", "차정숙"};
        String filename = "09E05Random.data";
        long input;

        try{
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            for(int i=0; i<5; i++){
                String str = name[i];
                raf.writeUTF(str);
            }
            System.out.println("RandomAccessFile 출력완료..");
            raf.close();
            RandomAccessFile raff = new RandomAccessFile(filename, "r");
            System.out.println("데이터의 순서를 입력하세요 [-1: 처리종료]");
            while(true){
                System.out.print("순서 [1~5]: ?  ");
                input = scan.nextLong();
                if(input == -1){
                    System.out.println("처리종료");
                    raf.close();
                    return;
                }
                raff.seek((input-1) * 11);   // By looking at the created data file, you can check that to go on the next name data, you should skip 11 bytes.
                System.out.println(raff.readUTF() + "\n");
            }
        }
        catch(IOException e){
            System.out.println("입출력 오류..");
        }
    }
}
