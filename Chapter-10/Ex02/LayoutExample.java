package Ch10.Ex02;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class LayoutExample extends JFrame {
    public LayoutExample(){
        this(1);
        System.out.println("잘못된 입력입니다. 1번 레이어를 불러옵니다.");
    }
    public LayoutExample(int input){
        switch(input){
            case 1:
                Flow1();
                break;
            case 2:
                Border2();
                break;
            case 3:
                Grid3();
                break;
            case 4:
                Box4();
                break;
            case 5:
                GridBag5();
                break;
            default:
                System.out.println("잘못된 입력입니다. 1번 레이어를 불러옵니다.");
                Flow1();
                break;
        }
        setSize(400, 200);
        setVisible(true);
    }
    public void Flow1(){
        setLayout(new FlowLayout());
        add(new JButton("1번"));
        add(new JButton("2번"));
        add(new JButton("3번"));
    }
    public void Border2(){
        setLayout(new BorderLayout());
        add("East", new JButton("동쪽"));
        add("West", new JButton("서쪽"));
        add("South", new JButton("남쪽"));
        add("North", new JButton("북쪽"));
        add("Center", new JButton("가운데"));
    }
    public void Grid3(){
        setLayout(new GridLayout(2, 3));
        add(new JButton("A"));
        add(new JButton("B"));
        add(new JButton("C"));
        add(new JButton("D"));
        add(new JButton("E"));
        add(new JButton("F"));
    }
    public void Box4(){
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JButton("*"));
        add(new JButton("**"));
        add(new JButton("***"));
        add(new JButton("****"));
        add(new JButton("*****"));
    }
    public void GridBag5(){
        GridBagLayout gb = new GridBagLayout();
        setLayout(gb);
        GridBagConstraints gc = new GridBagConstraints();
        JButton b1 = new JButton("1번");
        JButton b2 = new JButton("2번");
        JButton b3 = new JButton("3번");
        JButton b4 = new JButton("4번");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        gc.fill = GridBagConstraints.BOTH;
        gb.setConstraints(b1, gc);
        gb.setConstraints(b2, gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(b3, gc);
        gb.setConstraints(b4, gc);
    }

    public static void main(String [] args) throws IOException {
        System.out.println("레이아웃 예시를 1~5 중 숫자를 입력해서 고르시오.\n1. FlowLayout\n2. BorderLayout\n3. GridLayout\n4. BoxLayout\n5. GridBagLayout\n");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.nextLine();
        new LayoutExample(input);
    }
}
