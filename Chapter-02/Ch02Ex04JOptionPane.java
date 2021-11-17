import javax.swing.*;
import java.awt.*;

public class Ch02Ex04JOptionPane {
    public static void main(String [] args){

        String name = JOptionPane.showInputDialog(null, "이름을 입력하세요.", "입력창", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, name + "님, 안녕하세요~", "메시지", JOptionPane.INFORMATION_MESSAGE);
        int yesno = JOptionPane.showConfirmDialog(null, "과일을 사시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (yesno == 0) {
            String[] selection = {"사과", "바나나", "포도"};
            Object fruit = JOptionPane.showInputDialog(null, "과일을 선택하십시오.", "과일 선택", JOptionPane.PLAIN_MESSAGE, null, selection, selection[0]);
            JOptionPane.showMessageDialog(null, fruit.toString() + "를 구매했습니다.", "구매 완료", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
