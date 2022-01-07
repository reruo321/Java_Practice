package Ch10.Ex05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowHandler extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}

public class AdapterExample extends JFrame {
    public AdapterExample(){
        super("Window Listener Demo");
        setSize(300, 200);
        setVisible(true);
        addWindowListener(new WindowHandler());
    }

    public static void main(String [] args){
        new AdapterExample();
    }
}
