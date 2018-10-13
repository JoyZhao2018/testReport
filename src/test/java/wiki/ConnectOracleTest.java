package wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectOracleTest {
	String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";    
    String theUser = "kiwi";    
    String thePw = "kiwi";    
    Connection c = null;    
    Statement conn;    
    ResultSet rs = null;  
    
    public ConnectOracleTest() {    
        try {    
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();    
            c = DriverManager.getConnection(dbUrl, theUser, thePw);    
            conn = c.createStatement();    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
     } 
    public boolean executeUpdate(String sql) {    
        try {    
            conn.executeUpdate(sql);    
            return true;    
        } catch (SQLException e) {    
            e.printStackTrace();    
            return false;    
        }    
     }    
      
     public ResultSet executeQuery(String sql) {    
        rs = null;    
        try {    
            rs = conn.executeQuery(sql);    
        } catch (SQLException e) {    
            e.printStackTrace();    
        }    
        return rs;    
     }    
      
     public void close() {    
        try {    
            conn.close();    
            c.close();    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
     }    
      
     public static void main(String[] args) {    
        ResultSet rs;    
        ConnectOracleTest conn = new ConnectOracleTest();    
        rs = conn.executeQuery("select aaa002,aaa003 from aa01 where rownum<5");    
        try {    
            while (rs.next()) {    
               System.out.println(rs.getString("aaa002")+"--"+rs.getString("aaa003"));    
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
     }  
}
