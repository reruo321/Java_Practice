package Ch08.Pr02;

public class Sangpum {
    private String name;
    private int n;
    public Sangpum(String name, int n){
            this.name = name;
            this.n = n;
    }
    public void sangpumIn(int n){
        this.n += n;
    }
    public void sangpumOut(int n) throws SangpumInventoryException {
        try {
            if(this.n < n)
                throw new SangpumInventoryException();
            this.n -= n;
        }
        catch(SangpumInventoryException e){ System.out.println(e.toString()); }
    }
    public String getName(){
        return name;
    }
    public int getN(){
        return n;
    }
    public String toString(){
        return String.format("◆ 상품명: %s, 재고: %d개\n", name, n);
    }
}
