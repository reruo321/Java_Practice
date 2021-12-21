package Ch07.Ex08;

public class SangpumList {
    private SangpumRec[] sr;
    private int n = 0;
    public SangpumList(){
        sr = new SangpumRec[100];
    }
    public SangpumRec getSangpumRec(int n){
        return sr[n];
    }
    public int getN(){
        return n;
    }
    public void addlstSangpumRec(SangpumRec sang){
        sr[n] = sang;
        n++;
    }
    public Iterator iterator(){
        return (new SangpumIterator(this));
    }
}
