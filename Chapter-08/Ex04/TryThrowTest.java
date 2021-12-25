package Ch08.Ex04;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TryThrowTest {
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args) {
        int a;
        while(true){
            try {
                System.out.print("\n===메뉴===\n1. 도서 대출\n2. 도서 반납\n3. 종료\n메뉴를 선택하세요. [1~3] ");
                a = Integer.parseInt(scan.nextLine());
                switch(a){
                    case 1:
                        System.out.println("도서 대출 처리");
                        break;
                    case 2:
                        System.out.println("도서 반납 처리");
                        break;
                    case 3:
                        System.out.println("종료");
                        return;
                    default:
                        throw new MyException();
                }
            }
            catch(NumberFormatException | MyException e){
                System.out.println(e.toString());
            }
        }
    }
}
