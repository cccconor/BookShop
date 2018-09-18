<%-- 
    Document   : modifyP
    Created on : 2018-9-14, 21:25:27
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="publish" class="DbConnect.PublishCon"/>
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
    </head>
    <body>
        <% ResultSet rs = publish.showone(request.getParameter("id"));
        rs.next();
        %>
        <h2 align="center">修改出版社信息</h2>
        <form action="fin_MP?id=<%=rs.getInt(1)%>" method="post">
        <table align="center">
            <tr>
                <td>出版社名称:</td>
                <td>
                   <textarea rows="1" cols="30"  name="pname"><%=rs.getString(2)%></textarea> 
                </td>  
            </tr>
            
            <tr>
                <td align="right">
                    <input class="butt" type="submit" value="确认"/>
                </td>
                <td>
                    &nbsp;&nbsp;<input  class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_publish.jsp';">
                </td>
            </tr>
        </table>
            </form>
    </body>
</html>
