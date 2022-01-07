package Ch10.Ex16;

import javax.swing.*;
import java.awt.*;

public class JSpinnerExample extends JFrame {
    public JSpinnerExample(){
        super("JSpinner Demo");
        setLayout(new FlowLayout());
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        add(spinner);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new JSpinnerExample();
    }
}
