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
public class book {
    private String title;
    private String author;
    private int publishid;
    private String publishdate;
    private String isbn;
    private int wordscount;
    private double price;
    private String condes;
    private String audes;
    private String edicom;
    private String toc;
    private int categorid;
    private int clicks;
    private int id;
    
    
    
    public book(){
        this.audes = null;
        this.author = null;
        this.categorid = 0;
        this.title = null;
        this.edicom = null;
        this.isbn= null;
        this.publishid = 0;
        this.publishdate = null;
        this.toc = null;
        this.wordscount = 0;
        this.clicks = 0;
        this.price = 0.0;
        this.condes = null;
        this.id = 0;
    }
    
    
    public void settitle(String s)
    {
        this.title = s;
    }
    public void setauthor(String s)
    {
        this.author = s;
    }
    public void setpublishid(int i)
    {
        this.publishid = i;
    }
    public void setpublishdate(String s)
    {
        this.publishdate = s;
    }
    public void setisbn(String s)
    {
        this.isbn = s;
    }
    public void setcondes(String s)
    {
        this.condes = s;
    }
    public void setaudes(String s)
    {
        this.audes = s;
    }
    public void setedicom(String s)
    {
        this.edicom = s;
    }
    public void settoc(String s)
    {
        this.toc = s;
    }
    public void setcategorid(int i)
    {
        this.categorid = i;
    }
    public void setwordscount(int i)
    {
        this.wordscount = i;
    }
    public void setclicks(int i)
    {
        this.clicks = i;
    }
    public void setprice(double i)
    {
        this.price = i;
    }
    public void setid(int i)
    {
        this.id = i;
    }
    
    
    
    
    
    
    public String gettitle()
    {
        return title;
    }
    public String getauthor()
    {
        return author;
    }
    public int getpublishid()
    {
        return publishid; 
    }
    public String getpublishdate()
    {
        return publishdate; 
    }
    public String getisbn()
    {
        return isbn;
    }
    public String getcondes()
    {
        return condes;
    }
    public String getaudes()
    {
        return audes;
    }
    public String getedicom()
    {
        return edicom;
    }
    public String gettoc()
    {
        return toc;
    }
    public int getcategorid()
    {
        return categorid;
    }
    public int getwordscount()
    {
        return wordscount;
    }
    public int getclicks()
    {
        return clicks;
    }
    public double getprice()
    {
        return price;
    }
    public int getid()
    {
        return id;
    }
    
    
    
    public book getbookbyname(String s) throws SQLException
    {
        String sql = "select * from Books where Title ='"+s+"'";
        DbCon db = new DbCon();
        ResultSet r = db.executeQuery(sql);
        book b = new book();
        if(r.next())
        {
            b.settitle(s);
            b.setid(r.getInt("Id"));
            b.setauthor(r.getString("Author"));
            b.setpublishdate((String)r.getString("PublishDate"));
            b.setisbn(r.getString("ISBN"));
            b.setwordscount(r.getInt("WordsCount"));
            b.setprice(r.getDouble("UnitPrice"));
            b.setcondes(r.getString("ContentDescription"));
            b.setaudes(r.getString("AurhorDescription"));
            b.setedicom(r.getString("EditorComment"));
            b.settoc(r.getString("TOC"));
            b.setclicks(r.getInt("Clicks"));
            b.setcategorid(r.getInt("CategoryId"));
            b.setpublishid(r.getInt("PublisherId"));
//            int puid = r.getInt("PublishId");
//            int catid = r.getInt("CategoryId");
//            sql = "select Name from Publishers where Id="+puid;
//            r=db.executeQuery(sql);
//            if(r.next())b.setpublish(r.getString(1));
//            else b.setpublish("出版社");
//            sql = "select Name from Categories where Id="+catid;
//            r = db.executeQuery(sql);
//            if(r.next())b.setcategor(r.getString(1));
//            else b.setcategor("分类");
        }
        return b;
    }
    
