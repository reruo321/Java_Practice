package Ch07.Ex04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str;
        while(true) {
            System.out.println("파싱할 문장을 입력하세요..");
            str = scan.nextLine();
            if(str.equals("")){
                System.out.println("처리종료");
                break;
            }
            StringTokenizer token = new StringTokenizer(str);
            System.out.println("토큰 수: " + token.countTokens());
            while (token.hasMoreTokens()) {
                System.out.print(token.nextToken() + " | ");
            }
            System.out.println();
        }
    }
}
