<%-- 
    Document   : addUserinfo
    Created on : 2018-9-12, 17:30:50
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>添加后台用户信息</title>
        <style>
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
             body{
        font-family: 宋体;
        font-size: 20px;
    }
            </style>
    </head>
    <body>
        <h2 align="center">添加后台用户信息</h2>
        <form  action="fin_addU"  method="post">
            <center>
              
                    <p>用户名：
                    <input type="text" name="uname" />
                    </p>         
                    <p>密&nbsp;&nbsp;码：
                    <input type="text" name="upass" />
                    </p> 
                    
                    
                    <p>邮&nbsp;&nbsp;箱：
                    <input type="text" name="email" />
                    </p> 
               
                     <input  class="butt" type="submit" value="确认" />  
                     <input class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_user.jsp';">
                    
            </center>
    </body>
</html>
