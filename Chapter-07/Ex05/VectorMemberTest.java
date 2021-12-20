package Ch07.Ex05;

import java.util.Vector;

public class VectorMemberTest {
    public static void main(String [] args){
        Member m1 = new Member("박선영", "123-1212");
        Member m2 = new Member("박우영", "111-1021");
        Member m3 = new Member("최지우", "133-5675");

        Vector<Member> vec = new Vector<Member>(5, 5);
        vec.add(m1);
        vec.add(m2);
        vec.add(m3);

        System.out.println("   등록 회원 리스트");
        for(Member m : vec)
            System.out.println(m);

        System.out.println("\n두번째 회원: " + vec.get(1));
        System.out.println("\n요소의 개수: " + vec.size());

        if(vec.contains(m3))
            System.out.println("\n최지우의 인덱스: " + vec.indexOf(m3));
        else
            System.out.println("\n최지우라는 회원이 없습니다.");

        vec.remove(m2);
        System.out.println("\n   회원 리스트");
        for(Member m : vec)
            System.out.println(m);
    }
}
