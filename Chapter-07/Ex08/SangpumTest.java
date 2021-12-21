package Ch07.Ex08;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SangpumTest {
    private SangpumRec sr = null;
    private SangpumList sl = null;
    private boolean job = true;
    private Scanner scn;
    private Iterator it;
    private String name = null;   // oops, I didn't use these but works well anyway.
    private long danga = 0;
    private String date = null;
    private int count = 0;

    public static void main(String [] args){   // I programmed the main method by myself.
        SangpumTest sangpum = new SangpumTest();
        sangpum.sl = new SangpumList();
        sangpum.scn = new Scanner(System.in);

        class SangpumSystem{
            public void selectMenu(){
                int option;
                while(true) {
                    System.out.print("\n상품등록(1), 검색(2), 종료(3).. ");
                    option = sangpum.scn.nextInt();
                    sangpum.scn.nextLine();

                    switch (option) {
                        case 1:
                            sangpumInput();
                            break;
                        case 2:
                            sangpumRead();
                            break;
                        case 3:
                            System.out.println("작업종료");
                            return;
                        default:
                            System.out.println("다시 입력하십시오.");
                            break;
                    }
                }
            }
            public void sangpumInput(){
                System.out.println("상품이름, 구입일자, 단가, 수량입력");
                String str = sangpum.scn.nextLine();
                StringTokenizer token = new StringTokenizer(str, " ");
                SangpumRec newRec = new SangpumRec(token.nextToken(), token.nextToken(), Long.parseLong(token.nextToken()), Integer.parseInt(token.nextToken()));
                sangpum.sl.addlstSangpumRec(newRec);
            }
            public void sangpumRead(){
                System.out.print("상품이름.. ");
                String str = sangpum.scn.nextLine();
                for(int i=0; i < sangpum.sl.getN(); i++){
                    if(str.equals(sangpum.sl.getSangpumRec(i).getName())){
                        sangpum.sr = sangpum.sl.getSangpumRec(i);
                        System.out.println("구입일자: " + sangpum.sr.getDate());
                        System.out.println("상품이름: " + sangpum.sr.getName() + ", 단가: " + sangpum.sr.getDanga() + ", 수량: " + sangpum.sr.getCount());
                        return;
                    }
                }
                System.out.println("상품을 찾을 수 없습니다.");
            }
        }
        SangpumSystem ss = new SangpumSystem();
        ss.selectMenu();
    }
}
