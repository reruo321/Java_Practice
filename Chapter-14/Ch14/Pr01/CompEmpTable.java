package Ch14.Pr01;

import java.sql.*;

public class CompEmpTable {
    Connection con = null;
    String url, dbname, id, pw;
    Statement st;
    ResultSet rs;
    public CompEmpTable(String dbname, String id, String pw){
        this.dbname = dbname;
        this.id = id;
        this.pw = pw;
    }
    public void connectDB(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + dbname + "?", id, pw);
        } catch(SQLException e){ System.err.println("Failed to connect the database"); }
    }
    public void createTable(){
        try{
            st = con.createStatement();
            st.executeUpdate("create table compemp(name char(20), dept char(20), title char(20))");
            st.close();
            System.out.println("Successfully created a new table.");
        } catch(SQLException e){ System.err.println("Failed to create a new table."); }
    }
    public void insertValue(String name, String dept, String title){
        try{
            st = con.createStatement();
            st.executeUpdate("insert into compemp values('" + name + "', '" + dept + "', '" + title + "')");
            st.close();
            System.out.println("Successfully inserted a new record.");
        } catch(SQLException e){ System.err.println("Failed to insert a new record."); }
    }
    public void selectAll(){
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from compemp");
            int n = rs.getMetaData().getColumnCount();
            while(rs.next()){
                for(int i=1; i<=n; i++)
                    System.out.print(rs.getString(i) + "\t");
                System.out.println();
            }
            rs.close();
            st.close();
        } catch(SQLException e){ System.err.println("Failed to select the values."); }
    }
    public void modifyValue(){
        try{
            st = con.createStatement();
            st.executeUpdate("update compemp set title = '대리' where name like '홍길동'");
            st.close();
            System.out.println("Successfully updated the value.");
        } catch(SQLException e){ System.err.println("Failed to update the value."); }
    }
    public static void main(String [] args){
        CompEmpTable comp = new CompEmpTable("jdbcproblem01", "root", "password");
        comp.connectDB();
        comp.createTable();
        comp.insertValue("김철수", "사업부", "대리");
        comp.insertValue("박영희", "홍보부", "사원");
        comp.insertValue("홍길동", "총무부", "사원");
        comp.insertValue("최바둑", "영업부", "임원");
        comp.selectAll();
        comp.modifyValue();
        comp.selectAll();
    }
}
