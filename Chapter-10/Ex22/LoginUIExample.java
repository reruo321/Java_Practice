package Ch10.Ex22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUIExample extends JFrame implements ActionListener {
    JButton login, again;
    JTextField id;
    JPasswordField password;
    JLabel loginlabel, idlabel, passlabel;
    public LoginUIExample(){
        super("로그인 화면");
        setLayout(new BorderLayout());
        login = new JButton("로그인");
        again = new JButton("다시입력");
        id = new JTextField(15);
        password = new JPasswordField(15);
        loginlabel = new JLabel("로그인");
        idlabel = new JLabel("아 이 디: ");
        passlabel = new JLabel("비밀번호: ");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel pp = new JPanel();
        p1.add(loginlabel);
        p2.add(idlabel);
        p2.add(id);
        p3.add(passlabel);
        p3.add(password);
        p4.add(login);
        p4.add(again);
        pp.add(p2);
        pp.add(p3);

        add(p1, BorderLayout.NORTH);
        add(pp, BorderLayout.CENTER);
        add(p4, BorderLayout.SOUTH);

        again.addActionListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        if(c instanceof JButton)
            if(c == again){
                id.setText("");
                password.setText("");
            }
    }
    public static void main(String [] args){
        new LoginUIExample();
    }
}
