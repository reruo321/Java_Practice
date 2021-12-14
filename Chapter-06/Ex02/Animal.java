package Ch06.Ex02;

public class Animal {
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
