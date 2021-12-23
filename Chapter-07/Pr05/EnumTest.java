package Ch07.Pr05;

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumTest {
    public static void main(String [] args){
        for(Day d : Day.values()){
            System.out.println(d);
        }
    }
}
