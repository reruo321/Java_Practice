package Ch06.Ex08;

public class TempEmployee extends Employee {
    String hdept;
    long temphour;
    TempEmployee(String name, String no, String hdept, long temphour){
        super(name, no);
        this.hdept = hdept;
        this.temphour = temphour;
    }
    public String toString(){
        return super.toString() + ", 부서: " + hdept + ", 근무시간수: " + temphour + ", ";
    }
    long earnings(){
        return temphour * 3;
    }
}
