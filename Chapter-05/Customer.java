import com.sun.org.apache.xpath.internal.operations.Or;
import myPackage.Ch05Ex11.app.*;

import java.util.Scanner;

public class Customer {
    String Name;
    String Phone;
    Order order;
    int n;
    Scanner scan;

    Customer(){
        this.scan = new Scanner(System.in);
    }
    void input(){
        while(true) {
            System.out.println("이름 (종료: q 또는 Q), 전화번호..");
            Name = scan.next();
            if (Name.equals("q") || Name.equals("Q")) {
                System.out.println("주문 종료..");
                System.exit(0);
            }
            Phone = scan.next();

            System.out.println("날짜, 배송기간, 항목수..");
            String date = scan.next();
            int day = scan.nextInt();
            n = scan.nextInt();
            order = new Order(n);
            order.setDate(date, day);

            createOrder();

            System.out.println("\n\t\t주문서");
            System.out.println("이름: " + Name + ", 전화번호: " + Phone + "\n" + order);
        }
    }
    void createOrder(){
        String name;
        String unit;
        System.out.println("상품명, 단위..");
        for(int i=0; i<n; i++) {
            name = scan.next();
            unit = scan.next();
            order.addOrderline(name, unit);
        }
    }
}
