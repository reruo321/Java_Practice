package Ch06.Ex01;

public class PointNoConstructor {
    int x;
    int y;/*
    public PointNoConstructor(){
        x = 10;
        y = 20;
    }*/
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.format("NoConstructor 슈퍼클래스: ( %d, %d )\n", x, y);
    }
}
