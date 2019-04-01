


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;
import java.sql.*;
import java.text.ParseException;
import serve.UserInfoBean;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author zjx00
 */
public class BackDbCon {
    private Connection conn;
    private String url;
    private String s1;
    private PreparedStatement pstmt =null;
    private Statement stmt=null;
    private String sql ="select *from UserInfo";
    ResultSet re;
    
    
    public BackDbCon(){
        try{
//                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                         url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=book_shop3";
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
        String query = "select *from UserInfo where id = "+ s;
        pstmt = conn.prepareStatement(query);
        re = pstmt.executeQuery();
        return re;
    }
    public ResultSet query(String s) throws SQLException{
        String q = "select *from UserInfo where username like '%"+ s+"%'";
        pstmt = conn.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            re = pstmt.executeQuery();
            //return re;  
            return re;
    }
    public ResultSet judge(String s) throws SQLException{
        pstmt = conn.prepareStatement(s);
        re = pstmt.executeQuery();
        return re;
    }
    //为用户添加角色
    public int userinfoRole(int uid,int rid) throws SQLException{
        String sq = "insert into UserInfoRole values(?,?)";
        pstmt =conn.prepareStatement(sq);
        pstmt.setInt(1,uid);
        pstmt.setInt(2, rid);
        int row = pstmt.executeUpdate();
        return row;
    }
    
   //添加用户
    public int addU(UserInfoBean u) throws SQLException, ParseException{
        
            String s="insert into UserInfo values(?,?,?,?)";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           // String datestring = df.format(new Date());
            Date date = df.parse(df.format(new Date()));
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            pstmt =conn.prepareStatement(s);
            //pstmt.setInt(1, u.getId());
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getPass());
            pstmt.setDate(3,sqlDate);
            pstmt.setString(4, u.getEmail());
            int row = pstmt.executeUpdate();
            pstmt.close();
            return row;
    }
   //删除用户
    public int deleteU(UserInfoBean u)throws SQLException{
        String s = "delete from UserInfo where id ="+u.getId();
        stmt = conn.createStatement();
        int n=stmt.executeUpdate(s);
        stmt.close();
        return n;
    }
   //修改用户
    public int modify(UserInfoBean u)throws SQLException{
        String s = "update UserInfo set username = ?,userpass = ?,email =? where id = ?";
        pstmt = conn.prepareStatement(s);
        pstmt.setString (1,u.getName());
        pstmt.setString(2, u.getPass());
        pstmt.setString(3, u.getEmail());
        pstmt.setInt(4, u.getId());
        int row = pstmt.executeUpdate();
        pstmt.close();
       return row;
    }
    
    
   /* public UserInfoBean getU(String name)throws SQLException{
        String s = "select *from UserInfo where username ="+name;
        stmt = conn.createStatement();
        re = stmt.executeQuery(s);
        UserInfoBean u = getUserFromResultSet(re);
        re.close();
        stmt.close();
        return u;
    }*/
  /*  static UserInfoBean getUserFromResultSet(ResultSet rs) throws SQLException{
        Integer id = rs.getInt("id");
        String name= rs.getString("username");
        String pass= rs.getString("userpass");
        Date reg = rs.getDate("regtime");
        String email =rs.getString("email");
        return new UserInfoBean(id, name, pass, reg, email);
 }*/
}
