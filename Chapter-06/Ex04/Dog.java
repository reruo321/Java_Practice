package Ch06.Ex04;

public class Dog extends Animal {
    Dog(String name, int age){
        super(name, age);
    }
    void bark(){
        System.out.println("멍멍..멍멍~");
    }
}
