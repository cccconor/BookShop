/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import serve.Role;

/**
 *
 * @author zjx00
 */
public class RoleCon {
    private Connection conn;
    private String url;
    private String s1;
    private PreparedStatement pstmt =null;
    private Statement stmt=null;
    private String sql ="select *from Role";
    ResultSet re;
    
    
    public RoleCon(){
        try{
//                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
//                         conn = DriverManager.getConnection(url, "sa", "sms");
                         Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/book_shop3?characterEncoding=utf8";                         
                            conn = DriverManager.getConnection(url, "sa", "Sms7813@");
                         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
                }catch (Exception e){
                    e.printStackTrace();
                }
    }
    public ResultSet test()
        {
            
            try{
            pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;
            }catch (SQLException e){
                    e.printStackTrace();
                }           
            return re;
        }
    public ResultSet showone(String s) throws SQLException{
        String query = "select *from Role where id = "+ s;
        pstmt = conn.prepareStatement(query);
        re = pstmt.executeQuery();
        return re;
    }
    public ResultSet query(String s) throws SQLException{
        String q = "select *from Role where rolename  like '%"+ s+"%'";
        pstmt = conn.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;
           
            return re;
    }
     public int addR(Role r) throws SQLException, ParseException{
         String s="insert into role values(?,?,?,?,?) ";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           // String datestring = df.format(new Date());
            java.util.Date date = df.parse(df.format(new java.util.Date()));
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
         pstmt = conn.prepareStatement(s);
         pstmt.setString(1,r.getName());
         pstmt.setInt(2,0);
         pstmt.setInt(3,r.getType());
         pstmt.setDate(4, sqlDate);
         pstmt.setString(5, r.getRemark());
         int row = pstmt.executeUpdate();
        pstmt.close();
        return row;
     }
     public int deleteR(Role r ) throws SQLException{
         String s = "delete from Role where id = "+ r.getName();
         stmt = conn.createStatement();
         int n=stmt.executeUpdate(s);
         stmt.close();
         return n;
     }
     public int modifyR(Role r) throws SQLException{
         String s = "update Role set rolename = ?,remark = ?,roletype =? where id = ?";
        pstmt = conn.prepareStatement(s);
        pstmt.setString (1,r.getName());
        pstmt.setString(2, r.getRemark());
        pstmt.setInt(3, r.getType());
        pstmt.setInt(4, r.getId());
        int row = pstmt.executeUpdate();
        pstmt.close();
       return row;
     }
    
   
}
