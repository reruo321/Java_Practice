import java.awt.*;
import java.util.Scanner;

public class Ch04Ex04DoWhile {
    public static void main(String [] args){
        String input;
        char c;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("소문자를 입력하십시오. ");
            input = scan.next();
            c = input.charAt(0);
        } while(c < 'a' || c > 'z');
        System.out.println("입력받은 소문자: " + c);
        c = (char)(c + ('A' - 'a'));
        System.out.println("대문자 변환 결과: " + c);
    }
}
