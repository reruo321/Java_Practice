public class Ch05Ex03MethodArgs {
    public static void CallOne(int x, C05E03Person y){
        System.out.print("CallOne( ) |     x: " + x + y);

        x = 80;
        y.name = "박미정";
        y.age = 25;

        System.out.print("CallOne( ) |     x: " + x + y);
    }

    public static void main(String [] args){
        C05E03Person person = new C05E03Person("홍길동", 23);
        int score = 70;
        System.out.print("   main( ) | score: " + score + person);
        CallOne(score, person);
        System.out.print("   main( ) | score: " + score + person);
    }
}
