/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;
import DbConnect.CateCon;
import DbConnect.RoleCon;
import java.sql.*;
import java.text.ParseException;
/**
 *
 * @author zjx00
 */
public class Role {
    private int id;
    private String rolename;
    private int delflag;
    private int roletype;
    private Date subtime;
    private String remark;
    
    public Role(){
        //this.id=id;
        this.rolename=null;
        this.delflag=0;
        this.roletype=0;
        this.subtime=null;
        this.remark=null;
        
    }
     public void setId(int s){
        this.id=s;
    }
     public int getId(){
        return id;
    }
     public void setName(String s){
        this.rolename=s;
        
    }
     public String getName(){
        return rolename;
    }
     public void setFlag(int s){
        this.delflag=s;
    }
     public int getFlag(){
        return delflag;
    }
     public void setType(int s){
        this.roletype=s;
    }
     public int getType(){
        return roletype;
    }
    public void setTime(Date s){
        this.subtime=s;
    }
     public Date getTime(){
        return subtime;
    }
    public void setRemark(String s){
        this.remark=s;
    }
    public String getRemark(){
        return remark;
    }
    public int addR(Role r) throws SQLException, ParseException{
        RoleCon point = new RoleCon();
        int w = point.addR(r);
        if(w==1) return 1;
        else return -1;
        
    }
    public int deleteR(Role r) throws SQLException{
        RoleCon point = new RoleCon();
        int w=point.deleteR(r);
        if(w==1) return 1;
        else return -1;
    }
    public int modifyR(Role r) throws SQLException{
        RoleCon point = new RoleCon();
        int w= point.modifyR(r);
        if(w==1) return 1;
        else return -1;
    }
    public int modifyC(Categories c) throws SQLException{
        CateCon point = new CateCon();
        int w=point.modifyC(c);
        if(w==1)return 1;
        else return -1;
    }
    
}
