public class Ch05Ex05Global {
    static C05E03Person person;
    static int score = 70;
    public static void CallOne(){
        System.out.print("CallOne( ) | score: " + score + " " + person);
        score = 80;
        person.name = "박미정";
        person.age = 25;
        System.out.print("CallOne( ) | score: " + score + " " + person);
    }
    public static void main(String [] args){
        person = new C05E03Person("홍길동", 23);
        System.out.print("   main( ) | score: " + score + " " + person);
        CallOne();
        System.out.print("   main( ) | score: " + score + " " + person);
    }
}
