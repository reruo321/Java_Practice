package Ch07.Pr06;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String [] args){
        LinkedList<String> nation = new LinkedList<String>();
        nation.add("Korea");
        nation.add("USA");
        nation.add("Canada");
        nation.add("Russia");
        nation.add("China");
        nation.add("Japan");
        nation.add("UK");
        nation.add("France");
        ListIterator<String> it1 = nation.listIterator();
        System.out.println("전방향 순환");
        while(it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
        System.out.println("\n역방향 순환");
        ListIterator<String> it2 = nation.listIterator(nation.size());
        while(it2.hasPrevious()){
            System.out.print(it2.previous() + " ");
        }
    }
}
