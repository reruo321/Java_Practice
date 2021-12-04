package myPackage.practice04;

class Point{
    int x;
    int y;
    Point(){
        this(0, 0);
    }
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.format("점의 좌표: (%d, %d)", x, y);
    }
    void moveX(int a){
        x += a;
    }
    void moveY(int b){
        y += b;
    }
}

public class PointTest {
    public static void main(String [] args){
        Point p = new Point(100, 150);
        System.out.println(p);
        p.moveX(-10);
        p.moveY(5);
        System.out.println(p);
    }
}
