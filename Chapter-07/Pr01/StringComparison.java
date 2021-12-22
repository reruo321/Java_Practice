package Ch07.Pr01;

import java.util.Scanner;

public class StringComparison {
    public static void main(String [] args){
        // TODO: Compare two String inputs. (The author wants to check if the programmer knows "how to use operator==". Maybe without equals()?)
        Scanner scan = new Scanner(System.in);
        System.out.print("첫번째 문자열을 입력하십시오. ");
        String str1 = scan.nextLine();
        System.out.print("두번째 문자열을 입력하십시오. ");
        String str2 = scan.nextLine();
        if(str1.length() != str2.length()) {
            System.out.println("다른 문자열입니다.");
            return;
        }
        else
            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)){
                    System.out.println("다른 문자열입니다.");
                    return;
                }
            }
            System.out.println("같은 문자열입니다.");
    }

}
