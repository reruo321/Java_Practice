package Ch12.Ex05;

class Machine{
    public synchronized void getDrink(String name, String item){
        System.out.println(name + "님");
        System.out.println(item + " 나왔습니다.");
    }
}

class User extends Thread{
    private String drink;
    private Machine m;
    public User(String name, String drink, Machine m){
        super(name);
        this.drink = drink;
        this.m = m;
    }
    public void run(){
        m.getDrink(getName(), drink);
        try{
            sleep(1000);
        } catch(InterruptedException e){ e.getStackTrace(); }
    }
}

public class VendingMachineExample {
    public static void main(String [] args){
        Machine t = new Machine();
        User user1 = new User("손님1", "콜라", t);
        User user2 = new User("손님2", "주스", t);
        User user3 = new User("손님3", "사이다", t);
        User user4 = new User("손님4", "물", t);
        User user5 = new User("손님5", "이온음료", t);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
    }
}
