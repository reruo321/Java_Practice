public class C05E04Scope {
    int a;
    public void oneMethod(int b){
        int a = 30;
        System.out.println("oneMethod a : " + a + ", parameter b : " + b);
        a += b;
        System.out.println("oneMethod a : " + a);
    }
    public void twoMethod(){
        a++;
        System.out.println("twoMethod a : " + a);
    }
}
