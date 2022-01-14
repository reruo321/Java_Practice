package Ch10.Pr03;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class SwingCalculator extends JFrame implements ActionListener {
    static BigDecimal mem;
    static JTextField field;
    static JButton blank;
    JButton [] b_func;
    JButton [] b_mem;
    JButton [] b_num;
    JButton [] b_arith;
    JPanel p_func;
    JPanel p_mem;
    JPanel [] p_main;
    JPanel p_M;
    public SwingCalculator(){
        super("계산기");
        field = new JTextField("0");
        field.setEditable(false);
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        add(field);
        setButton();
        setPanel();
        setCalcLayout();
        addActions();
        setSize(500, 250);
        setVisible(true);
    }
    void setCalcLayout(){
        GridBagLayout gb = new GridBagLayout();
        setLayout(gb);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 10, 5, 10);
        gb.setConstraints(p_mem, gc);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(field, gc);
        gb.setConstraints(p_func, gc);
        gb.setConstraints(p_main[0], gc);
    }
    void setButton(){
        b_func = new JButton[3];
        b_mem = new JButton[4];
        b_num = new JButton[10];
        b_arith = new JButton[10];

        setButton1();
        setButton2();
        setButton3();
        setButton4();
    }
    void setButton1(){
        b_func[0] = new JButton("Backspace");
        b_func[1] = new JButton("CE");
        b_func[2] = new JButton("C");

        GridLayout grid = new GridLayout();
        grid.setHgap(5);
        p_func = new JPanel(grid);

        for(JButton j : b_func) p_func.add(j);
    }
    void setButton2(){
        blank = new JButton(" ");
        blank.setBorder(BorderFactory.createSoftBevelBorder(SoftBevelBorder.LOWERED));
        blank.setEnabled(false);
        blank.setAlignmentX(Component.CENTER_ALIGNMENT);
        blank.setMaximumSize(new Dimension(36, 22));

        b_mem[0] = new JButton("MC");
        b_mem[1] = new JButton("MR");
        b_mem[2] = new JButton("MS");
        b_mem[3] = new JButton("M+");

        p_mem = new JPanel();
        p_mem.setLayout(new GridLayout(5, 1, 0, 5));
        p_mem.add(blank);
        for(JButton j : b_mem) {
            j.setAlignmentX(Component.CENTER_ALIGNMENT);
            p_mem.add(j);
        }
    }
    void setButton3(){
        for(int i=0; i<10; i++)
            b_num[i] = new JButton(Integer.toString(i));
    }
    void setButton4(){
        b_arith[0] = new JButton("+/-");   // Negative
        b_arith[1] = new JButton(".");   // Dot
        b_arith[2] = new JButton("+");   // Add
        b_arith[3] = new JButton("=");   // Equal
        b_arith[4] = new JButton("-");   // Subtract
        b_arith[5] = new JButton("1/x");   // Rational
        b_arith[6] = new JButton("*");   // Multiply
        b_arith[7] = new JButton("%");   // Percentage
        b_arith[8] = new JButton("/");   // Divide
        b_arith[9] = new JButton("sqrt");   // Square Root
    }
    void setMainPanel(){
        p_main = new JPanel[4];

        GridLayout grid = new GridLayout(1, 5, 5, 0);
        for(int i=0; i<4; i++)
            p_main[i] = new JPanel(grid);

        for(int i=2; i>=0; i--){
            p_main[2-i].add(b_num[3*i+1]);   // 7 4 1
            p_main[2-i].add(b_num[3*i+2]);   // 8 5 2
            p_main[2-i].add(b_num[3*i+3]);   // 9 6 3
            p_main[2-i].add(b_arith[2*i+4]);   // 8 6 4
            p_main[2-i].add(b_arith[2*i+5]);   // 9 7 5
        }
        p_main[3].add(b_num[0]);
        p_main[3].add(b_arith[0]);
        p_main[3].add(b_arith[1]);
        p_main[3].add(b_arith[2]);
        p_main[3].add(b_arith[3]);
    }
    void setPanel(){
        add(p_mem);
        setMainPanel();
        add(p_func);
        GridLayout grid = new GridLayout(5, 1, 0, 5);
        p_M = new JPanel(grid);
        p_M.add(p_func);
        for(JPanel p : p_main) p_M.add(p);
        add(p_M);
    }
    void addActions(){
        for(JButton j : b_func)
            j.addActionListener(this);
        for(JButton j : b_mem)
            j.addActionListener(this);
        for(JButton j : b_num)
            j.addActionListener(this);
        for(JButton j : b_arith)
            j.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        if(c instanceof JButton){

            for(int i=0; i<3; i++)
            if(c == b_func[i]) {
                CalFunc.Functions(i);
                return;
            }
            for(int i=0; i<4; i++)
                if(c == b_mem[i]){
                 CalFunc.Memories(i);
                 return;
                }
            for(int i=0; i<10; i++)
                if(c == b_num[i]){
                    CalFunc.Numbers(i);
                    return;
                }
            for(int i=0; i<10; i++)
                if(c == b_arith[i]){
                    CalFunc.Arithmetics(i);
                    return;
                }
        }
    }
    public static void main(String [] args){
        new SwingCalculator();
    }
}
