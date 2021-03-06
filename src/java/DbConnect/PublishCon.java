/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;
import java.sql.*;
import serve.Publishers;
/**
 *
 * @author zjx00
 */
public class PublishCon {
    private Connection conn;
    private String url;
    private String s1;
    private PreparedStatement pstmt =null;
    private Statement stmt=null;
    private String sql ="select *from Publishers";
    ResultSet re;
    
    
    public PublishCon(){
        try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
                         conn = DriverManager.getConnection(url, "sa", "sms");
                         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
                }catch (Exception e){
                    e.printStackTrace();
                }
    }
    public ResultSet show()
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
    public ResultSet query(String s) throws SQLException{
        String q = "select *from Publishers where name  like '%"+ s+"%'";
        pstmt = conn.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;
           
            return re;
    }
    public ResultSet showone(String  s) throws SQLException{
        String query = "select *from Publishers where id = "+ s;
        pstmt = conn.prepareStatement(query);
        re = pstmt.executeQuery();
        return re;
    }
    public int addPb(Publishers pb) throws SQLException{
        String s="insert into Publishers values(?)";
        pstmt = conn.prepareStatement(s);
        //pstmt.setInt(1, pb.getId());
        pstmt.setString(1, pb.getName());
        
        int row = pstmt.executeUpdate();
        pstmt.close();
        return row;
    }
    public int deleteP(Publishers pb)throws SQLException{
        String  s="delete from Publishers where id = "+ pb.getId();
        stmt = conn.createStatement();
        int n=stmt.executeUpdate(s);
        stmt.close();
        return n;
    }
    public int modifyP(Publishers p) throws SQLException{
        String s = "update Publishers set name=? where id = ?";
        pstmt = conn.prepareStatement(s);
        pstmt.setString (1,p.getName());
        
       
        pstmt.setInt(2, p.getId());
        int row = pstmt.executeUpdate();
        pstmt.close();
       return row;
    }
     
}
