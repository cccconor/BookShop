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
                         stmt=conn.createStatement(); 
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
        public boolean loginck(String user,String psd) throws SQLException
        {
            sql = "select * from Users where Name = '" +user +"'";

            try{
                // pstmt = conn.prepareStatement(sql);
                // re = pstmt.executeQuery(sql);
                re = stmt.executeQuery(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(re.next()&&psd.equals(re.getString("LoginPwd")))
                return true;
                else return false;
            
           
            
        }
        
        public ResultSet executeQuery(String sql)
        {
            System.out.println("查询语句："+sql);
            ResultSet rs1 =null;
            try{
            rs1=stmt.executeQuery(sql);       
        }catch (Exception e){
            e.printStackTrace();
        }

         return rs1;   
        } 
        
    
}
