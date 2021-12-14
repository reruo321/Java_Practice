package Ch06.Ex05;

public class OvershadowTest {
    public static void main(String [] args){
        System.out.println("xc, xl 변수의 데이터형: Xclass ");
        Xclass xc = new Xclass();
        System.out.println(" xc reference Xclass: x " + xc.x);
        xc.Output();
        Xclass xl = new Yclass();
        System.out.println(" xl reference Yclass: x " +xl.x);
        xl.Output();
        System.out.println("\nyc 변수의 데이터형: Yclass ");
        Yclass yc = new Yclass();
        System.out.println(" yc reference Yclass: x " + yc.x + ", " + yc.y);
        yc.Output();
        yc.test();
        yc.Xrun();
        System.out.println(" ((Xclass)yc).x: " + ((Xclass)yc).x);
    }
}
