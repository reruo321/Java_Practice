import javax.swing.*;

public class Ch03Ex05FahrToCelsius {
    public static void main(String [] args){
        double fahr;
        int celsius;
        fahr = Double.parseDouble(JOptionPane.showInputDialog(null, "화씨 온도를 입력하세요..", "입력", JOptionPane.QUESTION_MESSAGE));
        celsius = (int) ((fahr - 32) * 5.0 / 9.0);
        JOptionPane.showMessageDialog(null, "섭씨 온도는 " + celsius + "도", "온도 변환", JOptionPane.INFORMATION_MESSAGE);
    }
}
