package Ch12.Ex02;

import static java.lang.Thread.sleep;

public class RunnableTest implements Runnable {
    private int count = 0;
    String name;
    public RunnableTest(String name){
        this.name = name;
        System.out.println(name + " 이 생성되었습니다.");
    }
    public void run(){
        while(count < 3){
            System.out.println(name + " Count = " + count++);
            try{
                sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(name + " 이 멈추었습니다.");
    }
    public static void main(String [] args){
        Thread thr1 = new Thread(new RunnableTest("Thread-1"));
        Thread thr2 = new Thread(new RunnableTest("Thread-2"));
        thr1.start();
        thr2.start();
    }
}
