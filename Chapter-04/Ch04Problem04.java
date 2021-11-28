import java.util.Scanner;

public class Ch04Problem04 {

    public static void problem10(){
        System.out.println("-----Problem 10-----");
        int a[][]={ {5, 10}, {50, 55, 60}, {100, 150, 200, 250} };
        for(int i=0; i<a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void problem11(){
        System.out.println("-----Problem 11-----");
        int a[][]={ {5, 10}, {50, 55, 60}, {100, 150, 200, 250} };
        for(int i=0; i<a.length; i++)
            System.out.println((i+1) + "번째 행의 요소 개수: " + a[i].length);
    }

    public static void printArray(int sheet[]){
        for(int x : sheet)
            System.out.print(x + " ");
        System.out.println();
    }

    public  static int check(int sheet[][]){
        int correct = 0;
        for(int i=0; i<sheet[0].length; i++){
            if(sheet[0][i] == sheet[1][i]){
                System.out.print("O ");
                correct++;
            }
            else
                System.out.print("X ");
        }
        System.out.println();
        return correct;
    }

    public static void problem12(){
        System.out.println("-----Problem 12-----");
        do {
            System.out.println("이름과 10문항의 답을 입력하세요...");
            Scanner scan = new Scanner(System.in);
            String name = scan.next();
            if(name.equals("Q") || name.equals("q"))
                return;

            int sheet[][] = new int[2][10];
            for (int i = 0; i < sheet[0].length; i++)
                sheet[0][i] = scan.nextInt();

            System.out.println("*** 채점 결과 (" + name + ") ***");
            int answer[] = {1, 1, 1, 2, 3, 4, 2, 2, 3, 4};
            sheet[1] = answer;

            System.out.print("정답: ");
            printArray(sheet[1]);
            System.out.print("응답: ");
            printArray(sheet[0]);
            System.out.print("채점: ");
            int correct = check(sheet);
            System.out.println("점수: " + correct*10);
        } while (true);
    }

    public static void main(String [] args){
        problem10();
        problem11();
        problem12();
    }
}
