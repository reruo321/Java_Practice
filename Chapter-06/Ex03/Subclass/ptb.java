package Ch06.Ex03.Subclass;
import Ch06.Ex03.Parent.*;

public class ptb extends Parent {
    public void outxy(){
        System.out.println(x);
//        System.out.println(y); // Error!
    }
}
