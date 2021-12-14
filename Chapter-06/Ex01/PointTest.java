package Ch06.Ex01;

public class PointTest extends Point {
    int x;
    int y;
    public PointTest(int x, int y, int a, int b){
        super.x = x;   // = super(x, y)
        super.y = y;
        this.x = a;
        this.y = b;
    }
    public void setXY(int x, int y){
        super.setXY(x, y);
    }
    public String toString(){
        return super.toString() + "서브클래스: ( " + this.x + ", " + this.y + " )\n";
    }

    public static void main(String [] args){
        PointTest pt = new PointTest(10, 20, 30, 40);
        System.out.print(pt);
        pt.setXY(100, 120);
        System.out.print(pt);
    }

}
