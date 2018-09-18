<%-- 
    Document   : modifyU
    Created on : 2018-9-14, 11:27:00
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userinfo" class="DbConnect.BackDbCon" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改用户信息</title>
        <style>
            td{height:30px}
        </style>
        <style>
           td{height: 40px;}
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
        <%ResultSet rs = userinfo.showone(request.getParameter("id"));
        rs.next();
        %>
        <h2 align="center">修改用户信息</h2>
        <form action="fin_MU?id=<%=rs.getInt(1)%>" method="post">
        <table align="center">
            <tr>
                <td>用户名:</td>
                <td>
                   <textarea rows="1" cols="20" name="uname"><%=rs.getString(2)%></textarea> 
                </td>  
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                   <textarea rows="1" cols="20" name="upst"><%=rs.getString(3)%></textarea> 
                </td>  
            </tr>
            <tr>
                <td>邮箱:</td>
                <td>
                   <textarea rows="1" cols="20" name="uemail"><%=rs.getString(5)%></textarea> 
                </td>  
            </tr>
            <tr>
                <td>
                    <input class="butt" type="submit" value="确认"/>
                </td>
                <td>
                    &nbsp;&nbsp;<input class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_user.jsp';">
                </td>
            </tr>
        </table>
            </form>
    </body>
</html>
