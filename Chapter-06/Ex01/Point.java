package Ch06.Ex01;

public class Point {
    int x;
    int y;
    public Point(){
        this.x = this.y = 0;
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.format("슈퍼클래스: ( %d, %d )\n", x, y);
    }
}
