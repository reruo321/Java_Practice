package Ch06.Ex08;

public class Staff extends Employee {
    String title;
    long staffpay;
    Staff(String name, String no, String title, long staffpay){
        super(name, no);
        this.title = title;
        this.staffpay = staffpay;
    }
    public String toString(){
        return super.toString() + ", 직책: " + title + ", ";
    }
    long earnings(){
        return staffpay + 20;
    }
}
