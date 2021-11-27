public class Ch04Ex09MainArgs {
    public static void main(String [] args){
        int n = args.length;
        if(n == 0)
            System.out.println("No Arguments...");
        else{
            int sum = 0;
            for(int i=0; i<n; i++){
                System.out.println("args[" + i + "] = " + args[i]);
                sum += Integer.parseInt(args[i]);
            }
            System.out.println("SUM = " + sum);
        }

    }
}
