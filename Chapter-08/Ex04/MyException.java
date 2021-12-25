package Ch08.Ex04;

public class MyException extends Exception {
    public MyException(){
        super("메뉴 선택의 값은 1~3이어야 합니다.");
    }
}
