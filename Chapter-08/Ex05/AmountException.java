package Ch08.Ex05;

public class AmountException extends Exception {
    public AmountException(){
        super("예금액이 올바르지 않습니다.");
    }
}
