/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lokes
 */
public class DataService {
    private static Connection con;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String ConnectionString = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
    private static final String user = "root";
    private static final String pwd = "root";
    
    public DataService(){
    }
    
    public static Connection loadDriver() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex)  {
            System.out.println(ex.getMessage());
        }
        con = DriverManager.getConnection(ConnectionString, user, pwd);
        return con;
    }
    
    
    public static ResultSet getResultSet(String query) throws SQLException {
        Connection con = loadDriver();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        rs = st.executeQuery();
        
        return rs;
    }
    
    public static void runQuery(String query) throws SQLException {
        Connection con = loadDriver();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        st.executeUpdate();
        
    }
}
        
    


    

