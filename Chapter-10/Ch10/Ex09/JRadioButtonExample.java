package Ch10.Ex09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JRadioButtonExample extends JFrame implements ItemListener {
    JLabel l;
    public JRadioButtonExample(){
        super("JRadioButton Demo");
        setLayout(new FlowLayout());
        JRadioButton r1 = new JRadioButton("남자");
        JRadioButton r2 = new JRadioButton("여자");
        ButtonGroup group = new ButtonGroup();
        l = new JLabel("선택하시오");
        group.add(r1);
        group.add(r2);
        getContentPane().add(r1);
        getContentPane().add(r2);
        getContentPane().add(l);
        r1.addItemListener(this);
        r2.addItemListener(this);
        setSize(300, 200);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        Component c = (Component) e.getSource();
        if(c instanceof JRadioButton)
            if(e.getStateChange() == ItemEvent.SELECTED)
                l.setText(((JRadioButton) e.getItem()).getText());
    }

    public static void main(String [] args){
        new JRadioButtonExample();
    }
}
