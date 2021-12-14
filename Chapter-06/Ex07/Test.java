package Ch06.Ex07;

public class Test extends A {
    public static void OutputStatic(){
        System.out.println("Test static method");
    }
    public void Output(){
        System.out.println("Test method");
    }

    public static void main(String [] args){
        A ref = new Test();
        ref.OutputStatic();
        ref.Output();
    }
}
