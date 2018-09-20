/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;
import java.sql.*;
import serve.Categories;
/**
 *
 * @author zjx00
 */
public class CateCon {
    private Connection conn;
    private String url;
    private String s1;
    private PreparedStatement pstmt =null;
    private Statement stmt=null;
    private String sql ="select *from Categories";
    ResultSet re;
    
    
    public CateCon(){
        try{
//                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
//                         conn = DriverManager.getConnection(url, "sa", "sms");
                         Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/book_shop3";                         
                            conn = DriverManager.getConnection(url, "sa", "Sms7813@");
                         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
                }catch (ClassNotFoundException | SQLException e){
                }
    }
    public ResultSet test()
        {
            
            try{
            
            pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
          //  re=stmt.executeQuery(sql);
            //return re;
            }catch (SQLException e){
                    e.printStackTrace();
                }           
            return re;
        }
    public ResultSet query(String s) throws SQLException{
        String q = "select *from Categories where name  like '%"+ s+"%'";
        pstmt = conn.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;
           
            return re;
    }
    public ResultSet showone(String s) throws SQLException{
        String query = "select *from Categories where id = "+ s;
        pstmt = conn.prepareStatement(query);
        re = pstmt.executeQuery();
        return re;
    }
    public int addC(Categories c) throws SQLException{
        String s="insert into Categories values(?)";
        pstmt = conn.prepareStatement(s);
        pstmt.setString(1, c.getName());
        int row = pstmt.executeUpdate();
        pstmt.close();
        return row;
    }
    public int deleteC(Categories c) throws SQLException{
        String s="delete from Categories where id = "+ c.getId();
        stmt = conn.createStatement();
        int n= stmt.executeUpdate(s);
        stmt.close();
        return n;
    }
    public int modifyC(Categories c) throws SQLException{
        String s = "update Categories set name=? where id = ?";
        pstmt = conn.prepareStatement(s);
        pstmt.setString (1,c.getName());
        
       
        pstmt.setInt(2, c.getId());
        int row = pstmt.executeUpdate();
        pstmt.close();
       return row;
    }
}
