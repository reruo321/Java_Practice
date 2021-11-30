public class C05E03Person {
    String name;
    int age;
    public C05E03Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return String.format(" name: %s, age: %d\n", name, age);
    }
}
