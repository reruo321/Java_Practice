import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ch02Problem01 {
    public static void main(String[] args) throws java.io.IOException {
        System.out.println("-----Problem 01-----");
        System.out.println("*** Hello world ***\n\nWelcome to Java Programming");

        System.out.println("-----Problem 02-----");
        Scanner in = new Scanner(System.in);
        System.out.print("가로? ");
        int garo = in.nextInt();
        System.out.print("세로? ");
        int sero = in.nextInt();
        System.out.println("가로길이: " + garo + "cm " + "세로길이: " + sero + "cm");

        System.out.println("-----Problem 03-----");
        System.out.print("학번을 입력하십시오. ");
        int stdnum = in.nextInt();
        System.out.print("이름을 입력하십시오. ");
        String name = in.next();
        System.out.print("나이를 입력하십시오. ");
        int age = in.nextInt();
        System.out.println("학번: " + stdnum + ", 이름: " + name + ", 나이: " + age);

        System.out.println("-----Problem 04-----");
        JOptionPane.showConfirmDialog(null, "***Hello World***\n\nWelcome to Java Programming", "자바메시지", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

        System.out.println("-----Problem 05-----");
        Object stdnum2 = JOptionPane.showInputDialog(null, "학번을 입력하십시오.");
        Object name2 = JOptionPane.showInputDialog(null, "이름을 입력하십시오.");
        Object age2 = JOptionPane.showInputDialog(null, "나이를 입력하십시오.");
        JOptionPane.showMessageDialog(null, "당신의 학번: " + stdnum2 + " 이름: " + name2 + " 나이: " + age2);

        System.out.println("-----Problem 06-----");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("책 이름을 입력하십시오. ");
        String bookname = br.readLine();
        System.out.println("책 이름은 " + bookname + "입니다.");

        System.out.println("-----Problem 07-----");
        System.out.print("반지름을 입력하세요.. ");
        String sradius = br.readLine();
        Float radius = Float.valueOf(sradius);
        DecimalFormat fmt = new DecimalFormat("##0.##");
        System.out.println("반지름: " + fmt.format(radius) + " " + fmt.format(2 * 3.14 * radius));

    }
}
