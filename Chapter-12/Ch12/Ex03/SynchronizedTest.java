package Ch12.Ex03;

class Calculation{
    private int sum;
//    public void sumFrom1ToN(int num){
    public synchronized void sumFrom1ToN(int num){
        sum = 0;
        for(int i=1; i<=num; i++){
            sum += i;
            System.out.println(Thread.currentThread().getName() + "의 1~" + i + "까지의 합은 " + sum);
            try{
                Thread.sleep((int) (Math.random() * 100));
            } catch(InterruptedException e){}
        }
    }
}

class SyncThread extends Thread{
    private Calculation cal;
    private int num;
    public SyncThread(String name, Calculation cal, int num){
        super(name);
        this.cal = cal;
        this.num = num;
        System.out.println(getName() + "가 생성되었습니다.");
    }
    public void run(){
        cal.sumFrom1ToN(num);
        System.out.println(getName() + "가 종료되었습니다.");
    }
}

public class SynchronizedTest {
    public static void main(String [] args){
        Calculation sum = new Calculation();
        SyncThread a = new SyncThread("스레드 A", sum, 5);
        SyncThread b = new SyncThread("스레드 B", sum, 3);
        a.start();
        b.start();
    }
}
