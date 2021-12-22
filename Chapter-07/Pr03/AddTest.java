package Ch07.Pr03;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

class Addition{
    static boolean Answer(int a, int b, int t){
        return ((a + b) == t);
    }
}

public class AddTest {

    public static void main(String [] args) throws IOException {
        long time_start = System.currentTimeMillis();
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int a, b, t, OK = 0;
        boolean isCorrect = false;
        System.out.println("덧셈 10문제의 정답을 입력하십시오.");

        for(int i=0; i<10; i++){
            a = rand.nextInt(9) + 1;
            b = rand.nextInt(9) + 1;
            System.out.printf("\n" + (i+1) + "번) %d + %d = ", a, b);
            t = scan.nextInt();
            isCorrect = Addition.Answer(a, b, t);
            if(isCorrect){
                System.out.println("맞았습니다.");
                OK++;
            }
            else
                System.out.println("틀렸습니다.");
        }
        long time_end = System.currentTimeMillis();
        double timeInterval = ((double) (time_end - time_start)/1000);
        System.out.println("\n정답률: " + 10 * OK + "%");
        System.out.println("풀이 시간: " + timeInterval + " 초");
    }

}
