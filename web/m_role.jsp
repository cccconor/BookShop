<%-- 
    Document   : m_role
    Created on : 2018-9-10, 10:16:20
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import = "java.sql.*"%>
<jsp:useBean id="role" class="DbConnect.RoleCon" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>角色管理</title>
        <% response.setContentType("text/html;charset=utf-8");
         request.setCharacterEncoding("utf-8");%>
        <style>
            body{font-family: 宋体;}
            tr td{ text-align: center;}
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

        </style>
    </head>
    <body>
         <h2>角色信息表</h2>
        <hr>
        <script type="text/javascript">
  	function delr(){
  		document.role.action="delR";
  		document.role.submit();
  	};
  	
       </script> 
        <form method="post" action="m_role.jsp">
       <div class="function" float="left">
           
            <input type="button" value="添加" class="butt"
              onclick="window.location='addRole.jsp'"/>
            <input type="button" value="删除" class="butt"
                   onclick="if(confirm('是否真的要删除？')){delr()}"/>
            <%  String  cc=request.getParameter("roname");
            if(cc==null) cc="";
            %>
            
            &nbsp;&nbsp;&nbsp;&nbsp; 
            <input type="text" name="roname" value="<%=cc%>" > 
            <input type="submit" value="查询">
            </div>
       
       
            
           </form>       
        
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
       
            String query=request.getParameter("roname");
            ResultSet rs;
            if(query==null)
            {  rs = role.test();}
            else{ rs = role.query(query);}
            rs.last();
            intRowCount = rs.getRow();
            intPageCount = (intRowCount + intPageSize-1)/intPageSize;
            if(intPage>intPageCount) intPage = intPageCount;

            //out.println(query);
        %>
        
        
        
        
       
        <form name="role" method="post">
            
       
         
            <br>
        <table align="center" border="1" width="100%">
            
            <tr>
                <th width="10%"><input type ="checkbox" onclick="swapCheck()"></th>
                <th width="10%">编号</th>
                <th width="15%">角色名称</th>
                <th width="20%">备注</th>
                <th width="15%">角色类型</th>
                <th width="20%">创建时间</th> 
                <th width="10%">
                  修改  
                </th>
                
            
            </tr>
           <% 
               if(intPageCount>0){
                   rs.absolute((intPage - 1)*intPageSize+1);
                   i=0;
               
               while(i<intPageSize && !rs.isAfterLast()){
            %>  
                <tr>
                    <td class="chose"><input name="chose" type="checkbox" value ="<%=rs.getString(1)%>"></td>
                    <td><%=rs.getInt(1)%></td>
                    <td><%=rs.getString(2)%></td> 
                    <td><%=rs.getString(6)%></td> 
                    
                    
                     <td>
                         <%int num=rs.getInt(4);
                            String type=null;
                            switch(num){
                                case 1: type="特殊角色";
                                        break;
                                case 2: type="普通角色";
                                        break;
                            }
                           out.print(type);
                         %>
                         
                     
                     </td> 
                    <td><%=rs.getDate (5)%></td> 
                    <td><a href="modifyR.jsp?id=<%=rs.getInt(1)%>">修改</a></td>
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
                    <option value="m_role.jsp?page=<%=j%>"><%=j%></a</option>
                     <%}%>
                </select>
                
                &nbsp;&nbsp;&nbsp;
                <a href="m_role.jsp?page=1">第一页</a>
                &nbsp;
                <% 
                if(intPage>1){
                %>
                <a href="m_role.jsp?page=<%=intPage-1%>">上一页</a>
                <%}%>
                &nbsp;&nbsp;&nbsp;
                <b>页次：<%=intPage%>/<%=intPageCount%>页&nbsp;&nbsp; <%=intPageSize%>条/页</b>
                &nbsp;&nbsp;&nbsp;
                <%
                if(intPage<intPageCount){
                %>
                <a href="m_role.jsp?page=<%=intPage+1%>">下一页</a>
                <%}%>
                &nbsp;
                 <a href="m_role.jsp?page=<%=intPageCount%>">最后一页</a>
                 
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
