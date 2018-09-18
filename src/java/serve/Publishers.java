/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.sql.*;
import DbConnect.PublishCon;
/**
 *
 * @author zjx00
 */
public class Publishers {
    private int id;
    private String name;
   
    public Publishers(){
        this.id=0;
        this.name=null;
    }
   
    public void setId(int id){
        this.id = id;
    }
   public void setName(String name){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int addPublish(Publishers p)throws SQLException{
        
        PublishCon point=new PublishCon();
        int r = point.addPb(p);
        if(r==1) return 1;
        else return -1;
    }
    public int deleteP(Publishers p)throws SQLException{
        PublishCon point = new PublishCon();
        int r = point.deleteP(p);
        if(r==1) return 1;
        else return -1;
    }
    public int modifyP(Publishers p) throws SQLException{
       PublishCon point = new PublishCon();
        int r = point.modifyP(p);
        if(r==1) return 1;
        else return -1;
    }
}
