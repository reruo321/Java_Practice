package Ch07.Ex02;

public class Electronics implements Product {
    public long getPrice(int id){
        if(id == 1)
            return 1000;
        else
            return 2000;
    }
    public void PrintName(){
        System.out.println("electrical parts...");
    }
}
