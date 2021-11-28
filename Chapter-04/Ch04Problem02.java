import java.util.Scanner;

public class Ch04Problem02 {
    public static void main(String [] args){
        System.out.println("-----Problem 4-----");
        char gender4 = 'f';
        if(gender4 == 'M' || gender4 == 'm')
            System.out.println("male");
        else if(gender4 == 'F' || gender4 == 'f')
            System.out.println("female");
        else
            System.out.println("error");

        System.out.println("-----Problem 5-----");
        Scanner scan = new Scanner(System.in);
        int year5 = scan.nextInt();
        if(year5 % 4 == 0) {
            if (year5 % 400 == 0 || year5 % 100 != 0)
                System.out.println("윤년");
            else
                System.out.println("평년");
        }
        else
            System.out.println("평년");

        System.out.println("-----Problem 6-----");
        String item6[] = new String[10];
        int price6[] = new int[10];
        int number6[] = new int[10];
        int sum6 = 0;
        System.out.println("상품명, 단가, 수량 순서대로 상품 10개를 입력하십시오.");
        for(int i=0; i<10; i++){
            item6[i] = scan.next();
            price6[i] = scan.nextInt();
            number6[i] = scan.nextInt();
        }
        for(int i=0; i<10; i++)
            sum6 += price6[i] * number6[i];

        if(sum6 >= 10_00000) {
            System.out.print(sum6 + "원에서 20% 할인: ");
            sum6 *= (1 - 0.20);
            System.out.println(sum6 + "원입니다.");
        }
        else if(sum6 >= 7_00000) {
            System.out.print(sum6 + "원에서 15% 할인: ");
            sum6 *= (1 - 0.15);
            System.out.println(sum6 + "원입니다.");
        }
        else if(sum6 >= 5_00000) {
            System.out.print(sum6 + "원에서 12% 할인: ");
            sum6 *= (1 - 0.12);
            System.out.println(sum6 + "원입니다.");
        }
        else if(sum6 >= 3_00000) {
            System.out.print(sum6 + "원에서 5% 할인: ");
            sum6 *= (1 - 0.05);
            System.out.println(sum6 + "원입니다.");
        }
        else
            System.out.println(sum6 + "원입니다.");
        System.out.println("<<구매 목록>>");
        System.out.printf("%6s %10s %10s\n","상품명", "단가", "수량");
        for(int i=0; i<10; i++)
            System.out.printf("%6s %10d %10d\n", item6[i], price6[i], number6[i]);
    }
}
