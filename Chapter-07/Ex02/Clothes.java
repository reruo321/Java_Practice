package Ch07.Ex02;

public class Clothes  implements Product {
    public long getPrice(int id){
        if(id == 1)
            return 100;
        else
            return 10;
    }
    public void PrintName(){
        System.out.println("clothes...");
    }
}
