package com.jdbc.practice;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 91778
 */
public class ConnectionProvider_DAY_20 {
    private static Connection con;
    
    public static Connection getConnection(){
        
        try {
            if(con==null){
                String url="jdbc:mysql://localhost:3306/sai";  // Fix typo in the URL
                String user="root";
                String password="Sai@042003";
                Class.forName("com.mysql.cj.jdbc.Driver");  // Fix typo in the class name
                con=DriverManager.getConnection(url, user, password);  // Add semicolon at the end
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
