package Ch14.Ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static java.lang.System.exit;

public class JDBCTableTest {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Connection con = null;
    String url;
    String id;
    String pw;
    Statement st;
    ResultSet rs;
    public JDBCTableTest(String url, String id, String pw){
        this.url = url;
        this.id = id;
        this.pw = pw;
    }
    public void connectDB(){
        try {
            con = DriverManager.getConnection(url, id, pw);
        } catch(Exception e){ e.printStackTrace(); }
    }
    public void consoleMenu() {
        String str;
        int i;
        int n;
        try{
            System.out.println("1. 테이블생성\t2.데이터입력\t3.테이블조회\t4.테이블삭제\t5.종료");
            try {
                i = Integer.parseInt(reader.readLine());
            } catch(NumberFormatException e){ i = 0; }
            switch(i) {
                case 1:
                    System.out.println("입력 예: create table table_name(field_name1 char(20), field_name2 int, ...)");
                    str = reader.readLine();
                    create(str);
                    break;
                case 2:
                    System.out.println("입력 예: insert into table_name values ('value1', value2, ...)");
                    str = reader.readLine();
                    insert(str);
                    break;
                case 3:
                    System.out.println("입력 예: select * from table_name");
                    str = reader.readLine();
                    System.out.print("테이블 컬럼의 개수는? ");
                    try {
                        n = Integer.parseInt(reader.readLine());
                        if (n < 0)
                            throw new Exception();
                        select(str, n);
                    } catch (Exception e) {
                        System.err.println("? 테이블조회 실패");
                    }
                    break;
                case 4:
                    System.out.println("입력 예: drop table table_name");
                    str = reader.readLine();
                    drop(str);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    exit(0);
                default:
                    System.out.println("숫자 1~5 중 입력하십시오.");
                    break;
            }
        } catch(IOException e){ e.printStackTrace(); }
    }
    private void create(String str){
        try {
            st = con.createStatement();
            st.executeUpdate(str);
            st.close();
            System.out.println("테이블이 생성되었습니다.");
        } catch(Exception e){ System.err.println("테이블생성 오류"); }
    }
    private void insert(String str){
        try {
            st = con.createStatement();
            st.executeUpdate(str);
            st.close();
            System.out.println("데이터가 입력되었습니다.");
        } catch(Exception e){ System.err.println("데이터입력 오류"); }
    }
    private void select(String str, int n){
        try {
            st = con.createStatement();
            rs = st.executeQuery(str);
            int max = rs.getMetaData().getColumnCount();   // If the input number to select is bigger than the number of the table column, it just selects all columns without error.
            if(n > max)
                n = max;
            while(rs.next()){
                for(int i=1; i<=n; i++)
                    System.out.print(rs.getString(i) + "\t");
                System.out.println();
            }
            st.close();
            rs.close();
        } catch(Exception e){ System.err.println("테이블조회 오류"); }
    }
    private void drop(String str){
        try {
            st = con.createStatement();
            st.executeUpdate(str);
            st.close();
            System.out.println("테이블이 삭제되었습니다.");
        } catch(Exception e){ System.err.println("테이블삭제 오류"); }
    }
    public static void main(String [] args){
        JDBCTableTest jdbc = new JDBCTableTest("jdbc:mysql://localhost/jdbcexample3?", "root", "password");
        jdbc.connectDB();
        while(true)
            jdbc.consoleMenu();
    }
}
