package Ch07.Ex03;

public class LocalClass {
    public static void main(String [] args){
        final int y = 5;
        class InnerClass{
            String str = "Local class..";
            int x = 100;
            public void Output(){
                System.out.println(str + " " + x + " " + y);
            }
        }
        InnerClass a = new InnerClass();
        a.Output();
    }
}
