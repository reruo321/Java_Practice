public class Ch04Ex02For {
    public static void main(String [] args){
        double y;
        System.out.println("   x        y");
        for(double x = 1.0; x <= 2.0; x+=0.2){
            y = 2.0 * x * x;
            System.out.printf("%.3f    %.3f\n", x, y);
        }

        int intArr[] = {1, 22, 333, 4444, 55555};
        System.out.println("배열 안 숫자는?");
        for(int x : intArr){
            System.out.print(x + " ");
        }
    }
}
