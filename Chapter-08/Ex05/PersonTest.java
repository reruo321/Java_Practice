package Ch08.Ex05;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PersonTest {
    public static void main(String [] args) throws AmountException, OutOfAmount {
        Scanner scan = new Scanner(System.in);
        PersonAccount [] acc = {
                new PersonAccount("김혜수", 10000),
                new PersonAccount("송광호", 200000),
                new PersonAccount("진미경", 5000),
                new PersonAccount("이정희", 7000)
        };
        String name, str;
        StringTokenizer token;
        boolean isExist;
        int menu;
        long money;
        while(true){
            System.out.println("이름[종료:quit], 입.출금[1/0], 금액 ?");
            isExist = false;
            str = scan.nextLine();
            token = new StringTokenizer(str);
            name = token.nextToken();
            menu = Integer.parseInt(token.nextToken());
            money = Long.parseLong(token.nextToken());

            if(name.equals("quit"))
                return;

            for(PersonAccount p : acc){
                if(p.getName().equals(name)){
                    isExist = true;
                    if(menu == 1)
                        p.deposit(money);
                    else if(menu == 0)
                        p.withdraw(money);
                    else
                        System.out.println("메뉴를 입.출금[1/0] 중 입력하십시오.");
                    System.out.println(p);
                }
            }
            if(!isExist)
                System.out.println(name + "의 계좌는 존재하지 않습니다.");
        }
    }
}
