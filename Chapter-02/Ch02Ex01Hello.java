public class Ch02Ex01Hello {
    public static void main(String args[]){
        System.out.println("Hello\nWorld!");
        System.out.println("\t\"I'll use \\t, \\b, \\r for this example.\"");
        System.out.println("Original Example:\n\t0123456789ABCDE");
        System.out.println("\\b x "+3+":\n\t0123456789\b\b\bABCDE");
        System.out.println("\\r:\n"+"\t0123456789\rABCDE");
    }
}
