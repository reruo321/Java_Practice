package Ch10.Ex20;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BorderExample extends JFrame {
    public BorderExample(){
        super("Border Demo");
        setLayout(new FlowLayout());
        JButton b1 = new JButton("버튼1");
        JButton b2 = new JButton("버튼2");
        JButton b3 = new JButton("버튼3");
        b1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        b2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        b3.setBorder(new LineBorder(Color.RED, 2, true));
        add(b1);
        add(b2);
        add(b3);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new BorderExample();
    }
}
