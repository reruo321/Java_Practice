package Ch07.Ex01;

public abstract class Flying {
    public int wingcnt = 2;
    public boolean wheelstat = true;
    public abstract void takeOff();
    public abstract void landing();
    public void output(){
        System.out.println(wingcnt + " " + wheelstat);
    }
}
