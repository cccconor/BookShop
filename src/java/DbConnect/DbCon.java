/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;

import java.sql.*;
import java.util.*;
import serve.user;
import serve.getmd5;
import serve.mailserv;

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
                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3;useUnicode=true;characterEncoding=utf8";
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
        public int executeupdate(String s) throws SQLException
        {
            return stmt.executeUpdate(s);
        }
        
        public int adduser(user u) throws SQLException
        {
            System.out.println(u.getAddr());
            sql = "insert into Users values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getPsd());
            pstmt.setString(3, u.getName());
            pstmt.setString(4, u.getAddr());
            pstmt.setString(5, u.getPhone());
            pstmt.setString(6, u.getEmail());
            pstmt.setInt(7, 2);
            int r = pstmt.executeUpdate();
            if(r==1)
            {
                getmd5 g  = new getmd5();
                java.util.Date d;
               d = new java.util.Date();
                String md = g.getMd5(u.getName()+d);
                String url = "localhost:8080/BookShop/activationck?user=" + u.getName()+"&actcode="+md;
                String s = "亲爱的"+u.getName()+"你好，你的激活码是   " + md + "    或者你可以点击下面的链接进行激活："+"<a href = '"+url+"'>点此前往激活页面</a>";
                s= s +"如果没有反应请复制下面的链接到地址栏中访问激活页面：      "+url;
                sql = "insert into CheckEmail values((select Id from Users where Name = '" + u.getName() + "'),'false','" + md +"')";
                if(stmt.executeUpdate(sql)!=0)
                {
                    mailserv m = new mailserv();
                    m.setto(u.getEmail());
                    m.setcontent(s);
                    m.send();
                    return 1;
                }else return -1;
                    
            }
            else return -1;
           
            
           // return r;
        }
        
        public int upuserinfo(user u) throws SQLException
        {
             sql = "update Users set LoginId=?,Address=?,Phone=?,Mail=? where Name =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getloginid());
            pstmt.setString(2, u.getAddr());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getName());
            return pstmt.executeUpdate();
        }
    
}
