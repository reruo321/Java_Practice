import java.util.Scanner;
public class Ch02Ex02Scanner {
    public static void main(String [] args){
        int age;
        String name;
        double weight, height;
        Scanner scan = new Scanner(System.in);

        System.out.print("이름: ");
        name = scan.next();
        System.out.print("나이: ");
        age = scan.nextInt();
        System.out.print("키: ");
        height = scan.nextDouble();
        System.out.print("몸무게: ");
        weight = scan.nextDouble();

        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "살");
        System.out.println("키: " + height + "cm");
        System.out.println("몸무게: " + weight + "kg");
    }
}
