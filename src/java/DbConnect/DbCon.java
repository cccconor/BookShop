/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;

import java.sql.*;

/**
 *
 * @author ZJX
 */
public class DbCon {
     private Connection conn;
	private String url;
        private String s1 = " ";
        private PreparedStatement pstmt = null;
        private Statement stmt=null;
        private String sql = "select * from Users";
        ResultSet re;
        
        
        
        
        public DbCon() //throws SQLException
	{
                try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
		conn = DriverManager.getConnection(url, "sa", "sms");
                }catch (Exception e){
                    e.printStackTrace();
                }
               
                
	}
        public ResultSet test()
        {
            
            try{
            pstmt = conn.prepareStatement(sql);
            re = pstmt.executeQuery();
            //return re;
            }catch (SQLException e){
                    e.printStackTrace();
                }           
            return re;
        }
        
    
}
