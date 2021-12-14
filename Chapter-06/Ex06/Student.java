package Ch06.Ex06;

public class Student {
    static int serialNum;
    String major;
    String name;
    Student(String major, String name){
        this.major = major;
        this.name = name;
        serialNum++;
    }
    static int getSerial(){
        return serialNum;
    }
}
