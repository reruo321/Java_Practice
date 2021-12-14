package Ch06.Ex04;

public class Animal {
    String name;
    int age;
    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    void bark(){
        System.out.println("???: ?????");
    }
    public String toString(){
        return String.format("이름: %s, 나이: %d", name, age);
    }
}
