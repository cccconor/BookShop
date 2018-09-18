<%-- 
    Document   : userRole
    Created on : 2018-9-17, 18:35:25
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="role" class="DbConnect.RoleCon" scope="page"/>
<jsp:useBean id="user" class="DbConnect.BackDbCon" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>给用户分配角色</title>
         <% response.setContentType("text/html;charset=utf-8");
        
         request.setCharacterEncoding("utf-8");%>
        <style>
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
    <body>
        <div>
        
        <%   String id =request.getParameter("userid");
            ResultSet rt = user.showone(id);
        rt.next();
        %>
        <h3>为用户&nbsp;<span style="color: #ff7300;"><%=rt.getString(2)%></span>&nbsp;分配角色</h3>
        
        </div>
        <form method="post" action="fin_UR?userid=<%=id%>">
        <%
        ResultSet rs = role.test();
        while(rs.next()){       
        %>
       
        <input name="chose" type="checkbox" value ="<%=rs.getInt(1)%>">
        <%=rs.getString(2)%> 
        <br>
       
        <%}%>
        
        <br>
         <input type="submit" value="确认" class="butt" />  
         <input type="button" value="取消" class="butt" onclick="javascript:window.close();">
        </form>
        
    </body>
</html>
