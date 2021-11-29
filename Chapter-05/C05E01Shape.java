public class C05E01Shape {
    int width;
    int height;
    String color;

    int calArea(){
        return width*height;
    }
    int calRound(){
        return 2*(width+height);
    }
    void setColor(String str){
        color = str;
    }
    int getWidth(){
        return width;
    }
    int getHeight(){
        return height;
    }
    String getColor(){
        return color;
    }
    void draw(){
        System.out.println("도형을 그린다.");
    }
}
