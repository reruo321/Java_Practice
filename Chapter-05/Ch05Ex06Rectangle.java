public class Ch05Ex06Rectangle {
    Point p1;
    Point p2;
    public Ch05Ex06Rectangle(int a, int b, int c, int d){
        p1 = new Point(a, b);
        p2 = new Point(c, d);
    }
    public String toString(){
        return String.format("점1: %s, 점2: %s\n", p1, p2);
    }
    public void draw(){
        System.out.println("사각형 그리기:\n" + this);
    }
    public void moveRect(int x1, int y1, int x2, int y2){
        p1.x += x1;
        p1.y += y1;
        p2.x += x2;
        p2.y += y2;
    }
    public static void main(String [] args){
        Ch05Ex06Rectangle rectangle = new Ch05Ex06Rectangle(10, 10, 150, 150);
        rectangle.draw();
        rectangle.moveRect(2, 2, -3, -3);
        rectangle.draw();
    }
}
