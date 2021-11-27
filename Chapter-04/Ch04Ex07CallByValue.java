public class Ch04Ex07CallByValue {
    public static void swap(int a, int b){
        System.out.println("Before Method Process: a = " + a + ", b: " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Method Process: a = " + a + ", b: " + b);
    }

    public static void main(String [] args){
        int x = 10, y = 15;
        System.out.println("Before Method Calling: X = " + x + ", Y: " + y);
        swap(x, y);
        System.out.println("After Method Calling: X = " + x + ", Y: " + y);
    }
}
