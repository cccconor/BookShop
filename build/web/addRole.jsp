<%-- 
    Document   : addRole.jsp
    Created on : 2018-9-12, 21:45:10
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>角色添加</title>
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
    <body>
     <h2 align="center">添加角色信息</h2>
        <form  action="fin_addR"  method="post">
           
                <table align="center" >
                    <tr>
                        <td>角色名称：</td>
                        <td><input size="20" name="rname"/></td>                  
                    </tr> 
                    <tr>
                        <td valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
                        <td> <textarea rows="8" cols="18" name="rremark">角色描述</textarea></td>
                    </tr>
                    <tr>
                        <td>
                            角色类型：
                        </td>
                        <td>
                            <select name="rtype">
                                <option value="特殊角色">特殊角色</option>
                                <option value="普通角色">普通角色</option>
                            </select>
                            
                        </td>
                   
                    </tr>
                    
                    <tr>
                        <td align="right"> <input class="butt" type="submit" value="确认" />  </td>
                        <td align="center"><input class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_role.jsp';"></td>
                    </tr>
                    
                </table>
        </form>
    </body>
</html>
     
     
     
               
                    
           
    </body>
</html>
