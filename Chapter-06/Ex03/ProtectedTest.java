package Ch06.Ex03;

import Ch06.Ex03.Parent.*;
import Ch06.Ex03.Subclass.*;

public class ProtectedTest {
    public static void main(String [] args){
        pta a = new pta();
        a.printxy();
        ptb b = new ptb();
        b.outxy();
    }
}
