package Ch07.Ex06;

import Ch07.Ex05.Member;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMemberTest {
    public static LinkedList<Member> ll;

    public static void main(String [] args){
        Member [] mArr = {new Member("박선영", "123-1212"), new Member("박우영", "111-1021"), new Member("최지우", "133-5675")};
        ll = new LinkedList<Member>();
        ll.add(mArr[0]);
        ll.add(mArr[1]);
        ll.add(mArr[2]);

        System.out.println("   전방향 순환");
        ListIterator<Member> it = ll.listIterator();
        while(it.hasNext()){
            System.out.println((Member) it.next());
        }

        System.out.println("   역방향 순환");
        ListIterator<Member> rit = ll.listIterator(ll.size());
        while(rit.hasPrevious()){
            System.out.println((Member) rit.previous());
        }
    }
}
