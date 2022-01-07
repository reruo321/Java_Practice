package Ch10.Ex17;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneExample extends JFrame {
    public JScrollPaneExample(){
        super("JScollPane Demo");
        JScrollPane scroll = new JScrollPane();
        JTextArea area = new JTextArea(50, 50);
        scroll.setViewportView(area);
        getContentPane().add(scroll);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new JScrollPaneExample();
    }
}
