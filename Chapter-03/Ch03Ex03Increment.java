public class Ch03Ex03Increment {
    public static void main(String [] args){
        int x, y;
        x = y = 10;
        System.out.println("증가 연산자의 경우\n");
        System.out.println("후위 증가의 값: " + x++);
        System.out.println("x변수의 현재값: " + x);
        System.out.println("전위 증가의 값: " + ++x);
        System.out.println("x변수의 현재값: " + x + "\n");

        System.out.println("감소 연산자의 경우\n");
        System.out.println("후위 감소의 값: " + y--);
        System.out.println("y변수의 현재값: " + y);
        System.out.println("전위 감소의 값: " + --y);
        System.out.println("y변수의 현재값: " + y + "\n");
    }
}
