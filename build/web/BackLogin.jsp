<%-- 
    Document   : back_main
    Created on : 2018-9-5, 11:09:27
    Author     : zjx00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <% response.setContentType("text/html;charset=utf-8");
        
         request.setCharacterEncoding("utf-8");%>
    <style type="text/css">
        ol, ul,li {
	list-style: none;
        margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
}
    body{
        background:#ECECFF;}
    
    #login{
        width:350px;
        border: 1px solid #dedede;
        border-radius: 10px;
        padding: 30px 50px ;
        background: #fff;
        margin:200px auto;
        overflow: hidden;
        font-size: 20px;
        font-family: 楷体;
    }
    .logo{
        width:100%;
	height:44px;
	line-height: 44px;
	font-size: 30px;
	text-align: center;
	border-bottom:1px solid #ddd;
    }
    .item{
        padding: 2px 8px;
	border:1px solid #dedede;
	border-radius: 8px;
	margin-top: 10px;
    }
    .login_input{
        height: 35px;
    border: none;
    line-height: 35px;
    width: 250px;
    font-size: 14px;
    outline: none;
    }
    .login-sub{
        text-align: center;
    }
    .login-sub input{
        margin-top:15px;
    background: #45B549;
    line-height: 35px;
    width: 100px;
    color: #FFFFFF;
    font-size: 16px;
    font-family: 楷体;
    border: none;
    border-radius: 5px;
    cursor:pointer;
    }
    
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>后台用户登录</title>
    </head>
    <body>
        
        <div id="login">
            <div class="logo">后台用户登录</div>
        
        <form action="JudgeLogin" method="post" >
            <li class="item">
                <span>用户名:</span>
                 <input type="text" name="loginid" class="login_input"/>
                
            </li>
            
            <li class="item">
                <span>密&nbsp;&nbsp;码:</span>
                <input type="password" name="password" class="login_input"/>
               
            </li>
            <li class="login-sub">
		<input type="submit" name="Submit" value="登录" />
                <input type="reset" name="Reset" value="重置" />
            </li> 
            
                   
        </form>
        </div>
       
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
