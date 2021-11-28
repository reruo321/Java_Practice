import java.util.Scanner;

public class Ch04Problem03 {

    public static void problem07(){
        System.out.println("-----Problem 7-----");
        for(int i=0; i<5; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println();
        for(int i=0; i<5; i++) {
            for (int j = 5; j > i; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void problem08(){
        System.out.println("-----Problem 8-----");
        System.out.print("정수 10개를 입력하시오. ");
        int x[] = new int[10];
        boolean isIn = false;
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<10; i++)
            x[i] = scan.nextInt();
        System.out.print("배열에서 찾을 값을 입력하시오. ");
        int y = scan.nextInt();
        for(int i=0; i<10; i++){
            if(y == x[i]){
                System.out.println(y + "는 배열에서 " + (i+1) + "번째에 있습니다.");
                isIn = true;
            }
        }
        if(!isIn)
            System.out.println("배열 내 " + y + "와 일치하는 값이 없습니다.");
    }

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

    public static void problem09(){
        System.out.println("-----Problem 9-----");
        do {
            System.out.println("이름과 10문항의 답을 입력하세요...");
            Scanner scan = new Scanner(System.in);
            String name = scan.next();
            if(name.equals("Q") || name.equals("q"))
                return;

            int sheet[] = new int[10];
            for (int i = 0; i < sheet.length; i++)
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
        } while (true);
    }

    public static void main(String [] args){
        problem07();
        problem08();
        problem09();
    }
}
