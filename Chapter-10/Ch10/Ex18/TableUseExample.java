package Ch10.Ex18;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableUseExample extends JFrame implements MouseListener {
    JTable table;
    String [][] data = {{"홍길동", "30", "선생님"}, {"아무개", "50", "회사원"}, {"김철수", "20", "대학생"}};;
    public TableUseExample(){
        super("TableUse Demo");
        String [] attributes = {"이름", "나이", "직업"};
        table = new JTable(data, attributes);
        JScrollPane scroll = new JScrollPane(table);   // Warning: Cover the table with JScrollPane, or it may not be properly displayed!!!
        add(scroll);
        table.addMouseListener(this);
        setSize(300, 200);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        if(row != -1 && col != -1)
        System.out.printf("<%d행, %d열> - %s\n", row + 1, col + 1, data[row][col]);
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String [] args){
        new TableUseExample();
    }
}
