/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import DbConnect.CateCon;
import java.sql.SQLException;

/**
 *
 * @author zjx00
 */
public class Categories {
    private int id;
    private String name;
    
    public Categories(){
    
        this.name=null;
        
    }

    
    public void setId(int s){
        this.id=s;
    }
    public int getId(){
        return id;
    }
   public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int addC(Categories c) throws SQLException{
        CateCon point = new CateCon();
        int r = point.addC(c);
        if(r==1) return 1;
        else return -1;
    }
    public int deleteC(Categories c) throws SQLException{
        CateCon point = new CateCon();
        int r=point.deleteC(c);
        if(r==1) return 1;
        else return -1;
    }
    public int modifyC(Categories c) throws SQLException{
        CateCon point = new CateCon();
        int r = point.modifyC(c);
        if(r==1) return 1;
        else return -1;
    }
    
}
