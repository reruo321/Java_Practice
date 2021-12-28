package Ch09.Ex01;

import java.io.*;

public class CopyTest {
    static Copycls copy;
    static FileInputStream fin;
    static FileOutputStream fout;
    public static void main(String [] args) throws IOException {
        if(args.length < 1){
            System.out.println("파일명을 입력하세요.");
            System.exit(0);
        }
        else if(args.length == 1){   // Input written by console will be copied on args[0]
            fout = new FileOutputStream(args[0]);
            copy = new Copycls(System.in, fout);
            copy.Copy();
            System.out.println("키보드로 입력한 내용이 " + args[0] + " 파일에 복사되었습니다.");
        }
        else if(args.length == 2){   // contents on args[0] is copied on args[1]
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            copy = new Copycls(fin, fout);
            copy.Copy();
            System.out.println(args[0] + " 파일이 " + args[1] + " 파일에 복사되었습니다.");
        }
    }
}
