/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;
import java.sql.*;
import DbConnect.BackDbCon;
import java.text.ParseException;
/**
 *
 * @author zjx00
 */
public class UserInfoBean {
    private int id;
    private String username;
    private String userpass;
    private Date regtime;
    private String email;
    public UserInfoBean(){
       // this.id=id;
        this.username = null;
        this.userpass=null;
        this.regtime=null;
        this.email=null;
        
    }
  
public void setId(int s)
    {
        this.id = s;
    }
    public void setEmail(String s)
    {
        this.email=s;
    }
    public void setName(String s)
    {
        this.username=s;
    }
    public void setPass(String s)
    {
        this.userpass=s;
    }
    public void setReg(Date s)
    {
        this.regtime=s;
    }
    
    public int getId()
    {
        return this.id;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getName()
    {
        return this.username;
    }
    public String getPass()
    {
        return this.userpass;
    }
    public Date getReg()
    {
        return this.regtime;
    }
    public int addU(UserInfoBean u)throws SQLException, ParseException{
        BackDbCon point=new BackDbCon();
        int r=point.addU(u);
        if(r==1) return 1;
        else return -1;
    }
    public int deleteU(UserInfoBean u) throws SQLException{
        BackDbCon point = new BackDbCon();
        int r = point.deleteU(u);
        if(r==1) return 1;
        else return -1;
    }
    public int modifyU(UserInfoBean u) throws SQLException{
        BackDbCon point = new BackDbCon();
        int r = point.modify(u);
        if(r==1) return 1;
        else return -1;
    }
    
}