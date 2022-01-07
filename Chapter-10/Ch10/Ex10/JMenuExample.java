package Ch10.Ex10;

import javax.swing.*;
import java.awt.*;

public class JMenuExample extends JFrame {
    public JMenuExample(){
        super("JMenu Demo");
        setLayout(new FlowLayout());
        JMenu menu = new JMenu("Menu");
        JMenuBar bar = new JMenuBar();
        JMenuItem mi1 = new JMenuItem("MenuItem1");
        JMenuItem mi2 = new JMenuItem("MenuItem2");
        JRadioButtonMenuItem rmi1 = new JRadioButtonMenuItem("RadioButtonMenuItem1");
        JRadioButtonMenuItem rmi2 = new JRadioButtonMenuItem("RadioButtonMenuItem2");
        ButtonGroup group = new ButtonGroup();
        group.add(rmi1);
        group.add(rmi2);
        JCheckBoxMenuItem cmi = new JCheckBoxMenuItem("CheckBoxMenuItem");
        JMenu sub = new JMenu("Submenu");
        JMenuItem subitem = new JMenuItem("Submenu-MenuItem");
        sub.add(subitem);

        menu.add(mi1);
        menu.add(mi2);
        menu.add(rmi1);
        menu.add(rmi2);
        menu.add(cmi);
        menu.add(sub);
        bar.add(menu);
        this.setJMenuBar(bar);
        setSize(400, 300);
        setVisible(true);
    }
    public static void main(String [] args){
        new JMenuExample();
    }
}
