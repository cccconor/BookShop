/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import serve.backBook;

/**
 *
 * @author zjx00
 */
public class BookCon {
    private Connection conn;
    private String url;
    private String s1;
    private PreparedStatement pstmt =null;
    private Statement stmt=null;
    private String sql ="select *from Books";
    ResultSet re;
    
    
    public BookCon(){
        try{
//                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
                         Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/book_shop3"; 
                         conn = DriverManager.getConnection(url, "sa", "Sms7813@");
                         stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
                }catch (ClassNotFoundException | SQLException e){
                }
    }
    public ResultSet show() throws SQLException
        {

            pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
           // pstmt.close();//会造成结果集已关闭
            //return re;
                      
            return re;
        }
     public ResultSet query(String s) throws SQLException{
        String q = "select *from Books where title  like '%"+ s+"%'";
        pstmt = conn.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;
           
            return re;
    }
    public ResultSet showone(String s) throws SQLException{
        String query = "select *from Books where id = "+s;
        pstmt = conn.prepareStatement(query);
        re = pstmt.executeQuery();
        return re;
    }
    public int deleteB(backBook b) throws SQLException{
        String s = "delete from Books where id ="+b.getId();
        stmt = conn.createStatement();
        int n= stmt.executeUpdate(s);
       
        return n;
    }
    public int addB(backBook b) throws SQLException, ParseException{
        String s = "insert into Books values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(s);
        pstmt.setString(1, b.getTitle());
        pstmt.setString(2, b.getAuthor());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");      
        Date date = df.parse(b.getPublishdate());
        java.sql.Date publishdate = new java.sql.Date(date.getTime());
        pstmt.setInt(3, b.getPublisherId());
        pstmt.setDate(4,publishdate);
        pstmt.setString(5, b.getIsbn());
        pstmt.setInt(6, b.getWordcounts());
        pstmt.setDouble(7,b.getPrice());
        pstmt.setString(8, b.getContextdes());
        pstmt.setString(9,b.getAuthordes());
        pstmt.setString(10, b.getEditorcomment());
        pstmt.setString(11,b.getToc());
        pstmt.setInt(12,b.getCategoryId());
        pstmt.setInt(13, b.getClicks());
        int row = pstmt.executeUpdate();
       
        return row;
    }
    public int modifyB(backBook b) throws SQLException, ParseException{
        String s = "update Books"
                + " set title=?,"
                + "author=?,"
                + "PublisherId=?,"
                + "PublishDate=?,"
                + "ISBN=?,"
                + "WordsCount=?,"
                + "UnitPrice=?,"
                + "ContentDescription=?,"
                + "AurhorDescription=?,"
                + "EditorComment=?,"
                + "TOC=?,"
                + "CategoryId=?"
               
                + " where id = "+b.getId();
        pstmt = conn.prepareStatement(s);
        pstmt.setString(1, b.getTitle());
        pstmt.setString(2, b.getAuthor());
        pstmt.setInt(3, b.getPublisherId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = df.parse(b.getPublishdate());
        java.sql.Date publishdate = new java.sql.Date(date.getTime());
        pstmt.setDate(4, publishdate);
        pstmt.setString(5, b.getIsbn());
        pstmt.setInt(6, b.getWordcounts());
        pstmt.setDouble(7,b.getPrice());
        pstmt.setString(8, b.getContextdes());
        pstmt.setString(9,b.getAuthordes());
        pstmt.setString(10, b.getEditorcomment());
        pstmt.setString(11,b.getToc());
        pstmt.setInt(12,b.getCategoryId());
       
        int row = pstmt.executeUpdate();        
       
        return row;
    }
}
