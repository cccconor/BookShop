<%-- 
    Document   : m_booksort
    Created on : 2018-9-8, 11:38:16
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import = "java.sql.*,java.util.*"%>
<jsp:useBean id="cate" class="DbConnect.CateCon" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>图书分类管理</title>
        <% response.setContentType("text/html;charset=utf-8");
         request.setCharacterEncoding("utf-8");%>
        <style>
            tr td{ text-align: center;}   
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
        </style>
    </head>
    <body>
        <h2>图书分类信息表</h2>
        <hr>
         <script type="text/javascript">
  	function delc(){
  		document.sort.action="delC";
  		document.sort.submit();
  	};
  	
       </script> 
        
             <div class="function">
                 <form method="post" action="m_booksort.jsp">
            <input type="button" value="添加" class="butt"
              onclick="window.location='addCate.jsp'"/>
            <input type="button" value="删除" class="butt"
                   onclick="if(confirm('是否真的要删除？')){delc()}"/>
            &nbsp;&nbsp;&nbsp;&nbsp; 
             
            <%  String  cc=request.getParameter("sortname");
            if(cc==null) cc="";
            %>
            
            <input type="text" name="sortname" value="<%=cc%>" /> 
            <input type="submit" value="查询">
            </form> 
            
                   
        </div>
            <br>  
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
            String query=request.getParameter("sortname");
             ResultSet rs;
            if(query==null)
            {  rs = cate.test();}
            else{ rs = cate.query(query);}
            rs.last();
            intRowCount = rs.getRow();
            intPageCount = (intRowCount + intPageSize-1)/intPageSize;
            if(intPage>intPageCount) intPage = intPageCount;

 
        %>
        
        
        
        
         
         <form name="sort" method="post">   
        <table width="100%" border="1">
         
            <tr>
                <th width="20%"><input type ="checkbox" onclick="swapCheck()"></th>
                <th width="30%">编号</th>
                <th width="40%">类别名称</th>
                <th width="10%">修改</th>
            </tr>
            <% 
               if(intPageCount>0){
                   rs.absolute((intPage - 1)*intPageSize+1);
                   i=0;
               
               while(i<intPageSize && !rs.isAfterLast()){
            %>  
            <tr>
                <td class="chose" width="20%"><input name="chose" type="checkbox" value ="<%=rs.getInt(1)%>"></td>
                <td width="30%"> <%=rs.getInt(1)%></td>
                <td width="40%"> <%=rs.getString(2)%></td>
                <td width="10%">
                  <a href="modifyC.jsp?id=<%=rs.getInt(1)%>">修改</a>
                    
                </td>
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
                    <option value="m_booksort.jsp?page=<%=j%>"><%=j%></a</option>
                     <%}%>
                </select>
                
                &nbsp;&nbsp;&nbsp;
                <a href="m_booksort.jsp?page=1">第一页</a>
                &nbsp;
                <% 
                if(intPage>1){
                %>
                <a href="m_booksort.jsp?page=<%=intPage-1%>">上一页</a>
                <%}%>
                &nbsp;&nbsp;&nbsp;
                <b>页次：<%=intPage%>/<%=intPageCount%>页&nbsp;&nbsp; <%=intPageSize%>条/页</b>
                &nbsp;&nbsp;&nbsp;
                <%
                if(intPage<intPageCount){
                %>
                <a href="m_booksort.jsp?page=<%=intPage+1%>">下一页</a>
                <%}%>
                &nbsp;
                 <a href="m_booksort.jsp?page=<%=intPageCount%>">最后一页</a>
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
