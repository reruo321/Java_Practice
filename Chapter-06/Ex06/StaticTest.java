package Ch06.Ex06;

public class StaticTest {
    public static void main(String [] args){
        Student s1 = new Student("소프트웨어공학", "이영미");
        Student s2 = new Student("컴퓨터통신", "박선영");
        Student s3 = new Student("인공지능", "김미화");
        System.out.println("serialNum 변수: " + Student.serialNum);
        System.out.println("인스턴스의 개수: " + Student.getSerial());
    }
}
