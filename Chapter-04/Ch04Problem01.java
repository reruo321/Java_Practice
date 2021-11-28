import java.util.Scanner;

public class Ch04Problem01 {
    public static void main(String [] args){
        System.out.println("-----Problem 1-----");
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        if(n1 < 0)
            n1 *= -1;
        System.out.println("Abs of Integer: " + n1);

        System.out.println("-----Problem 2-----");
        int n2 = scan.nextInt();
        if(n2 < 0)
            System.out.println("음수");
        else if(n2 == 0)
            System.out.println("0");
        else
            System.out.println("양수");

        System.out.println("-----Problem 3-----");
        char c3 = scan.next().charAt(0);
        if(c3 >= 'A' && c3 <= 'Z')
            System.out.println("대문자");
        else if(c3 >= 'a' && c3 <= 'z')
            System.out.println("소문자");
        else if(c3 >= '0' && c3 <= '9')
            System.out.println("숫자");
        else
            System.out.println("기타");
    }
}
