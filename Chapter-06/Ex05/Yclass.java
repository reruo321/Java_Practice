package Ch06.Ex05;

import java.sql.SQLSyntaxErrorException;

public class Yclass extends Xclass {
    int x;
    int y;
    Yclass(){
        x = 200;
        y = 300;
    }
    void Output(){
        System.out.println("Y class");
    }
    void test(){
        System.out.println("super: x " + super.x);
        System.out.println("this: x " + this.x + ", y " + this.y);
        System.out.print(" super.Output( ): ");
        super.Output();
        System.out.print(" this.Output( ): ");
        this.Output();
    }
    void Xrun(){
        System.out.println("perform xclass..");
    }
}