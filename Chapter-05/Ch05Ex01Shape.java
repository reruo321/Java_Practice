public class Ch05Ex01Shape {
    public static void main(String [] args){
        C05E01Shape shape = new C05E01Shape();
        shape.width = 20;
        shape.height = 100;
        shape.color = "red";
        int w = shape.calArea();
        int h = shape.calRound();
        shape.setColor("yellow");
        System.out.println("가로: " + shape.getWidth() + " 세로: " + shape.getHeight() + "\n도형 색상: " + shape.getColor());
        System.out.println("면적: " + w + " 둘레: " + h);
        shape.draw();
    }
}
