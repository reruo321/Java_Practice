package Ch14.Ex02;

import java.sql.*;

public class JDBCExample {
    Connection con = null;
    String server, db_name, userid, password;
    Statement st;
    ResultSet rs;
    public JDBCExample(String server, String db_name, String userid, String password){
        this.server = server;
        this.db_name = db_name;
        this.userid = userid;
        this.password = password;
    }
    public void connectJDBC(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "" + "?", userid, password);
            System.out.println("Connected!");
        } catch(SQLException e){ e.printStackTrace(); }
    }
    public void checkDB(){
        try{
            rs = con.getMetaData().getCatalogs();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            while(rs.next()){
                for(int i=1; i<=count; i++) {
                    if (rs.getString(i).equals(db_name)) {
                        System.out.println("The database " + db_name + " exists. Loading...");
                        con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + db_name + "?", userid, password);
                        return;
                    }
                }
            }
            rs.close();
            createDB();
        } catch(Exception e){ System.err.println("Failed to check the database"); }
    }
    public void createDB(){
        try{
            st = con.createStatement();
            st.execute("CREATE DATABASE " + db_name);
            System.out.println("Created a new database");
            st.close();
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + db_name + "?", userid, password);
        } catch(Exception e){ System.err.println("Failed to create a database"); }
    }
    public void createTable(){
        try{
            rs = con.getMetaData().getTables(con.getCatalog(), null, "%", null);
            while(rs.next())
                System.out.println(rs.getString(3));
            rs.close();
            st = con.createStatement();
            st.executeUpdate("create table emp(name char(20), job char(20))");
            System.out.println("Created a table EMP");
            st.close();
        } catch(Exception e){ System.err.println("Failed to create a table"); }
    }
    public void insertDB(String name, String job){
        try{
            st = con.createStatement();
            st.executeUpdate("insert into emp values('" + name + "','" + job + "')");
            System.out.println("Inserted an information on " + name);
            st.close();
        } catch(Exception e){ System.err.println("Failed to insert a value"); }
    }
    public void searchDB(){
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from emp");
            while(rs.next()){
                String name = rs.getString(1);
                String job = rs.getString(2);
                System.out.println(name + " " + job);
            }
            rs.close();
            st.close();
        } catch(Exception e){ System.err.println("Failed to search database"); }
    }
    public static void main(String [] args) {
        JDBCExample jdbc = new JDBCExample("localhost", "jdbcexample", "root", "password");
        jdbc.connectJDBC();
        jdbc.checkDB();
        jdbc.createTable();
        jdbc.insertDB("John", "Singer");
        jdbc.insertDB("Hong", "Student");
        jdbc.searchDB();
    }
}
