package Ch09.Pr03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class ScoreTest {
    static final String end_string = "E%N%D_O%F_F%I%L%E";
    static final String filename = ".\\Chapter09\\Ch09\\Pr03\\score.data";
    static final int STUDENT_NUM = 3;   // Change this to increase the number of students in the list.

    static boolean isFine(RandomAccessFile raf) throws IOException {   // Check if the list has the right number of info and is not corrupted.
        try {
            String str;
            int i = 0;
            raf.seek(0);
            while(i < STUDENT_NUM){
                raf.readUTF();
                i++;
            }
            return raf.readUTF().contains(end_string);
        }
        catch(IOException e){
            return false;
        }
    }

    public static void main(String [] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringTokenizer token;
        String student_id, name, str;
        int scoreA, scoreB, scoreC;
        char mode;

        try{
            while(true){
                RandomAccessFile raf = new RandomAccessFile(filename, "rw");
                if(!isFine(raf)) {
                    System.out.println("학생정보 파일을 새로 기록합니다.");
                    mode = 'i';
                }
                else {
                    System.out.print("학생 정보를 처음부터 입력하려면 i, 열람하려면 b, 종료하려면 q를 입력하십시오. ");
                    mode = scan.nextLine().charAt(0);
                }
                if(mode == 'i'){   // input
                    raf.setLength(0);   // This will clear the contents of the file.
                    System.out.println("=====학생정보 입력=====\n학번 이름 과목1점수 과목2점수 과목3점수 순으로 작성하십시오.");
                    for(int i=0; i<STUDENT_NUM; i++){
                        while(true) {
                            System.out.print((i + 1) + "번째 학생 정보 입력: ");
                            str = scan.nextLine();
                            token = new StringTokenizer(str);
                            if(token.countTokens() == 5)
                                break;
                            System.out.println((i+1) + "번째 학생 정보를 다시 입력합니다. ");
                        }
                        student_id = token.nextToken();
                        name = token.nextToken();
                        scoreA = Integer.parseInt(token.nextToken());
                        scoreB = Integer.parseInt(token.nextToken());
                        scoreC = Integer.parseInt(token.nextToken());
                        raf.writeUTF(student_id + "\t" + name + "\t" + scoreA + "\t" + scoreB + "\t" + scoreC + "\n");
                    }
                    raf.writeUTF(end_string);
                    System.out.println("\n작성 완료\n=====학생정보 목록=====");
                    raf.close();
                    raf = new RandomAccessFile(filename, "r");
                    for(int i=0; i<STUDENT_NUM; i++)
                    System.out.print(raf.readUTF());
                    raf.close();
                }
                else if(mode == 'b'){   // browse
                    while(true) {
                        boolean isFound = false;
                        System.out.print("\n학생 정보를 검색합니다. 학번을 입력하십시오. q를 입력하면 메뉴로 돌아갑니다. ");
                        student_id = scan.nextLine();
                        if(student_id.equals("q")) {
                            raf.close();
                            break;
                        }
                        raf.seek(0);
                        for(int i=0; i<STUDENT_NUM; i++){
                            str = raf.readUTF();
                            token = new StringTokenizer(str, "\t\n");
                            if(student_id.equals(token.nextToken())){
                                name = token.nextToken();
                                scoreA = Integer.parseInt(token.nextToken());
                                scoreB = Integer.parseInt(token.nextToken());
                                scoreC = Integer.parseInt(token.nextToken());
                                System.out.println("\n=====학생 정보=====\n학번: " + student_id + "\n이름: " + name);
                                System.out.println("과목1: " + scoreA + "점\n과목2: " + scoreB + "점\n과목3: " + scoreC + "점\n총점: " + (scoreA + scoreB + scoreC) + "점\n평균: " + (scoreA + scoreB + scoreC)/3 + "점");
                                isFound = true;
                            }
                        }
                        if(!isFound)
                            System.out.println("학번이 " + student_id + "인 학생의 정보를 찾을 수 없습니다.");
                    }
                }
                else if(mode == 'q'){
                    System.out.println("프로그램을 종료합니다.");
                    raf.close();
                    return;
                }
                else
                    System.out.println("i, b, q 중에서 입력하십시오.");
            }
        }
        catch(IOException e){
            System.out.println(e.toString());
            exit(0);
        }
    }
}
