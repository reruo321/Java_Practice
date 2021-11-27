public class Ch04Ex12ArrayParameter {

    public static void doubleElement(double a[]){
        for(int i=0; i<a.length; i++)
            a[i] *= 2;
    }

    public  static void modifyElement(double b){
        System.out.println("\n\n매개변수 (y[2])   : " + b);
        b += 10;
        System.out.println("매개변수 (y[2]+10)   : " + b);
    }

    public static void main(String [] args){
        double y[] = {10.0, 20.0, 30.0, 40.0, 50.0};
        double sum = 0.0;
        System.out.print("y배열   :");
        for(int i=0; i < y.length; i++)
            System.out.print(y[i] + " ");
        System.out.print("\ny[i]*2: ");
        doubleElement(y);
        for(int i=0; i < y.length; i++) {
            System.out.print(y[i] + " ");
            sum += y[i];
        }
        System.out.println("\ny의 합 : " + sum);

        modifyElement(y[2]);
        System.out.println("\ty[2]   : " + y[2]);
    }
}
