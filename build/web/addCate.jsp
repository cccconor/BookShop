<%-- 
    Document   : addCate.jsp
    Created on : 2018-9-13, 11:19:08
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加图书类别信息</title>
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
        font-size:20px;
    }
            </style>
    </head>
    <body>
        <h2 align="center">添加图书类别信息</h2>
        <form  action="fin_addC"  method="post">
            <center>
              
                    <p>图书类别名称：
                    <input type="text" name="cname" />
                    </p>         
              
               
                    <input  class="butt" type="submit" value="确认" />  
                    <input  class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_booksort.jsp';">
                    
            </center>      
                
            
            
        </form>
    </body>
</html>
