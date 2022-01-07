package Ch10.Ex13;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class JTextAreaExample extends JFrame implements DocumentListener {
    JTextArea area;
    JLabel label;
    public JTextAreaExample(){
        super("JTextArea Demo");
        setLayout(new FlowLayout());
        area = new JTextArea(5, 25);
        label = new JLabel("입력내용은 여기에 출력됩니다.");
        getContentPane().add(area);
        getContentPane().add(label);
        area.getDocument().addDocumentListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public void insertUpdate(DocumentEvent e) {
        label.setText(area.getText());
    }
    public void removeUpdate(DocumentEvent e) {
        label.setText(area.getText());
    }
    public void changedUpdate(DocumentEvent e) {
        label.setText(area.getText());
    }

    public static void main(String [] args){
        new JTextAreaExample();
    }
}
