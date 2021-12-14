package Ch06.Ex01;

public class PointTestNoConstructor extends PointNoConstructor {
    int x;
    int y;
    public void setXY(int x, int y){
        super.setXY(x, y);
    }
    public String toString(){
        return super.toString() + "NoConstructor 서브클래스: ( " + this.x + ", " + this.y + " )\n";
    }

    public static void main(String [] args){
        PointTest pt = new PointTest(11, 22, 33, 44);
        System.out.print(pt);
        pt.setXY(123, 456);
        System.out.print(pt);
    }
}
