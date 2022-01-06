package Ch10.Ex01;

import java.awt.*;

public class AWTExample extends Frame {   // Extend Frame to show a window like the example figure...
    public AWTExample() throws InterruptedException {
        setLayout(new FlowLayout());
        add(new Button("버튼"));
        add(new Checkbox("체크박스"));
        Choice cho = new Choice();
        cho.add("블루");
        cho.add("레드");
        add(cho);
        add(new Label("레이블"));
        List list = new List(2, true);
        list.add("딸기");
        list.add("사과");
        add(list);
        add(new Scrollbar(Scrollbar.VERTICAL));
        add(new TextArea("테스트영역", 3, 15));
        add(new TextField("텍스트필드", 15));
        setSize(300, 200);
        setVisible(true);
        System.out.println("file.encoding: " + System.getProperty("file.encoding"));
    }
    public static void main(String [] args) throws InterruptedException {
        new AWTExample();
    }
}
