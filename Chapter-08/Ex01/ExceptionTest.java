package Ch08.Ex01;

public class ExceptionTest {
    public static void main(String [] args) {
        try{
            int [] arr = {10, 20, 30, 40, 50};
            for(int i=0; i<=5; i++)
                System.out.println(arr[i]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        try{
            int a = 1;
            int b = 0;
            int c = a / b;
        }
        catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("bye!!!");
    }
}
