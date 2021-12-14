package Ch06.Ex02;

public class AnimalTest {
    public static void main(String [] args){
        Animal a = new Animal("바둑이", 1);
        int age = a.getAge();
//        a.name = "복돌이";   // Private field. Error!
//        a.age = 2;   // Private field. Error!
          a.setAge(3);
          a.setName("상근이");
          String name = a.getName();
          System.out.println(name + " " + a.getAge());
    }
}
