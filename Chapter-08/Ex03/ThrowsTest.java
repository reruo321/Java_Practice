package Ch08.Ex03;

import java.util.Scanner;

public class ThrowsTest {
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        int a, b;
        while(true){
            a = scan.nextInt();
            b = scan.nextInt();

            if((a | b) == 0)
                break;

            try{
                System.out.println(a + " / " + b + " = " + (a / b));
            } catch(ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }
    }
}
