package Ch07.Ex01;

public class Airplane extends Flying{
    public void takeOff(){
        super.output();
        System.out.println("비행기 이륙");
        wheelstat = false;
    }
    public void landing(){
        super.output();
        System.out.println("비행기 착륙");
        wheelstat = true;
    }
}
