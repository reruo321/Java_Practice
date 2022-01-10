package Ch10.Pr02;

import javax.swing.*;
import java.awt.*;

public class SwingTest extends JFrame {
    public SwingTest(){
        super("Swing Test");
        setLayout(new FlowLayout());
        JRadioButton r1 = new JRadioButton("radio1");
        JRadioButton r2 = new JRadioButton("radio2");
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        JCheckBox c1 = new JCheckBox("check1");
        JCheckBox c2 = new JCheckBox("check2");
        JButton b1 = new JButton("button1");

        add(r1);
        add(r2);
        add(c1);
        add(c2);
        add(b1);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new SwingTest();
    }
}
