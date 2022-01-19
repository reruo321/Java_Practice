package Ch12.Ex04;

public class PriorityTest extends Thread {
    private int count = 0;
    public PriorityTest(String s){
        super(s);
    }
    public void run() {
        while(count < 5){
            count++;
            System.out.print(getName() + " → ");
            try{
                sleep(1000);
            } catch(InterruptedException e){}
        }
    }

    public static void main(String [] args){
        PriorityTest thr1 = new PriorityTest("MIN");
        thr1.setPriority(Thread.MIN_PRIORITY);
        PriorityTest thr2 = new PriorityTest("MAX");
        thr2.setPriority(Thread.MIN_PRIORITY);
        thr1.start();
        thr2.start();
    }
}
