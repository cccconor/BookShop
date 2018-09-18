<%-- 
    Document   : modifyR
    Created on : 2018-9-14, 18:49:35
    Author     : zjx00
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="role" class="DbConnect.RoleCon"/>
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
        <% ResultSet rs = role.showone(request.getParameter("id"));
        rs.next();
        %>
        <h2 align="center">修改角色信息</h2>
        <form action="fin_MR?id=<%=rs.getInt(1)%>" method="post">
        <table align="center">
            <tr>
                <td>角色名称：</td>
                <td>
                   <textarea rows="1" cols="18" name="rname"><%=rs.getString(2)%></textarea> 
                </td>  
            </tr>
            <tr>
                <td valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
                <td>
                   <textarea rows="8" cols="18" name="rremark"><%=rs.getString(6)%></textarea> 
                </td>  
            </tr>
            <tr>
                <td>
                    角色类型：
                </td>
                
                <%
                int type=rs.getInt(4);
                String t ;
                if(type==1) t="特殊角色";
                else t="普通角色";
                
                %>
                        <td>
                            
                               
                                
                              
                            <select name="rtype">
                                <option value="type"><%=t%>  </option>
                                <option value="1">特殊角色</option>
                                <option value="2">普通角色</option>
                            </select>
                            
                        </td> 
            </tr>
            <tr>
                <td align="center">
                    <input class="butt" type="submit" value="确认"/>
                </td>
                <td>
                    &nbsp;&nbsp;<input  class="butt" type="button" value="取消" onclick="javascript:window.location.href ='m_role.jsp';">
                </td>
            </tr>
        </table>
            </form>
    </body>
</html>
