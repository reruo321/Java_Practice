package Ch10.Ex07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonExample extends JFrame implements ActionListener {
    JButton b1;
    public JButtonExample(){
        super("JButton Demo");
        setLayout(new FlowLayout());
        b1 = new JButton("종료");
        getContentPane().add(b1);
        b1.addActionListener(this);
        setSize(200, 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        if(c == b1)
            System.exit(0);
    }

    public static void main(String [] args){
        new JButtonExample();
    }
}
