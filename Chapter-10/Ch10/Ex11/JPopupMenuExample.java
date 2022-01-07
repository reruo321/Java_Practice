package Ch10.Ex11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JPopupMenuExample extends JFrame implements MouseListener {
    JPopupMenu popmenu;
    public JPopupMenuExample(){
        super("JPopupMenu Demo");
        setLayout(new FlowLayout());
        popmenu = new JPopupMenu();
        JMenuItem i1 = new JMenuItem("Copy");
        JMenuItem i2 = new JMenuItem("Cut");
        JMenuItem i3 = new JMenuItem("Paste");
        JMenu sub = new JMenu("OLE");
        JMenuItem ii1 = new JMenuItem("Image");
        JMenuItem ii2 = new JMenuItem("File");

        sub.add(ii1);
        sub.add(ii2);
        popmenu.add(i1);
        popmenu.add(i2);
        popmenu.add(i3);
        popmenu.addSeparator();
        popmenu.add(sub);
        addMouseListener(this);
        setSize(400, 300);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e))
            popmenu.show(this, e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public static void main(String [] args){
        new JPopupMenuExample();
    }

}
