/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import DbConnect.DbCon;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ZJX
 */
public class cart {
    private int id;
    private int userid;
    private int bookid;
    private int count;
    DbCon db=new DbCon();
    String sql = "select * from Cart";
    
    
    public void setid(int i)
    {
        this.id=i;
    }
    public void setuserid(int i)
    {
        this.userid=i;
    }
    public void setbookid(int i)
    {
        this.bookid=i;
    }
    public void setcount(int i)
    {
        this.count=i;
    }
    public int getid()
    {
        return id;
    }
    public int getuserid()
    {
        return userid;
    }
    public int getbookid()
    {
        return bookid;
    }
    public int getcount()
    {
        return count;
    }
    
    
    public ResultSet getcart(int uid)
    {
        
        sql ="select * from Cart where UserId="+uid;
        ResultSet re = db.executeQuery(sql);
        return re;
    }
    
    public boolean addtocart(int uid,int bid) throws SQLException
    {
        sql = "select * from Cart where UserId="+uid+" and BookId="+bid;
        ResultSet r=db.executeQuery(sql);
        if(r.next()){
            sql = "update Cart set Count=((select Count from Cart where UserId="+uid+" and ";
            sql = sql + "BookId="+bid+")+1) where UserId="+uid+" and BookId="+bid;
            int i=db.executeupdate(sql);
            if(i!=0)return true;
        }else {
            sql = "insert into Cart (UserId,BookId,Count) values("+uid+","+bid+","+1+")";
            int k=db.executeupdate(sql);
            if(k!=0)return true;
        }
        return false;
    }
    
    public boolean cutone(int uid,int bid) throws SQLException
    {
            sql = "select Count from Cart where UserId="+uid+" and BookId="+bid;
            ResultSet r = db.executeQuery(sql);
            if(r.next())
            {
                int k = r.getInt("Count");
                if(k==1)
                {
                    sql = "delete from Cart where UserId="+uid+" and BookId="+bid;
                    return db.executeupdate(sql)!=0;
                }else{
                     sql = "update Cart set Count=((select Count from Cart where UserId="+uid+" and ";
            sql = sql + "BookId="+bid+")-1) where UserId="+uid+" and BookId="+bid;
            int i=db.executeupdate(sql);
                    return i!=0;
                }
            }
           return false;
    }
    
    public int gettotal(int uid) throws SQLException
    {
        sql = "select * from Cart where UserId="+uid;
        ResultSet re = db.executeQuery(sql);
        int co=0;
        while (re.next())
        {
            book b =new book();
            b = b.getbookbyid(re.getInt("BookId"));
            co+=b.getprice()*re.getInt("Count");
            
        }
        return co;
    }
    
    public boolean cleancart(int uid) throws SQLException
    {
        sql = "delete from Cart where UserId="+uid;
        int i = db.executeupdate(sql);
        return i!=0;
    }
    
    public int getcon(int uid) throws SQLException
    {
        sql = "select count(*) from Cart where UserId="+uid;
        ResultSet i=db.executeQuery(sql);
        i.next();
        return i.getInt(1);
    }
    
    public boolean shuru(int uid,int bid,int shu) throws SQLException
    {
        if(shu==0){
             sql = "delete from Cart where UserId="+uid+" and BookId="+bid;
                    return db.executeupdate(sql)!=0;
        }else{
            sql = "update Cart set Count="+shu+" where UserId="+uid+" and BookId="+bid;
            return db.executeupdate(sql)!=0;
        }

    }
    
    
    
    public boolean dingdan(String oid,int bid,int shu,double price,int uid) throws SQLException
        {
//            dingdan4(oid,uid,0.0);
            sql = "insert into OrderBook (OrderID,BookID,Quantity,UnitPrice) values('"+oid+"',"+bid+","+shu+","+price+")";
            System.out.println(sql);
            return db.executeupdate(sql)!=0;
        }
      
    
      public boolean dingdan2(String od,int uid,String addr) throws SQLException
      {
          sql = "update Orders set addr="+addr+" where OrderId="+od+" and UserId="+uid;
          System.out.println(sql);
          return db.executeupdate(sql)!=0;
      }
    
      public boolean dingdan3(String od,int uid,double totalprice) throws SQLException
      {
//          sql = "insert into Orders (OrderId,OrderDate,UserId,TotalPrice) values('"+od+"',getdate(),"+uid+","+totalprice+")";
          sql = "update Orders set TotalPrice="+totalprice+" where OrderId='"+od+"' and UserId="+uid;
          System.out.println(sql);
          return db.executeupdate(sql)!=0;
      }
      
      public boolean dingdan4(String od,int uid,double totalprice) throws SQLException
      {
          sql = "insert into Orders (OrderId,OrderDate,UserId,TotalPrice,state) values('"+od+"',now(),"+uid+","+totalprice+",0)";
//          sql = "update Orders set TotalPrice="+totalprice+" where OrderId="+od+" and UserId="+uid;
          System.out.println(sql);
          return db.executeupdate(sql)!=0;
      }
      
      public ResultSet getorder(String od)
      {
          sql = "select * from OrderBook where OrderId='"+od+"'";
          return db.executeQuery(sql);
      }
      
      
}
