package Ch07.Ex02;

public class Shop {
    static Electronics elec;
    static Clothes clothes;
    public static void init(){
        elec = new Electronics();
        clothes = new Clothes();
    }
    public static void orderList(Product item){
        item.PrintName();
        System.out.println("주문: " + item.MAKER + " 전화번호: " + item.TEL);
        System.out.println("품목별 가격 (만원): " + item.getPrice(1));
    }
    public static void main(String [] args){
        init();
        orderList(elec);
        orderList(clothes);
    }
}
