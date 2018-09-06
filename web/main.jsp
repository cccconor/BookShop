<%@ page contentType="text/html;charset=UTF-8" language="java" import="DbConnect.DbCon,java.sql.ResultSet" %>
<jsp:useBean id="main" class="DbConnect.DbCon" scope="page"/>
<html>
<head>
   <title>bookshop</title>
   </head>
   <body>
       <%
           String user = (String)session.getAttribute("user");
           String uid = (String)session.getAttribute("uid");
           %>
           <p>当前登陆用户为<%=user%>该用户的昵称为<%=uid%></p>
       <table cellspacing="10">
            
            <%
                //String sql="select a.sid,a.name,a.sex,c.cid,c.name,b.score from student a left join grade b on a.sid=b.sid left join course c on b.cid=c.cid;";
                ResultSet re =main.test();
                String s;
                while(re.next()){
                    //out.print("<td>"+re.getString(1)+re.getString(2)+re.getString(3)+re.getString(5)+re.getString(6)+re.getString(7)+"</td>");
             //   out.print("<tr><td>");
                 s=re.getString(1);
                 out.print("<tr><td><input type='radio' name='up' value="+s+"></td>");
                 out.print("<td>"+re.getString(1)+"</td>");
                 out.print("<td>"+re.getString(2)+"</td>");
                 out.print("<td>"+re.getString(3)+"</td>");
                 out.print("<td>"+re.getString(4)+"</td>");
                 out.print("<td>"+re.getString(5)+"</td>");
                 out.print("<td>"+re.getString(6)+"</td></tr>");
                }
                %>
        
        </table>
                <p>这里是主页。。。<a href="repsd.jsp">前往用户信息详情页</a></p>
   </body>
</html>