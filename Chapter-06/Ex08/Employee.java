package Ch06.Ex08;

public class Employee {
    String name;
    String no;
    Employee(String name, String no){
        this.name = name;
        this.no = no;
    }
    public String toString(){
        return String.format("이름: %s, 사원번호: %s", name, no);
    }
    long earnings(){
        return 0;
    }
}
