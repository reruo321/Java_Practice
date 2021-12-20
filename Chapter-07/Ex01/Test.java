package Ch07.Ex01;

public class Test {
    public static void main(String [] args){
        Airplane air = new Airplane();
        air.takeOff();
        air.landing();
        Flying f;
        f = (Flying) air;
        f.takeOff();
        System.out.println(f.wheelstat + " " + f.wingcnt);
    }
}
