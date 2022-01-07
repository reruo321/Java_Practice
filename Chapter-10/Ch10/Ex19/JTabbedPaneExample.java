package Ch10.Ex19;

import javax.swing.*;

public class JTabbedPaneExample extends JFrame {
    public JTabbedPaneExample(){
        super("JTabbedPane Demo");
        JTabbedPane tab = new JTabbedPane();
        JTextArea t1 = new JTextArea(50, 50);
        JButton t2 = new JButton("Tab2 Button...");
        tab.add("Tab1", t1);
        tab.add("Tab2", t2);
        add(tab);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new JTabbedPaneExample();
    }
}
