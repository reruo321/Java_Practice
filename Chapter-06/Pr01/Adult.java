package Ch06.Pr01;

public class Adult extends Customer{
    public Adult(String name, String address, String tel){
        super(name, address, tel);
    }
    public String toString(){
        return super.toString() + "비고: 어른 ◆\n";
    }
}
