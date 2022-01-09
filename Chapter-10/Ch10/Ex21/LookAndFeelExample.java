package Ch10.Ex21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelExample extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    public LookAndFeelExample(){
        super("LookAndFeel Demo");
        setLayout(new FlowLayout());
        b1 = new JButton("윈도우");
        b2 = new JButton("자바");
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Component c = (Component) e.getSource();
        if(c instanceof JButton) {
            try {
                if (c == b1) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                }
                else if (c == b2) {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                }
            }
            catch(Exception ex){}
        }
    }

    public static void main(String [] args){
        new LookAndFeelExample();
    }
}
