package Ch07.Pr04;

import java.util.StringTokenizer;

public class MathTokenTest {
    public static void main(String [] args){
        // TODO: Represent 34, abs of -10, square root of 16 using Math package
        int m1 = Math.incrementExact(33);   // I don't know what to use for "34" exactly...
        int m2 = Math.abs(-10);
        double m3 = Math.sqrt(16);
        System.out.println(m1 + " " + m2 + " " + m3);

        // TODO:
        String str = "Z, Y, X, W, V, U, T, S, R, Q, P, O";
        StringTokenizer token = new StringTokenizer(str, ",");
        System.out.println("토큰의 개수: " + token.countTokens());
        System.out.println("토큰 목록:");
        while(token.hasMoreTokens()){
            System.out.println(token.nextToken());
        }
    }

}
