package Ch10.Ex03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample extends JFrame implements ActionListener {
    JPanel cardPanel;
    JButton b1, b2, b3, b4;
    public CardLayoutExample(){
        super("CardLayout Example");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel comPanel = new JPanel();
        b1 = new JButton("first");
        b2 = new JButton("previous");
        b3 = new JButton("next");
        b4 = new JButton("last");
        comPanel.add(b1);
        comPanel.add(b2);
        comPanel.add(b3);
        comPanel.add(b4);

        cardPanel = new JPanel();
        cardPanel.setLayout(new CardLayout());
        /* I noticed that add(String name, java.awt.Component comp) is obsolete as of 1.1, so I tried to adjust some codes...
        cardPanel.add("카드원", new JButton("카드1"));
        cardPanel.add("카드투", new JButton("카드2"));
        cardPanel.add("카드쓰리", new JButton("카드3"));
        cardPanel.add("카드포", new JButton("카드4"));
        mainPanel.add("Center", cardPanel);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("South", comPanel);
        getContentPane().add("Center", mainPanel);
         */
        cardPanel.add(new JButton("카드1"));
        cardPanel.add(new JButton("카드2"));
        cardPanel.add(new JButton("카드3"));
        cardPanel.add(new JButton("카드4"));
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(comPanel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();   // Gets the source of the event.
        if(o == b1)
            ((CardLayout) cardPanel.getLayout()).first(cardPanel);
        else if(o == b2)
            ((CardLayout) cardPanel.getLayout()).previous(cardPanel);
        if(o == b3)
            ((CardLayout) cardPanel.getLayout()).next(cardPanel);
        if(o == b4)
            ((CardLayout) cardPanel.getLayout()).last(cardPanel);
    }
    public static void main(String [] args){
        new CardLayoutExample();
    }
}
