package Ch10.Ex15;

import javax.swing.*;
import java.awt.*;

public class JComboBoxExample extends JFrame {
    public JComboBoxExample(){
        super("JComboBox Demo");
        setLayout(new FlowLayout());
        Object [] data = {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6"};
        JComboBox<Object> combo = new JComboBox<>(data);
        getContentPane().add(combo);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new JComboBoxExample();
    }
}
