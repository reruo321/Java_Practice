package Ch06.Ex08;

public class RegEmployee extends Employee{
    String dept;
    long regpay;
    String regtitle;
    RegEmployee(String name, String no, String dept, long regpay, String regtitle){
        super(name, no);
        this.dept = dept;
        this.regpay = regpay;
        this.regtitle = regtitle;
    }
    public String toString(){
        return super.toString() + ", 부서: " + dept + ", 담당업무: " + regtitle + ", ";
    }
    long earnings(){
        return regpay + 10;
    }
}
