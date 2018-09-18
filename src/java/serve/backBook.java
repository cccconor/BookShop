/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import DbConnect.BookCon;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author zjx00
 */
public class backBook {
    private int id;
    private String title;
    private String author;
    private float price;
    
    private String isbn;
    private String publishdate;
    private int wordcounts;
    private String contextdes;
    private String authordes;
    private String editorcomment;
    private String toc;
    private int clicks;
    
    private int CategoryId;
    private int PublisherId;
    
    public backBook(){
        this.CategoryId=0;
        this.PublisherId=0;
        this.author=null;
        this.authordes=null;
        this.clicks=0;
        this.contextdes=null;
        this.editorcomment=null;
        this.isbn =null;
        this.price = 0;
        this.publishdate = null;
        this.title = null;
        this.toc = null;
        this.wordcounts = 0;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public int getWordcounts() {
		return wordcounts;
	}
	public void setWordcounts(int wordcounts) {
		this.wordcounts = wordcounts;
	}
	public String getContextdes() {
		return contextdes;
	}
	public void setContextdes(String contextdes) {
		this.contextdes = contextdes;
	}
	public String getAuthordes() {
		return authordes;
	}
	public void setAuthordes(String authordes) {
		this.authordes = authordes;
	}
	public String getEditorcomment() {
		return editorcomment;
	}
	public void setEditorcomment(String editorcomment) {
		this.editorcomment = editorcomment;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getPublisherId() {
		return PublisherId;
	}
	public void setPublisherId(int publisherId) {
		PublisherId = publisherId;
	}
        public int deleteB(backBook b) throws SQLException{
            BookCon point = new BookCon();
            int r = point.deleteB(b);
            if(r==1) return 1;
            else return -1;
            
        }
        public int addB(backBook b) throws SQLException, ParseException{
            BookCon point = new BookCon();
            int r=point.addB(b);
            if(r==1) return 1;
            else return -1;
        }
        public int modifyB(backBook b) throws SQLException, ParseException{
            BookCon point = new BookCon();
            int r= point.modifyB(b);
            if(r==1) return 1;
            else return -1;
        }
     
}
