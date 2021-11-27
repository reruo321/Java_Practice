public class Ch04Ex08Recursive {
    public static int factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return factorial(n-1) * n;
    }

    public static void main(String [] args){
        for(int i=0; i < 5; i++)
            System.out.println(i + " ! = " + factorial(i));
    }
}
