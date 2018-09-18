<%-- 
    Document   : m_user
    Created on : 2018-9-8, 11:37:55
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import = "java.sql.*,DbConnect.BackDbCon"%>
<jsp:useBean id="user" class="DbConnect.BackDbCon" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <% response.setContentType("text/html;charset=utf-8");
         request.setCharacterEncoding("utf-8");%>
        <title>后台用户管理</title>
        <style>
            body{
                font-family: 宋体;
            }
            .function .butt{
                 margin-top:15px;
                background: #08c;
                 line-height: 30px;
                 width: 50px;
                 color: #FFFFFF;
                 font-size: 16px;
                 font-family: 楷体;
                border: none;
                border-radius: 5px;
                cursor:pointer;
            }
            tr td{ text-align: center;}
            .ad{
                margin-top:15px;
                background: #08c;
                 line-height: 30px;
                 width: 150px;
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
        <h2 >后台用户信息表</h2>
    <hr>
  <script type="text/javascript">
  	function delu(){
  		document.userinfo.action="delU";
  		document.userinfo.submit();
                };
         function uR(){
             document.userinfo.action="mUR";
  		document.userinfo.submit();
         }
  	
       </script> 
       
       
       <div class="function">
           <form method="post" action="m_user.jsp">
               <input type="button" value="添加" class="butt"
              onclick="window.location='addUserinfo.jsp'"/>
            <input type="button" value="删除" class="butt"
                   onclick="if(confirm('是否真的要删除？')){delu()}"/>
            &nbsp;&nbsp;&nbsp;&nbsp; 
             <%  String  cc=request.getParameter("username");
            if(cc==null) cc="";
            %>
            <input type="text" name="username" value="<%=cc%>"> 
            <input type="submit" value="查询" >
            <input type="button" value="为用户添加角色" class="ad"
                   onclick="uR()">
           </form>    
        </div>
        <%
            int intPageSize;//一页显示的记录数
            int intRowCount;//记录总数
            int intPageCount;//总页数
            int intPage;//待显示页码
            
            int i;
            int j;
            
            intPageSize = 10;
            String strPage;
            strPage=request.getParameter("page");
            if(strPage==null){
                intPage=1;
            }
            else{
                intPage = Integer.parseInt(strPage);
                if(intPage<1) intPage=1;
            }
            String query=request.getParameter("username");
            ResultSet rs;
            if(query==null)
            {  rs = user.test();}
            else{ rs = user.query(query);}
            rs.last();
            intRowCount = rs.getRow();
            intPageCount = (intRowCount + intPageSize-1)/intPageSize;
            if(intPage>intPageCount) intPage = intPageCount;

 
        %>
         
    
        
        <form name="userinfo" method="post">
    
           
            <br>   
            <table  border="1"  width="100%">
            
            
            <tr>
                <th width="10%"><input type ="checkbox" onclick="swapCheck()"></th>
                <th width="15%">编号</th>
                <th width="15%">用户名</th>
                <th width="15%">密码</th>
                <th width="15%">注册时间</th>
                <th width="20%">邮箱</th>
                <th>修改</th>
            </tr>
        <% 
               if(intPageCount>0){
                   rs.absolute((intPage - 1)*intPageSize+1);
                   i=0;
               
               while(i<intPageSize && !rs.isAfterLast()){
            %>  
         <tr>
             <td><input name="chose" type="checkbox" value ="<%=rs.getInt(1)%>" </td>
             <td><%=rs.getInt(1)%></td>
             <td><%=rs.getString(2)%></td> 
             <td><%=rs.getString(3)%></td> 
             <td><%=rs.getDate(4)%></td> 
             <td><%=rs.getString(5)%></td> 
             <td><a href="modifyU.jsp?id=<%=rs.getInt(1)%>">修改</a></td>
             
         </tr>
         <%    
                    rs.next();
                    i++;

                }
                }
                %>
            
        </table>
        <br>
                <div id="page">
                <select onchange="window.location(this.value)">
                    <option><%=intPage%></option>
                    <%
                    for(j=1;j<intPageCount+1;j++){
                    %>
                    <option value="m_user.jsp?page=<%=j%>"><%=j%></a</option>
                     <%}%>
                </select>
                
                &nbsp;&nbsp;&nbsp;
                <a href="m_user.jsp?page=1">第一页</a>
                &nbsp;
                <% 
                if(intPage>1){
                %>
                <a href="m_user.jsp?page=<%=intPage-1%>">上一页</a>
                <%}%>
                &nbsp;&nbsp;&nbsp;
                <b>页次：<%=intPage%>/<%=intPageCount%>页&nbsp;&nbsp; <%=intPageSize%>条/页</b>
                &nbsp;&nbsp;&nbsp;
                <%
                if(intPage<intPageCount){
                %>
                <a href="m_user.jsp?page=<%=intPage+1%>">下一页</a>
                <%}%>
                &nbsp;
                 <a href="m_user.jsp?page=<%=intPageCount%>">最后一页</a>
                 
                  <br>
                 <br>
                 <b>共<%= intRowCount%>条记录
                    </b>
                </div>
         
         
       
                
        </form>
         
         
         
         
         
         
         
     <script type="text/javascript"
		src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    
         
    <script type="text/javascript">
		//checkbox 全选/取消全选
		var isCheckAll = false;
		function swapCheck() {
			if (isCheckAll) {
				$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				isCheckAll = false;
			} else {
				$("input[type='checkbox']").each(function() {
					this.checked = true;
				});
				isCheckAll = true;
			}
		}
                
         
     
	</script>
       
            
            
    </body>
</html>
