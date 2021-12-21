package Ch07.Ex08;

public class SangpumIterator implements Iterator {
    private SangpumList sl;
    private int n;
    public SangpumIterator(SangpumList sl){
        this.sl = sl;
        this.n = 0;
    }
    public boolean hasNext(){
        return (n < sl.getN());
    }
    public Object next(){
        SangpumRec sr = sl.getSangpumRec(n);
        n++;
        return sr;
    }
}
