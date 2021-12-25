package Ch08.Ex05;

public class OutOfAmount extends Exception {
    public OutOfAmount(){
        super("잔액이 부족합니다.");
    }
}
