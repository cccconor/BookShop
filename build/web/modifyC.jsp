<%-- 
    Document   : modifyC
    Created on : 2018-9-14, 20:13:48
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sort" class="DbConnect.CateCon"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            td{height:30px}
            
            body{
                font-family: 宋体;
                font-size: 20px;
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
    </head>
        </style>
    </head>
    <body>
        <% ResultSet rs = sort.showone(request.getParameter("id"));
        rs.next();
        %>
        <h2 align="center">修改图书类别信息</h2>
        <form action="fin_MC?id=<%=rs.getInt(1)%>" method="post">
        <table align="center">
            <tr>
                <td>类别名称:</td>
                <td>
                   <textarea rows="1" cols="20" name="cname"><%=rs.getString(2)%></textarea> 
                </td>  
            </tr>
            
            <tr>
                <td align="right">
                    <input class="butt" type="submit" value="确认"/>
                </td>
                <td>
                    &nbsp;&nbsp;<input class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_booksort.jsp';">
                </td>
            </tr>
        </table>
            </form>
    </body>
</html>
