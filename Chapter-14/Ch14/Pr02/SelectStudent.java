package Ch14.Pr02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectStudent extends JFrame implements ActionListener {
    final int panel_num = 8;
    String url, id, pw;
    JPanel p_label, p_text, p_button;
    JPanel p_main;
    JPanel [] p_row;
    JLabel [] label;
    JTextField [] text;
    JButton b_search, b_rewrite;
    Connection con = null;
    Statement st;
    ResultSet rs;
    public SelectStudent(String url, String id, String pw){
        super("학생성적조희");
        this.url = url;
        this.id = id;
        this.pw = pw;
        setLayout();
        b_search.addActionListener(this);
        b_rewrite.addActionListener(this);
        connectDB();
        setSize(300, 300);
        setVisible(true);
    }
    public void setLayout(){
        setLayout(new FlowLayout());
        label = new JLabel[panel_num-1];
        text = new JTextField[panel_num-1];
        setLabel();
        setTextField();
        p_label = new JPanel(new GridLayout(panel_num-1, 1));
        p_text = new JPanel(new GridLayout(panel_num-1, 1));
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        GridBagConstraints gd = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 0, 5, 0);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gd.fill = GridBagConstraints.BOTH;
        p_main = new JPanel(gb);
        p_button = new JPanel();
        p_row = new JPanel[panel_num];
        b_search = new JButton("조회");
        b_rewrite = new JButton("재작성");

        for(int i=0; i<panel_num-1; i++){
            label[i].setHorizontalAlignment(SwingConstants.CENTER);
            p_main.add(label[i]);
            gb.setConstraints(label[i], gd);
            p_main.add(text[i]);
            gb.setConstraints(text[i], gc);
        }
        p_button.add(b_search);
        p_button.add(b_rewrite);
        add(p_main);
        add(p_button);
    }
    public void setLabel(){
        label[0] = new JLabel("학　　　번:　");
        label[1] = new JLabel("이　　　름:　");
        label[2] = new JLabel("자료　구조:　");
        label[3] = new JLabel("계산기구조:　");
        label[4] = new JLabel("인터넷활용:　");
        label[5] = new JLabel("총　　　점:　");
        label[6] = new JLabel("평　　　균:　");
    }
    public void setTextField(){
        for(int i=0; i<panel_num-1; i++)
            text[i] = new JTextField(15);
        for(int i=2; i<text.length; i++)
            text[i].setEditable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        if(c instanceof JButton){
            if(c == b_search)
                searchStudent();
            else if(c == b_rewrite)
                rewrite();
        }
    }
    void connectDB(){
        try {
            con = DriverManager.getConnection(url, id, pw);
        } catch(SQLException e){ System.err.println("Failed to connect DB."); }
    }
    void searchStudent(){
        try{
            String std_id, std_name;
            int ds, cal, net, total;
            double avg;
            std_id = text[0].getText();
            std_name = text[1].getText();
            st = con.createStatement();
            rs = st.executeQuery("SELECT score_ds, score_cal, score_net FROM stdinfo WHERE std_id LIKE '" + std_id + "' AND std_name LIKE '" + std_name + "'");
            if(!rs.next()){
                text[2].setText("검색 결과가 없습니다.");
                for(int i=3; i<text.length; i++)
                    text[i].setText("-");
            }
            else{
                do{
                    ds = rs.getInt("score_ds");
                    cal = rs.getInt("score_cal");
                    net = rs.getInt("score_net");
                    total = ds + cal + net;
                    avg = (Math.round(total * 100 / 3.0)/100.0);
                } while(rs.next());
                text[2].setText(Integer.toString(ds));
                text[3].setText(Integer.toString(cal));
                text[4].setText(Integer.toString(net));
                text[5].setText(Integer.toString(total));
                text[6].setText(Double.toString(avg));
            }
            rs.close();
            st.close();
        } catch(SQLException e){ System.err.println("Failed to select values."); }
    }
    void rewrite(){
        for (JTextField t : text)
            t.setText("");
    }
    public static void main(String [] args){
        new SelectStudent("jdbc:mysql://localhost/jdbcproblem02?", "root", "password");
    }
}
