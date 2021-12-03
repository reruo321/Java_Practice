package myPackage.Ch05Ex11.app;

public class Orderline {
    String name;
    String unit;
    Orderline(String name, String unit){
        this.name = name;
        this.unit = unit;
    }
    public String toString(){
        return String.format("%6s %6s\n", name, unit);
    }
}
