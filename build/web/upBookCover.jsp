<%-- 
    Document   : upBookCover
    Created on : 2018-9-18, 23:27:01
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>为图书上传封面</title>
        <style>
            body{
                font-family: 宋体;
                font-size: 20px;
            }
            #upcover{
        width:300px;
        border: 1px solid #dedede;
        border-radius: 10px;
        padding: 30px 50px ;
        background: #fff;
        margin:0px;
        overflow: hidden;
       
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
    
        <div id="upcover">
            
        <h1>封面上传</h1>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
    选择一个图片:
    <input type="file" name="uploadFile" />
    <br>
    <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="上传" class="butt"/>
         

        </form>
        </div>
    </body>
</html>
