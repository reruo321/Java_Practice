package Ch10.Ex12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample extends JFrame implements ActionListener {
    JLabel line;
    public JTextFieldExample(){
        super("JTextField Demo");
        setLayout(new FlowLayout());
        JTextField field = new JTextField("입력하시오", 20);
        line = new JLabel("입력내용은 여기에 출력됩니다.");
        getContentPane().add(field);
        getContentPane().add(line);
        field.addActionListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        if(c instanceof JTextField)
            line.setText("입력내용: " + ((JTextField) c).getText());
    }
    public static void main(String [] args){
        new JTextFieldExample();
    }
}
