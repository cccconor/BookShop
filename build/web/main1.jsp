<%@ page contentType="text/html;charset=UTF-8" language="java" import="DbConnect.DbCon,java.sql.ResultSet,serve.book,serve.pageserv" %>
<jsp:useBean id="main" class="DbConnect.DbCon" scope="page"/>
<html>
<head>
   <title>bookshop</title>
   <style type="text/css">
       #123{
           text-decoration:none;
       }
</style>
   </head>
   <body>
       
       <%
           String user = (String)session.getAttribute("user");
           String uid = (String)session.getAttribute("uid");
           String apage =  request.getParameter("curpage");
           int curpage = 0;
           if(apage==null)
           {
                curpage = 1;
           }else  curpage = Integer.valueOf(apage).intValue();
           pageserv pages = new pageserv(curpage,30);
           
           
           %>
           <p>当前登陆用户为<%=user%>该用户的昵称为<%=uid%></p>
<!--       <table cellspacing="10">-->
        <table>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
                <td>6</td>
                <td>7</td>
                <td>8</td>
                <td>9</td>
                <td>10</td>
                <td>11</td>
                <td>12</td>
                <td>13</td>
                
                
            </tr>
            
            <%
                //String sql="select a.sid,a.name,a.sex,c.cid,c.name,b.score from student a left join grade b on a.sid=b.sid left join course c on b.cid=c.cid;";
                //ResultSet re =main.test();
                book b =new book();
                ResultSet re = b.getbooks(curpage, 30);
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
                 out.print("<td>"+re.getString(6)+"</td>");
                 out.print("<td>"+re.getString(7)+"</td>");
                 out.print("<td>"+re.getString(8)+"</td>");
                 out.print("<td>"+re.getString(9)+"</td>");
                 out.print("<td>"+re.getString(1)+"</td>");
                 out.print("<td>"+re.getString(2)+"</td>");
                 out.print("<td>"+re.getString(3)+"</td></tr>");
                }
                %>
        
        </table>
                <p>
                    <a href="main.jsp?curpage=1">首页</a>&nbsp;&nbsp;
                    <%
                        for(int i=pages.getstart();i<=pages.getend();i++)
                        {
                            out.print("<a href='main.jsp?curpage=" +i+"'>第" +i+"页</a>");
                            out.print("&nbsp;&nbsp;");
                        }
                        %>                  
                        <a href="main.jsp?curpage=<%=pages.gettotalpage()%>">末页</a>&nbsp;&nbsp;
                    <a href="" id="123">共<%=pages.gettotalpage()%>页，<%=pages.gettotalrecord()%>条记录</a>
                </p>
                <p>这里是主页。。。<a href="repsd.jsp">前往用户信息详情页</a></p>
   </body>
</html>