package Ch14.Ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAccessExample {
    public static void main(String [] args){
        Connection con = null;
        String YOUR_SERVER = "localhost";
        String DATABASE_NAME = "";
        String USER_ID = "root";
        String USER_PW = "password";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch(Exception e){ System.err.println("OOPS!"); }

        try{
            con = DriverManager.getConnection("jdbc:mysql://" + YOUR_SERVER + "/" + DATABASE_NAME + "?", USER_ID, USER_PW);
            System.out.println("Connected!");
        } catch(SQLException e){
            System.err.println("Error: Connection\n" + e.getMessage());
            e.printStackTrace();
        }

        try{
            if(con != null)
                con.close();
        } catch(SQLException e){}
    }
}
