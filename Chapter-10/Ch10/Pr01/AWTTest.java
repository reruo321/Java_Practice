package Ch10.Pr01;

import java.awt.*;

public class AWTTest extends Frame {
    public AWTTest(){
        super("AWT Test");
        setLayout(new FlowLayout());
        Button button = new Button("button");
        TextField t1 = new TextField("field1");
        TextField t2 = new TextField("field2");
        List list = new List(3);
        list.add("data1");
        list.add("data2");
        list.add("data3");

        add(button);
        add(t1);
        add(t2);
        add(list);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String [] args){
        new AWTTest();
    }
}
