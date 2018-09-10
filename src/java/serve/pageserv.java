/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import DbConnect.DbCon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ZJX
 * @param <t>
 */
public class pageserv<t> {
    private int pageNum;    //当前页页面传过来
    private int pageSize;     //每页显示条数，自己设置    
    private int totalRecord;    //总的条数 查数据库得到
    private int totalPage;          //总页数，计算出
    private int startIndex;         //开始索引从数据库第几行开始
    private int start;          //分页显示的页数在页面上显示
    private int end;
    private List<t> list;
    
    
    public pageserv( int pageNum,int pagesize) throws SQLException
    {
        DbCon db = new DbCon();
        String sql = "select COUNT(*) as count from Books";
        ResultSet r = db.executeQuery(sql);
        if(r.next()) this.totalRecord = r.getInt(1);
        else return;
        //this.totalRecord=1096;
        
        this.pageNum=pageNum;
        this.pageSize = pagesize;
        if(totalRecord%pagesize==0)this.totalPage = totalRecord/pagesize;
        else this.totalPage = totalRecord/pagesize+1;
         
        this.startIndex = (pageNum-1)*pagesize;
        this.start = 1;
        this.end = 5;
        if(totalPage<=5) this.end = this.totalPage;
        else {
            this.start = pageNum-2;
            this.end = pageNum+2;
            if(start<=0){
                this.start = 1;
                this.end = 5;
            }
            if(end>this.totalPage){
                this.end = totalPage;
                this.start = end-5;
            }
        }
    }
    
    public int getPageNum()
    {
        return pageNum;
    }
    public void setPageNum(int p)
    {
        this.pageNum = p;
    }
    public int getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(int s)
    {
        this.pageSize = s;
    }
    public int getstart()
    {
        return start;
    }
    public int getend()
    {
        return end;
    }
    public int gettotalpage()
    {
        return totalPage;
    }
    public int gettotalrecord()
    {
        return totalRecord;
    }
    
}
