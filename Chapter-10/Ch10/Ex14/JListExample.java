package Ch10.Ex14;

import javax.swing.*;
import java.awt.*;

public class JListExample extends JFrame {
    public JListExample(){
        super("JList Demo");
        setLayout(new FlowLayout());
        Object [] data = {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6"};
        JList<Object> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(3);
        JScrollPane listscroll = new JScrollPane(list);
        add(listscroll);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new JListExample();
    }
}
