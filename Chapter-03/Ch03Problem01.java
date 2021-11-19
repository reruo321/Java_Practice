import javax.swing.*;
import java.util.Scanner;

public class Ch03Problem01 {
    public static void main(String [] args){
        System.out.println("-----Problem 01-----");
        double x, y;
        int j, k = 5, m;
        x = (int) (5/2) * 2.7; // 5.4
        y = 3.5 + (int) x; // 8.5
        m = (int) (((float) k / 2) + 2.7); //  5
        j = 5 * 8 % 3; // 1
        System.out.println("x: " + x + "\ny: " + y + "\nm: " + m + "\nj: " + j);

        System.out.println("-----Problem 02-----");
        int a = 20, b = -5, c = 16;
        boolean X = true, Y = false, ans1, ans2;
        ans1 = !(X || Y) && b > 0; // false
        ans2 = a > b && c != a; // true
        System.out.println("ans1: " + ans1 + "\nans2: " + ans2);
        System.out.println("c 변수의 값을 왼쪽으로 2비트 이동: " + (c << 2) + "\nc 변수의 값을 오른쪽으로 2비트 이동: " + (c >> 2)); // 64, 4

        System.out.println("-----Problem 03-----");
        int p, q, result, A, B;
        p = q = 10;
        System.out.print("p => " + p);
        result = ++p;
        System.out.println(" ++p => p : " + p + " result : " + result); // 11 11
        System.out.print("q => " + q);
        result = q++;
        System.out.println(" q++ => q : " + q + " result : " + result); // 11 10

        A = B = 20;
        System.out.print("A => " + A);
        result = --A;
        System.out.println(" --A => A : " + A + " result : " + result); // 19 19
        System.out.print("B => " + B);
        result = B--;
        System.out.println(" B-- => B : " + B + " result : " + result); // 19 20

        System.out.println("-----Problem 04-----");
        boolean t;
        int jumsu;
        Scanner scn = new Scanner(System.in);
        System.out.print("점수를 입력하세요. ");
        jumsu = scn.nextInt();
        t = (jumsu >= 60 && jumsu <= 100) ? true : false;
        System.out.println(t); // if jumsu = 80, t = true

        System.out.println("-----Problem 05-----");
        int dbjumsu, javajumsu, total_jumsu, corse_cnt;
        double ave;
        char isPass;
        System.out.print("DB 점수: ");
        dbjumsu = scn.nextInt();
        System.out.print("JAVA 점수: ");
        javajumsu = scn.nextInt();
        total_jumsu = dbjumsu + javajumsu;
        corse_cnt = 2;
        ave = (double) total_jumsu / corse_cnt;
        isPass = (ave >= 60) ? 'P' : 'N';
        System.out.println("점수는? " + ave + " 평가결과는? " + isPass);

        System.out.println("-----Problem 06-----");
        double cel, fahr;
        System.out.println("섭씨 온도는?: ");
        cel = scn.nextDouble();
        fahr = (9.0 / 5.0) * cel + 32;
        System.out.println("화씨 온도는: " + fahr);

        System.out.println("-----Problem 07-----");
        int in_seconds, hours, minutes, seconds;
        System.out.print("초단위 시간을 입력하십시오. ");
        in_seconds = scn.nextInt();
        minutes = in_seconds / 60;
        hours = minutes / 60;
        minutes %= 60;
        seconds = in_seconds % 60;
        System.out.println(hours + "시간 " + minutes + "분 " + seconds + "초");

        System.out.println("-----Problem 08-----");
        int num08;
        String result08;
        String input08 = JOptionPane.showInputDialog("정수를 입력하십시오.");
        num08 = Integer.parseInt(input08);
        result08 = (num08 % 3 == 0) ? "맞습니다." : "아닙니다.";
        JOptionPane.showMessageDialog(null, "3의 배수가 " + result08);
    }
}
