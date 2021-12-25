package Ch08.Pr02;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

abstract class SangpumException extends Exception {
    public SangpumException(String s){
        super(s);
    }
}

class SangpumInventoryException extends SangpumException{
    public SangpumInventoryException(){
        super("재고량이 부족합니다.");
    }
}

class SangpumNameException extends SangpumException{
    public SangpumNameException(){
        super("상품명이 공백입니다.");
    }
}

class SangpumNException extends SangpumException{
    public SangpumNException(){
        super("수량이 양수가 아닙니다.");
    }
}

class f{
    static int findSangpum(Vector<Sangpum> in, String name){
        int i = 0;
        for(Sangpum s : in){
            if(s.getName().equals(name))
                return i;
            i++;
        }
        return -1;
    }
}

public class SangpumHandlerTest {
    public static void main(String [] args) throws SangpumException {
        Scanner scan = new Scanner(System.in);
        String str, menu, name;
        int n;
        StringTokenizer token;
        Vector<Sangpum> inv = new Vector<Sangpum>();

        while(true) {
            System.out.println("메뉴[new/in/out] 상품명 수량 순서대로 입력하십시오. 프로그램을 종료하려면 quit만 입력하십시오.");
            str = scan.nextLine();
            token = new StringTokenizer(str);
            if (str.equals("quit"))
                return;
            if (token.countTokens() != 3)
                System.out.println("입력정보가 부족합니다. 다시 입력하십시오.");
            else {
                try {
                    menu = token.nextToken();
                    name = token.nextToken();
                    n = Integer.parseInt(token.nextToken());

                    if (name.equals(""))
                        throw new SangpumNameException();
                    if (n < 0)
                        throw new SangpumNException();
                    int index = f.findSangpum(inv, name);
                    if (menu.equals("new")) {
                        if(index >= 0){
                            System.out.println("추가하려는 상품 데이터가 이미 존재합니다.");
                            System.out.println(inv.elementAt(index));
                        }
                        else{
                            inv.add(new Sangpum(name, n));
                            System.out.println(inv.lastElement());
                        }
                    }
                    if (menu.equals("in")) {
                        if (index < 0) {
                            System.out.println("존재하지 않는 상품명입니다.");
                        } else {
                            inv.elementAt(index).sangpumIn(n);
                            System.out.println(inv.elementAt(index));
                        }
                    } else if (menu.equals("out")) {
                        if (index < 0) {
                            System.out.println("존재하지 않는 상품명입니다.");
                        } else {
                            inv.elementAt(index).sangpumOut(n);
                            System.out.println(inv.elementAt(index));
                        }
                    } else
                        System.out.println("메뉴를 new/in/out 중 입력하십시오.");
                } catch (SangpumNameException | SangpumNException | NumberFormatException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
