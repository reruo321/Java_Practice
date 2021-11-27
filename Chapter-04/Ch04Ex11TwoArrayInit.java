public class Ch04Ex11TwoArrayInit {
    public static void main(String [] args){
        System.out.println("4행 2열 이차원 배열");
        int intArray[][] = {{100, 90}, {80, 70}, {50, 60}, {40, 30}};
        int transpose[][] = new int[2][4];
        int sum;
        for(int i=0; i<intArray.length; i++) {
            sum = 0;
            for (int j = 0; j < intArray[i].length; j++) {
                System.out.print(intArray[i][j]);
                if (j == intArray[i].length - 1)
                    System.out.print(" = ");
                else
                    System.out.print(" + ");
                sum += intArray[i][j];
            }
            System.out.println(sum);
        }

        System.out.println("\n2행 4열 이차원 배열");
        for(int i=0; i<intArray[0].length; i++)
            for(int j=0; j < intArray.length; j++)
                transpose[i][j] = intArray[j][i];

        for(int i=0; i< transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++)
                System.out.print(transpose[i][j] + "\t");
            System.out.println();
        }
    }
}
