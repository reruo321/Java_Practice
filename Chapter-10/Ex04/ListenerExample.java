package Ch10.Ex04;

import javax.swing.*;
import javax.xml.bind.Marshaller;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowHandler implements WindowListener {
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
}

public class ListenerExample extends JFrame {
    public ListenerExample(){
        super("Window Listener Demo");
        setSize(300, 200);
        setVisible(true);
        addWindowListener(new WindowHandler());
    }
    public static void main(String [] args){
        new ListenerExample();
    }
}
