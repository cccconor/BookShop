<%-- 
    Document   : BackMain
    Created on : 2018-9-5, 19:26:33
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>后台用户管理系统</title>
        <% response.setContentType("text/html;charset=utf-8");
        
         request.setCharacterEncoding("utf-8");%>
        <link rel="stylesheet" href="css/back.css" type="text/css"> 
        <script type="text/javascript" src="js/back.js"></script>
        
    </head>
    
    <body>
        <div id="container">
        <div id="header">
            欢迎访问图书商城后台管理系统！
            <div class="yonghu">
                <br>
             当前用户： 
            <span style="color: #0000FF;font-size: 32px;">          
            <%= request.getParameter("id")%>
         
            </span>
                &nbsp; &nbsp; &nbsp; &nbsp; 
            </div>
        </div>
        <div id="main">
            <div class="west">
                <ul class="ulleftmenu" >
  
             <a href="m_user.jsp" target="right">
                 <li class="toc">后台用户管理</li>
                    </a> 
                    <a href="m_role.jsp" target="right">
                        <li class="toc">角色管理</li>
                    </a>
                    <a href="m_booksort.jsp" target="right">
                        <li class="toc">图书分类管理</li>
                    </a>
                    <a href="m_publish.jsp" target="right">
                        <li class="toc">出版社管理</li>  
                    </a>   
                    <a href="m_book.jsp" target="right">
                        <li class="toc">图书管理<li>
                    </a>
                
                </ul>
            </div>
            
            <div class="context" >
            <iframe src="m_user.jsp" scrolling="yes"  width="730px" height="579px" name="right" frameborder="0">内容现实</iframe> 	 
            </div>
        </div>
            <div id="footer">
                
                <div class="biaoji">
                    <br>
                    @后台管理系统制作人：赵金鑫 &nbsp;
                </div>
                
            </div>
        </div><!--container end-->
        <script type="text/javascript">
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}
			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="js/canvas-particle.js"></script>
    </body>
</html>
