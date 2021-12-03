public class Student {
    String name;
    int age;
    String hobby;
    Student(String name, int age, String hobby){
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
    public String toString(){
        String str = "";
        str += "이름: " + name + "\n나이: " + age + "\n취미: " + hobby;
        return str;
    }
}
