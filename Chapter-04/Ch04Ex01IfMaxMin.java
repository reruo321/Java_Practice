import java.util.Scanner;

public class Ch04Ex01IfMaxMin {
    public static void main(String [] args){
        int n1, n2;
        Scanner scan = new Scanner(System.in);

        System.out.print("첫번째 정수: ");
        n1 = scan.nextInt();
        System.out.print("두번째 정수: ");
        n2 = scan.nextInt();

        if(n1 > n2)
            System.out.println("큰 수: " + n1 + ", 작은 수: " + n2);
        else if(n1 < n2)
            System.out.println("큰 수: " + n2 + ", 작은 수: " + n1);
        else
            System.out.println("같은 수입니다.");
    }
}
