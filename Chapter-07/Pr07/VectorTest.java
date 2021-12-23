package Ch07.Pr07;

import java.util.Scanner;
import java.util.Vector;

class Student {
    private String student_id;
    private String name;
    private int score1, score2, score3;
    public Student(String student_id, String name, int score1, int score2, int score3){
        this.student_id = student_id;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public String toString(){
        return String.format("▶ 학번: %s, 이름: %s ◀\n과목1: %d점, 과목2: %d점, 과목3: %d점\n", student_id, name, score1, score2, score3);
    }
    public String getStudent_id(){
        return student_id;
    }
    public String getName(){
        return name;
    }
}

public class VectorTest {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str;
        Vector<Student> studentVector = new Vector<Student>();
        boolean isFound;
        studentVector.add(new Student("20101234", "홍길동", 60, 70, 80));
        studentVector.add(new Student("20123456", "김영희", 50, 70, 65));
        studentVector.add(new Student("20167890", "박철수", 90, 100, 80));

        while(true) {
            System.out.print("검색할 학번 또는 이름을 입력하십시오. q를 입력하면 종료합니다. ");
            str = scan.nextLine();
            isFound = false;
            if (str.equals("q")){
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            for (Student s : studentVector) {
                if (s.getStudent_id().equals(str) || s.getName().equals(str)) {
                    System.out.println(s);
                    isFound = true;
                }
            }
            if(!isFound)
                System.out.println("다음을 찾을 수 없습니다: " + str);
        }
    }
}
