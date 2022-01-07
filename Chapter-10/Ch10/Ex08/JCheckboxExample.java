package Ch10.Ex08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckboxExample extends JFrame implements ItemListener {
    JLabel l;
    public JCheckboxExample(){
        super("JCheckbox Demo");
        setLayout(new FlowLayout());
        CheckboxGroup chkgroup = new CheckboxGroup();
        JCheckBox chk1 = new JCheckBox("선택1");
        JCheckBox chk2 = new JCheckBox("선택2");
        l = new JLabel("선택하시오");
        getContentPane().add(chk1);
        getContentPane().add(chk2);
        getContentPane().add(l);
        chk1.addItemListener(this);
        chk2.addItemListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED)
            l.setText(((JCheckBox)e.getItem()).getText());
        else if(e.getStateChange() == ItemEvent.DESELECTED)
            l.setText(null);
    }

    public static void main(String [] args){
        new JCheckboxExample();
    }
}
