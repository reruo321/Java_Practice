package Ch09.Pr04;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileInfoTest {
    static File file;
    public static void main(String [] args) {
            final String filename = args[0];
            file = new File(filename);
            SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
            System.out.println("=====파일 정보=====");
            System.out.println("파일 이름: " + file.getName());
            System.out.println("마지막 파일 수정 시간 및 날짜: " + simple.format(file.lastModified()));
            System.out.println("파일경로: " + file.getAbsolutePath());
            System.out.println("파일의 바이트 수: " + file.length() + "바이트");

            if(file.canRead())
                System.out.println("이 파일은 입력용으로 접근 가능합니다.");
            if(file.canWrite())
                System.out.println("이 파일은 출력용으로 접근 가능합니다.");

            if(file.exists())
                System.out.println("파일이 존재합니다.");
            else
                System.out.println("파일이 존재하지 않습니다.");
    }
}
