package Ch12.Ex01;

public class ThreadTest extends Thread {
    private int count = 0;
    public ThreadTest(){
        System.out.println(getName() + " 이 생성되었습니다.");
    }
    public void run(){
        while(count < 3){
            System.out.println(getName() + " Count = " + count++);
            try{
                sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();;
            }
        }
        System.out.println(getName() + " 이 멈추었습니다.");
    }
    public static void main(String [] args){
        ThreadTest thr1 = new ThreadTest();
        ThreadTest thr2 = new ThreadTest();
        thr1.start();
        thr2.start();
    }
}
