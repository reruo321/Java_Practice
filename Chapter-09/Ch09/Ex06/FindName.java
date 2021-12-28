package Ch09.Ex06;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindName {
    static FileReader fr;
    static BufferedReader br;
    static Scanner scan = new Scanner(System.in);
    static StringTokenizer token;
    public static void main(String [] args) throws IOException {
        System.out.println("** 회원 정보 검색 **");
        String input;
        String sentence;
        String fname;
        boolean isFound;
        char yesno;
        try {
            while (true) {
                fr = new FileReader("09E06person.txt");
                br = new BufferedReader(fr);
                isFound = false;
                System.out.print("\n이름 입력: ");
                input = scan.nextLine();
                System.out.println("\n=====검색결과=====");
                while((sentence = br.readLine()) != null){
                    token = new StringTokenizer(sentence, " ");
                    fname = token.nextToken();
                    if(input.equals(fname)){
                        System.out.println("이름: " + fname);
                        System.out.println("나이: " + token.nextToken());
                        System.out.println("직업: " + token.nextToken());
                        isFound = true;
                    }
                }
                if(!isFound)
                    System.out.println(input + "에 대한 정보가 없습니다.");
                System.out.print("계속 하시겠습니까? ");
                while(true){
                    yesno = scan.next().charAt(0);
                    scan.nextLine();
                    if(yesno == 'y')
                        break;
                    else if(yesno == 'n'){
                        System.out.println("Bye!");
                        return;
                    }
                    else
                        System.out.println("y 또는 n으로 입력하십시오. ");
                }
            }
        }
        catch(IOException e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}