    public book getbookbyisbn(String isbn) throws SQLException
    {
        String sql = "select * from Books where ISBN ='"+isbn+"'";
        DbCon db = new DbCon();
        ResultSet r = db.executeQuery(sql);
        book b = new book();
        if(r.next())
        {
            b.setid(r.getInt("Id"));
            b.settitle(r.getString("Title"));
            b.setauthor(r.getString("Author"));
            b.setpublishdate((String)r.getString("PublishDate"));
            //b.setisbn(r.getString("ISBN"));
            b.setwordscount(r.getInt("WordsCount"));
            b.setprice(r.getDouble("UnitPrice"));
            b.setcondes(r.getString("ContentDescription"));
            b.setaudes(r.getString("AurhorDescription"));
            b.setedicom(r.getString("EditorComment"));
            b.settoc(r.getString("TOC"));
            b.setclicks(r.getInt("Clicks"));
            b.setcategorid(r.getInt("CategoryId"));
            b.setpublishid(r.getInt("PublisherId"));
//            int puid = r.getInt("PublishId");
//            int catid = r.getInt("CategoryId");
//            sql = "select Name from Publishers where Id="+puid;
//            r=db.executeQuery(sql);
//            if(r.next())b.setpublish(r.getString(1));
//            else b.setpublish("出版社");
//            sql = "select Name from Categories where Id="+catid;
//            r = db.executeQuery(sql);
//            if(r.next())b.setcategor(r.getString(1));
//            else b.setcategor("分类");
        }
        return b;
    }
    
    
    public book getbookbyid(int i) throws SQLException
    {
        String sql = "select * from Books where Id ="+i;
        DbCon db = new DbCon();
        ResultSet r = db.executeQuery(sql);
        book b = new book();
        if(r.next())
        {
            b.setid(r.getInt("Id"));
            b.settitle(r.getString("Title"));
            b.setauthor(r.getString("Author"));
            b.setpublishdate((String)r.getString("PublishDate"));
            b.setisbn(r.getString("ISBN"));
            b.setwordscount(r.getInt("WordsCount"));
            b.setprice(r.getDouble("UnitPrice"));
            b.setcondes(r.getString("ContentDescription"));
            b.setaudes(r.getString("AurhorDescription"));
            b.setedicom(r.getString("EditorComment"));
            b.settoc(r.getString("TOC"));
            b.setclicks(r.getInt("Clicks"));
            b.setcategorid(r.getInt("CategoryId"));
            b.setpublishid(r.getInt("PublisherId"));
        }
        return b;
    }
    
    public ResultSet getbooks(int i,int num)
    {
        int start = (num-1)*(i-1);
//        String sql = "SELECT TOP "+num+" * " +"FROM Books" +" WHERE Id NOT IN" +"(SELECT TOP "+start+" Id FROM Books ORDER BY Id)";
       String sql = "select * from Books limit "+num*(i-1)+", 30";
        DbCon db = new DbCon();
        ResultSet r = db.executeQuery(sql);
        return r;
    }
    
    public String getpublish(int id) throws SQLException
    {
         String sql = "select Name from Publishers where Id="+id;
         DbCon db = new DbCon();
         ResultSet r=db.executeQuery(sql);
         if(r.next())return r.getString(1);
         else return "出版社";
    }
    public String getcategory(int id) throws SQLException
    {
        String sql = "select Name from Categories  where Id="+id;
         DbCon db = new DbCon();
         ResultSet r=db.executeQuery(sql);
         if(r.next())return r.getString(1);
         else return "分类";
    }
    public ResultSet getcom(int id)
    {
        String sql = "select * from BookComment where BookId ="+id;
        DbCon db = new DbCon();
        ResultSet r = db.executeQuery(sql);
        return r;
    }
    public ResultSet searchbook(String s)
    {
        String sql = "select * from Books where Title like '%"+s+"%'";
        DbCon db = new DbCon();
        return db.executeQuery(sql);
    }
    
    public boolean addcomment(int bid,String text) throws SQLException
    {
        String sql = "insert into BookComment values('"+text+"',getdate(),"+bid+")";
        DbCon db = new DbCon();
        return db.executeupdate(sql)!=0;
    }
    
}
