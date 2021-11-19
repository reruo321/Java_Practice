import java.util.Scanner;

public class Ch03Ex04ConditionalOp {
    public static void main(String [] args){
        int gender, a, b, bigger, smaller;
        String genstr;
        Scanner scan = new Scanner(System.in);

        System.out.println("당신의 성별은? (0/1)");
        gender = scan.nextInt();
        genstr = (gender == 0) ? "남자" : "여자";
        System.out.println(genstr + "입니다.");

        System.out.print("두개의 정수를 입력하세요..");
        a = scan.nextInt();
        b = scan.nextInt();
        bigger = (a > b) ? a : b;
        smaller = (b > a) ? a : b;
        System.out.println("큰 값: " + bigger + "\n작은 값: " + smaller);
    }
}
