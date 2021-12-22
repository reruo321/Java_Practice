package Ch07.Pr02;

import java.io.IOException;
import java.util.Scanner;

    class Square implements Shape{
    private double s;
    public Square(double s){
        this.s = s;
    }
    public double getArea(){
        return s * s;
    }
    public double getCircumference(){
        return s * 4;
    }
}

public class ShapeTest {

    public static void main(String [] args) throws IOException {
        System.out.print("정사각형 한 변의 길이를 입력하시오. ");
        double s = new Scanner(System.in).nextDouble();
        Square sq = new Square(s);

        System.out.println("정사각형의 면적: " + sq.getArea() + ", 정사각형의 둘레: " + sq.getCircumference());
    }

}
