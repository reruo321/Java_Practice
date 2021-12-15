package Ch06.Pr01;

public class Customer {
    public Rental [] rentalList;
    public String name;
    public String address;
    public String tel;

    public Customer(String name, String address, String tel){
        this.name = name;
        this.address = address;
        this.tel = tel;
    }
    public String changeAdd(){
        return address;
    }
    public String toString(){
        return String.format("◆ %s 고객님 (주소: %s, 전화번호: %s) ", name, address, tel);
    }
}
