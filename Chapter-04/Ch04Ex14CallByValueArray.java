import java.util.Arrays;

public class Ch04Ex14CallByValueArray {

    public static void main(String [] args){
        int [] arr = {1, 22, 333};
        System.out.println("Before calling method, the elements of the array 'arr' are: " + Arrays.toString(arr));
        System.out.println("Before calling method, the value of the variable 'arr' is: " + arr);
        foo(arr);
        System.out.println("After calling foo, the elements of the array 'arr' are: " + Arrays.toString(arr));
        System.out.println("After calling foo, the value of the variable 'arr' is: " + arr);
        bar(arr);
        System.out.println("After calling bar, the elements of the array 'arr' are: " + Arrays.toString(arr));
        System.out.println("After calling bar, the value of the variable 'arr' is: " + arr);
    }

    public static void foo(int [] x){
        x[0] = 4444;
        x[1] = 55555;
        x = new int[]{666_666, 777_7777, 22};
    }

    public static void bar(int [] y){
        y = new int[]{666_666, 777_7777, 22};
        y[0] = 1234;
        y[1] = 56789;
    }
}
