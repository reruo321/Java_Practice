package Ch09.Pr02;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class BookTest {
    static Scanner scan = new Scanner(System.in);
    static FileReader fr;
    static FileWriter fw;
    static BufferedReader br;
    static String code;
    static String name;
    static String author;
    static String publisher;
    static String str;
    static final String filename = ".\\Chapter09\\Ch09\\Pr02\\books.txt";
    public static void main(String [] args) throws IOException {
        if(args.length < 1){
            System.out.println("메인 메소드에 인자를 입력하시오. [1-책등록/2-책검색]");
            exit(0);
        }
        if(Integer.parseInt(args[0]) == 1){
            char yesno;
            try {
                while(true) {
                    System.out.print("도서목록을 초기화하겠습니까? 초기화하지 않으면 기존 목록에 추가합니다. [y/n] ");
                    yesno = scan.nextLine().charAt(0);
                    if (yesno == 'y'){
                        fw = new FileWriter(filename, false);
                        break;
                    }
                    if (yesno == 'n') {
                        fw = new FileWriter(filename, true);
                        break;
                    }
                    else
                        System.out.println("y 또는 n을 입력하십시오.");
                }

                while (true) {
                    fr = new FileReader(filename);
                    br = new BufferedReader(fr);
                    System.out.println("\n◆ 책 목록:");
                    while((str = br.readLine()) != null)
                        System.out.println(str);

                    System.out.println("\n=====책 입력====");
                    System.out.print("책의 분류코드를 입력하십시오. (!quit!를 입력하면 종료합니다.) ");
                    code = scan.nextLine();
                    if(code.equals("!quit!")){
                        System.out.println("입력시스템을 종료합니다.");
                        return;
                    }
                    System.out.print("책의 이름를 입력하십시오. ");
                    name = scan.nextLine();
                    System.out.print("책의 저자를 입력하십시오. ");
                    author = scan.nextLine();
                    System.out.print("책의 출판사를 입력하십시오. ");
                    publisher = scan.nextLine();

                    fw.write(code + "\t" + name + "\t" + author + "\t" + publisher + "\n");
                    fw.flush();
                }
            }
            catch(IOException e){
                System.out.println(e.toString());
                exit(0);
            }
        }
        else if(Integer.parseInt(args[0]) == 2){
            boolean isFound;
            System.out.println("도서목록을 검색합니다.");
            try {
                while (true) {
                    System.out.print("\n검색할 책의 이름을 입력하십시오. (!quit!를 입력하면 종료합니다.) ");
                    isFound = false;
                    String fname = scan.nextLine();
                    if (fname.equals("!quit!")) {
                        System.out.println("검색시스템을 종료합니다.");
                        return;
                    }
                    fr = new FileReader(filename);
                    br = new BufferedReader(fr);
                    StringTokenizer token;
                    while ((str = br.readLine()) != null) {
                        token = new StringTokenizer(str, "\t\n");
                        code = token.nextToken();
                        if ((name = token.nextToken()).equals(fname)) {
                            author = token.nextToken();
                            publisher = token.nextToken();
                            System.out.println("\n=====도서 정보=====\n분류코드: " + code + "\n책 이름: " + name + "\n저자: " + author + "\n출판사: " + publisher);
                            isFound = true;
                        }
                    }
                    if (!isFound)
                        System.out.println("제목이 " + fname + "인 책이 없습니다.");
                }
            }
            catch(IOException e){
                System.out.println(e.toString());
            }
        }
        else{
            System.out.println("메인 메소드에 인자를 1 또는 2만 입력하시오. [1-책등록/2-책검색]");
            exit(0);
        }
    }
}
