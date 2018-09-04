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
    
    public user()
    {
        this.email=null;
        this.name=null;
        this.psd=null;
        this.phone=null;
        this.addr=null;
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
    
    public int adduser(user u) throws SQLException{
        DbCon db = new DbCon();
        int r = db.adduser(u);
        if(r==1) return 1;
        else return -1;
        
    }
    
}
