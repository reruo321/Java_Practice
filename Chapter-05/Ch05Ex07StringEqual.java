public class Ch05Ex07StringEqual {
    public static void main(String [] args){
        String str1 = new String("Good");
        String str2 = new String();
        str2 = "Good";
        System.out.println("new 연산자 변수 비교");
        System.out.println("참조변수 비교: " + (str1 == str2));
        System.out.println("참조내용 비교: " + (str1.equals(str2)));
        System.out.println("해쉬코드 str1: " + System.identityHashCode(str1) + ", str2: " + System.identityHashCode(str2));

        String stra = "Wow!";
        String strb = "Wow!";
        System.out.println("= 연산자 변수 비교");
        System.out.println("참조변수 비교: " + (stra == strb));
        System.out.println("참조내용 비교: " + (stra.equals(strb)));
        System.out.println("해쉬코드 stra: " + System.identityHashCode(stra) + ", strb: " + System.identityHashCode(strb));

    }
}
