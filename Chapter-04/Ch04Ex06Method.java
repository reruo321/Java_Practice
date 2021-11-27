import java.util.Scanner;

public class Ch04Ex06Method {
    public static double input(){
        System.out.print("반지름을 입력하시오. ");
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    public static double calarea(double r){
        return Math.PI * Math.pow(r, 2);
    }

    public static double calcircum(double r){
        return 2 * Math.PI * r;
    }

    public static void main(String [] args){
        double radius = input();
        double area = calarea(radius);

        System.out.printf("Radius: %.3f  Area: %.3f  Circumference: %.3f", radius, area, calcircum(radius));
    }
}
