import java.util.Scanner;

public class Ch03Ex01DatatypeVariable {
    public static void main(String [] args){
        float diameter;
        int pointx = 0, pointy = 100, degree;
        char gender = 'M';
        boolean dataend = false;

        Scanner scan = new Scanner(System.in);
        System.out.print("온도를 입력하세요..");
        degree = scan.nextInt();
        diameter = 42.76f;
        dataend = true;

        System.out.println("지름(" + diameter + "cm), 온도(" + degree + "도), 성별(" + gender + "), 좌표(" + pointx + ", " + pointy + "), 데이터끝(" + dataend + ")");
    }
}
