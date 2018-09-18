<%-- 
    Document   : addPublish
    Created on : 2018-9-11, 17:04:00
    Author     : zjx00
--%>

<%@ page contentType="text/html; charset=utf-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>添加出版社信息</title>
        <link rel="stylesheet" href="css/back.css" type="text/css"> 
        <style>
            tr td{ text-align: right;}   
          
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
        <h2 align="center">添加出版社信息</h2>
        <form  action="fin_addPb"  method="post">
            <center>
              
                    <p>出版社名称：
                    <input type="text" name="pname" />
                    </p>         
              
               
                    <input class="butt" type="submit" value="确认" />  
                    <input class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_publish.jsp';">
                    
            </center>      
                
            
            
        </form>
        
        
        
    </body>
</html>
