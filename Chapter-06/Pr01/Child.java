package Ch06.Pr01;

public class Child extends Customer{
    public Child(String name, String address, String tel){
        super(name, address, tel);
    }
    public String toString(){
        return super.toString() + "비고: 어린이 ◆\n";
    }
}
