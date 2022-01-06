package Ch10.Ex06;

import javax.swing.*;
import java.awt.*;

public class JLabelExample extends JFrame {
    public JLabelExample(){
        super("JLabel Demo");
        JLabel l1 = new JLabel("레이블1", JLabel.CENTER);
        JLabel l2 = new JLabel("레이블2");
        l1.setForeground(Color.RED);
        l2.setForeground(Color.blue);
        getContentPane().add(l1, BorderLayout.NORTH);
        getContentPane().add(l2, BorderLayout.SOUTH);
        setSize(200, 100);
        setVisible(true);
    }
    public static void main(String [] args){
        new JLabelExample();
    }
}
