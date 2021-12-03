package myPackage.Ch05Ex11.app;

import java.util.Scanner;

public class Order {
    String date;
    int day;
    int n;
    Orderline [] orderline;

    public Order(int n){
        this.orderline = new Orderline[n];
    }
    public void setDate(String date, int day){
        this.date = date;
        this.day = day;
    }
    public void addOrderline(String name, String unit){
        orderline[n++] = new Orderline(name, unit);
    }
    public String toString(){
        String str = String.format("주문일자: %s\n배송기간: %d일\n\n%6s %6s\n", date, day, "품명", "단위");
        for(int i=0; i<n; i++)
        str += orderline[i];
        return str;
    }
}
