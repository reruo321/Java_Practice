public class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moveX(int a){
        x += a;
    }
    public void moveY(int b){
        y += b;
    }
    public String toString(){
        return String.format(" ( %d, %d ) ", x, y);
    }
}
