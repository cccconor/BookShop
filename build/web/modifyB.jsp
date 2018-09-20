<%-- 
    Document   : addBook
    Created on : 2018-9-15, 10:58:46
    Author     : zjx00
--%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<jsp:useBean id="book" class="DbConnect.BookCon"/>
<jsp:useBean id="sort" class="DbConnect.CateCon"/>
<jsp:useBean id="publisher"  class="DbConnect.PublishCon"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>修改图书</title>  
<link href="umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">  
    <script type="text/javascript" src="umeditor/third-party/jquery.min.js"></script>  
    <script type="text/javascript" src="umeditor/third-party/template.min.js"></script>  
    <script type="text/javascript" charset="utf-8" src="umeditor/umeditor.config.js"></script>  
    <script type="text/javascript" charset="utf-8" src="umeditor/umeditor.min.js"></script>  
    <script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>  
    
</head>  
<style>
    body{
        font-family: 宋体;
        font-size: 25px;
    }
    .sar{
        height: 180px;
    }
    .yar{
        height: 40px;
    }
   
     .butt{
                 margin-top:15px;
                background:#15B69A;
                 line-height: 30px;
                 width: 50px;
                 color: #FFFFFF;
                 font-size: 16px;
                 font-family: 楷体;
                border: none;
                border-radius: 5px;
                cursor:pointer;
            }
</style>
<body> 
    <%
    response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
       String bid = request.getParameter("id");
       ResultSet rb=book.showone(bid);
       rb.next();
    %>
    <form method="post" action="fin_MB?id=<%=bid%>">
    <table  width="700px" align="center">
        <caption><b>修改图书信息</b></caption>
        
            <tr>
                <td width="50%" class="yar"  align="right">
                    图书名称： 
                </td>
                <td>
            <textarea rows="2" cols="60" name="btitle" ><%=rb.getString(2)%></textarea>
                </td>
                
            </tr>
            <tr>
                <td class="yar" align="right">
                    图书作者：
                </td>
                <td>
            <textarea rows="2" cols="60" name="bauthor" ><%=rb.getString(3)%></textarea>
                </td>
            </tr>
            <tr>
                <td class="yar"  align="right">
                   出版社：
                </td>
                <td>
                   
                   <select name="book_publish">
                       <% 
                         String sqp = rb.getString(4);
                         ResultSet rpone = publisher.showone(sqp);
                         rpone.next();
                         %> 
         
                        
                       <option value="<%=rpone.getInt(1)%>">  
                           <%=rpone.getString(2)%>
                           
                       </option> 
                       
                        <% ResultSet rp = publisher.show();
                            while(rp.next()){
                        %>
                        <option value="<%=rp.getInt(1)%>"><%=rp.getString(2)%></option>
                        <%}%>
                       
                   </select>
                        
                </td>
            </tr>
             <tr>
                <td class="yar" align="right">
                    出版日期：
                </td>
                <td>
            <textarea rows="1" cols="30" name="bpdate" ><%=rb.getString(5)%></textarea>
                </td>
            </tr>
           
            <tr>
                <td class="yar"  align="right">ISBN号： </td>
                <td>
             <textarea rows="1" cols="30" name="bisbn" ><%=rb.getString(6)%></textarea>
                </td>
            </tr>
            <tr>
                <td class="yar"  align="right">
                    字数：
                </td>
                <td>
                <textarea rows="1" cols="30" name="bwcount" ><%=rb.getString(7)%></textarea>
    </td>
            </tr>
            <tr>
                <td class="yar"  align="right">
                    图书单价：
                </td>
                <td>
                 <textarea rows="1" cols="30" name="bprice" ><%=rb.getString(8)%></textarea>
                </td>
            </tr>
            <tr>
                <td   class="sar" valign="top" align="right">内容简介：
                </td>
                <td>
                    <textarea  name="con_des" rows="10" cols="50" ><%=rb.getString(9)%></textarea>
                </td>
            </tr>
            <tr>
                <td class="sar" valign="top" align="right">作者简介：
                </td>
                <td>
                   <textarea  name="au_des" rows="10" cols="50"><%=rb.getString(10)%></textarea>
                </td>
            </tr>
            <tr>
                <td class="sar" valign="top" align="right">评论：
                </td>
                <td>
                   <textarea  name="comment" rows="10" cols="50"><%=rb.getString(11)%></textarea>
                </td>
            </tr>
            <tr>
                <td  valign="top" align="right">
                    目录：
                </td>
                <td>
            <textarea id="editor" name="toc" type="text/plain" style="width: 500px ; height: 500px"><%=rb.getString(12)%></textarea>
                </td>
            </tr>
             <tr>
                <td class="yar"  align="right">
                    图书类别：
                </td>
                <td>
                   
                   <select name="book_sort">
                       <%
                          String sqr = rb.getString(13);
                          ResultSet rrone = sort.showone(sqr);
                          rrone.next();
                           %>
                       <option value="<%=rrone.getInt(1)%>">
                           
                           
                           <%=rrone.getString(2)%></option>
                        <% ResultSet rr = sort.test();
                            while(rr.next()){
                        %>
                        <option value="<%=rr.getInt(1)%>"><%=rr.getString(2)%></option>
                        <%}%>
                       
                   </select>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <input  class="butt" type="submit" value="确认" >
                </td>
                <td align="left">
                    &nbsp;&nbsp;
                    <input  class="butt" type="button" value="取消" onclick="javascript:window.close()">
                </td>
            </tr>
            
        </table> 
        </form>
    <br>
    


<script type="text/javascript">  
     UM.getEditor('editor');  
</script>  
</body>  
</html></code> 

