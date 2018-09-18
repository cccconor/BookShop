<%-- 
    Document   : showbook
    Created on : 2018-9-13, 20:33:49
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="book" class="DbConnect.BookCon"/>
<jsp:useBean id="sort" class="DbConnect.CateCon"/>
<jsp:useBean id="publisher"  class="DbConnect.PublishCon"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>图书展示界面</title>
        <style>
            
        </style>
    </head>
    <body>
        <style>
            body{
        font-family: 宋体;
        font-size: 20px;
    }
    .butt{
                 margin-top:15px;
                background: #15B69A;
                 line-height: 30px;
                 width: 150px;
                 color: #FFFFFF;
                 font-size: 20px;
                 font-family: 楷体;
                border: none;
                border-radius: 5px;
                cursor:pointer;
            }
        </style>
         
        <% 
            
            ResultSet rs = book.showone(request.getParameter("id"));
            rs.next();
        %>
        <form method="post" action="modifyB.jsp">
            
                <center>
                <input class="butt" type="submit" value="修改图书信息"/>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                
                </center>
            <br>
        <table width="50%" align="center" border="1" rules="all">
            <tr>
                <td width="15%" class="yar" align="right">
                    图书名称： 
                </td>
                <td>
                    <%=rs.getString(2)%>
                </td>
                
            </tr>
            <tr>
                <td chass="yar" align="right">
                    图书作者：
                </td>
                <td>
                    <%=rs.getString(3)%>
                </td>
            </tr>
            <tr>
                <td class="yar" align="right">
                    出版社：
                </td>
                <td>
                   <%
                     String s = Integer.toString(rs.getInt(4));
                     ResultSet rp = publisher.showone(s);  
                     rp.next();

                   %>
                    <%=rp.getString(2)%>
                </td>
            </tr>
            <tr>
                <td class="yar" align="right">出版日期： </td>
                <td>
                    <%=rs.getString(5)%>
                </td>
            </tr>
            <tr>
                <td class="yar" align="right" >ISBN号： </td>
                <td>
                    <%=rs.getString(6)%> 
                </td>
            </tr>
            <tr>
                <td class="yar" align="right">
                    字数：
                </td>
                <td>
                     <%=rs.getInt(7)%>
                </td>
            </tr>
            <tr>
                <td class="yar" align="right">
                    图书单价：
                </td>
                <td>
                     <%=rs.getDouble(8)%>
                </td>
            </tr>
            <tr>
                <td class="sar" valign="top" align="right">内容简介：
                </td>
                <td>
                  
                         <%=rs.getString(9)%>
                </td>
            </tr>
            <tr>
                <td class="sar" valign="top" align="right">作者简介：
                </td>
                <td>
                   <%=rs.getString(10)%>
                    
                </td>
            </tr>
            <tr>
                <td class="sar" valign="top" align="right">编辑评论：
                </td>
                <td>
                    <%=rs.getString(11)%>
                </td>
            </tr>
            <tr>
                <td valign="top" align="right">
                    目录：
                </td>
                <td>
         
                         <%=rs.getString(12)%>
              
                </td>
            </tr>
            <tr>
                <td class="yar">点击次数：</td>
                <td>
                    <%=rs.getInt(13)%>
                </td>
            </tr>
        </table>
                
        </form>
    </body>
</html>
