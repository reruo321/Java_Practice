import java.util.Scanner;

public class Ch04Ex13CheckAnswer {
    public static void printArray(int array[]){
        for(int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    public  static int check(int sheet[], int answer[]){
        int correct = 0;
        for(int i=0; i<answer.length; i++){
            if(answer[i] == sheet[i]){
                System.out.print("O ");
                correct++;
            }
            else
                System.out.print("X ");
        }
        System.out.println();
        return correct;
    }

    public static void main(String [] args){
        System.out.println("이름과 10문항의 답을 입력하세요...");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int sheet[] = new int[10];
        for(int i=0; i<sheet.length; i++)
            sheet[i] = scan.nextInt();

        System.out.println("*** 채점 결과 (" + name + ") ***");
        int answer[] = {1, 1, 1, 2, 3, 4, 2, 2, 3, 4};
        System.out.print("정답: ");
        printArray(answer);
        System.out.print("응답: ");
        printArray(sheet);
        System.out.print("채점: ");
        int correct = check(sheet, answer);
        System.out.println("점수: " + correct*10);
    }
}
