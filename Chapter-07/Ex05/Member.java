package Ch07.Ex05;

public class Member {
    private String name;
    private String tel;
    public Member(String name, String tel){
        this.name = name;
        this.tel = tel;
    }
    public String toString(){
        return String.format("이름: %s, 전화번호: %s", name, tel);
    }
}
