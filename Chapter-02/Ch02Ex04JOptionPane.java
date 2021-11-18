import javax.swing.*;

public class Ch02Ex04JOptionPane {
    public static void main(String [] args){

        String name = JOptionPane.showInputDialog(null, "이름을 입력하세요.", "입력창", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, name + " 고객님, 안녕하세요~", "메시지", JOptionPane.INFORMATION_MESSAGE);
        int yesno = JOptionPane.showConfirmDialog(null, "과일을 사시겠습니까?", "확인창", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (yesno == 0) {
            Object[] fselection = {"사과", "바나나", "포도"};
            Object[] wselection = {"쇼핑백", "상자", "맨손"};
            Object fruit = JOptionPane.showInputDialog(null, "과일을 선택하십시오.", "과일 선택", JOptionPane.PLAIN_MESSAGE, null, fselection, fselection[0]);
            int wrapping = JOptionPane.showOptionDialog(null, "포장은 어떻게 해드릴까요?", "포장 선택", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, wselection, wselection[0]);
            JOptionPane.showMessageDialog(null, fruit + "를 사서 " + wselection[wrapping] + "에 담았습니다.", "구매 완료", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "과일 구매를 취소합니다.", "구매 취소", JOptionPane.ERROR_MESSAGE);
        }
    }
}
