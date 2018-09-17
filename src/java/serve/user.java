/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;
import DbConnect.DbCon;
import java.sql.*;

/**
 *
 * @author ZJX
 */
public class user {
    private String name;
    private String email;
    private String psd;
    private String phone;
    private String addr;
    private String loginid;
    private int state;
    private int id;
    
    public user()
    {
        this.email=null;
        this.name=null;
        this.psd=null;
        this.phone=null;
        this.addr=null;
        this.state = 3;
        this.id = 0;
    }
    
    public void setName(String s)
    {
        this.name = s;
    }
    public void setEmail(String s)
    {
        this.email=s;
    }
    public void setPsd(String s)
    {
        this.psd=s;
    }
    public void setPhone(String s)
    {
        this.phone=s;
    }
    public void setaddr(String s)
            
    {
        this.addr=s;
    }
    public void setloginid(String s)
            
    {
        this.loginid=s;
    }
    public void setstate(int i)
    {
        this.state = i;
    }
    public void setid(int i)
    {
        this.id = i;
    }
    
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public String getPsd()
    {
        return this.psd;
    }
    public String getAddr()
    {
        return this.addr;
    }
    public String getloginid()
    {
        return this.loginid;
    }
    public int getstate()
    {
        return this.state;
    }
    public int getid()
    {
        return id;
    }
    
    public int adduser(user u) throws SQLException{
        DbCon db = new DbCon();
        int r = db.adduser(u);
        if(r==1) return 1;
        else return -1;
        
    }
    public user getallinfo(String s) throws SQLException
    {
        user u = new user();
        u.setName(s);
        DbCon db = new DbCon();
        String sql = "select * from Users where Name ='"+ u.getName()+"'";
        ResultSet r = db.executeQuery(sql);
        if(r.next())
        {
            u.setPsd(r.getString("LoginPwd"));
            u.setPhone(r.getString("Phone"));
            u.setEmail(r.getString("Mail"));
            u.setid(r.getInt("Id"));
            u.setstate(r.getInt("UserStateId"));
            u.setaddr(r.getString("Address"));
            u.setloginid(r.getString("LoginId"));
            
            
        }
        return u;
    }
    
    public user upinfo(user u) throws SQLException
    {
         
         DbCon db = new DbCon();
         if(db.upuserinfo(u)==1) return u;
         else return new user();
         
         
    }
    public int repsd(user u) throws SQLException
    {
        DbCon db = new DbCon();
        String sql = "update Users set LoginPwd='"+ u.getPsd()+"'"+"where Name='"+u.getName()+"'";
        return db.executeupdate(sql);
    }
    
    
    public ResultSet getcart(int id)
    {
        DbCon db = new DbCon();
        String sql = "select * from Cart where UserId="+id;
        return db.executeQuery(sql);
    }
        
    
}
