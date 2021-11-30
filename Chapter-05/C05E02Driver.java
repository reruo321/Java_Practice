public class C05E02Driver {
    String name;
    String position;

    public C05E02Driver(){
        this("김상진", "사장");
    }
    public C05E02Driver(String name, String position){
        this.name = name;
        this.position = position;
    }
    public String toString(){
        return String.format("이름: %s, 직위: %s\n", name, position);
    }
}
