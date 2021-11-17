import java.io.*;
public class Ch02Ex03BufferedReader {
    public static void main(String [] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(in);

        System.out.print("당신의 집 주소는?: ");
        String address = rd.readLine();
        System.out.println("집 주소는 " + address + "입니다.");
        System.out.print("당신의 성별은? (M 또는 F): " );
        int sex = System.in.read();
        System.out.println("성별은 " + (char)sex + "입니다.");

    }
}
