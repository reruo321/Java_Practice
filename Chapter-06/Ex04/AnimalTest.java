package Ch06.Ex04;

public class AnimalTest {
    public static void main(String [] args){
        Cat cat = new Cat("나비", 1);
        System.out.print("Cat: " + cat + ", ");
        cat.bark();
        Dog dog = new Dog("핑클", 2);
        System.out.print("Dog: " + dog + ", ");
        dog.bark();
        Animal acat = new Cat("초롱이", 1);
        System.out.print("Cat: " + acat.name + ", ");
        acat.bark();
    }
}
