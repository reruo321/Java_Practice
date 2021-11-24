import java.util.Scanner;

public class Ch04Ex03While {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int score, sum=0, i=1;
        double avg;
        while(i <= 5){
            System.out.print(i + "번째 점수입력: ");
            score = scan.nextInt();
            sum += score;
            i++;
        }
        avg = (double) sum / 5;
        System.out.println("전체점수: " + sum + ", 평균점수: " + avg);
    }
}
