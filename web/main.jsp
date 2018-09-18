<%-- 
    Document   : main
    Created on : 2018-9-10, 20:03:40
    Author     : ZJX
--%>

<%@page import="serve.cart"%>
<%@page import="serve.user"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="serve.book"%>
<%@page import="serve.pageserv"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<title>主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/startstop-slider.js"></script>
<style type="text/css">
		.mytable{
/*                                                          width: 800px;*/
                                                         background-color:#E6E6F2;
/*                                                         border-collapse:collapse;
			table-layout: fixed;只有定义表格的算法为fixed,th才有效果
			border-collapse: collapse;边框合并模式*/
		}
		.tablea{
/*                                                        border-bottom:1px solid #000;*/
/*                                                          width:50%;
			overflow:hidden;超出的文字隐藏
                                                         white-space:nowrap;文字不换行
			word-break:keep-all;文字不换行
			text-overflow:ellipsis;文字超出后,显示省略号*/
			
			
		}
                                        .pink{
                                            background-color:#FF79BC;
                                        }
                                        .red{
                                            background-color:	#46A3FF;
                                        }
                                        .blue{
                                            background-color:	#ff7575;
                                        }
                                        .green{
                                            background-color:	#A6FFA6;
                                        }
	</style>
</head>
<body onload="fun()">
    <%
           String user = (String)session.getAttribute("user");
           String uid = (String)session.getAttribute("uid");
           String apage =  request.getParameter("curpage");
           int items = 0;
           int total = 0;
           if(user!=null)
           {
               user u = new user();
                cart c = new cart();
                u = u.getallinfo(user);
                 items=c.getcon(u.getid());
                 total = c.gettotal(u.getid());
           }
           
           int curpage = 0;
           if(apage==null)
           {
                curpage = 1;
           }else  curpage = Integer.valueOf(apage).intValue();
           pageserv pages = new pageserv(curpage,30);
           
           
           %>
    
           <script>
               function fun()
               {
                   var usid = <%=user%>;
//                   alert(usid);
                   var str1 = "未登录，请<a href='login.html'>登陆</a>";
                  
                   if(usid==null||usid==NaN){
                       
                       document.getElementById("yonghu").innerHTML=str1;
                   }
               }
           </script>
    
  <div class="wrap">
	<div class="header">
		<div class="headertop_desc">
                    <div class="call" id="top">
                            <p id="yonghu">当前登陆用户为&nbsp;&nbsp;&nbsp;<a href="#" id="ueid"><%=user%></a>&nbsp;&nbsp;&nbsp;该用户的昵称为&nbsp;&nbsp;&nbsp;<a href="#"><%=uid%></a></p>
			</div>
			<div class="account_desc">
				<ul>
                                                                                                <li><a href="main.jsp">主页</a></li>
					<li><a href="login.html">注册</a></li>
					<li><a href="login.html">登陆</a></li>
					<li><a href="cart.jsp">购物车</a></li>
					<li><a href="repsd.jsp">用户信息</a></li>
                                                                                                <li><a href="logout">注销登陆</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header_top">
			<div class="logo">
                            <a href="main.jsp"><img src="images/logo.png" alt=""  /></a>
			</div>
			  <div class="cart">
                              <p>Welcome to our Online Store! <span>Cart:</span><div id="dd" class="wrapper-dropdown-2"> <%=items%> item(s) - <%=total%>元
			  	   	<ul class="dropdown">
                                            <li><a href="cart.jsp">查看详情</a></li>
					</ul></div></p>
			  </div>
			  <script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-2').removeClass('active');
				});

			});

		</script>
	 <div class="clear"></div>
  </div>
	<div class="header_bottom">
	     	<div class="menu">
                                                             
	     		<ul>
			    	<li class="active"><a href="main.jsp">主页</a></li>
			    	<li><a href="cart.jsp">购物车</a></li>
			    	<li><a href="repsd.jsp">用户信息</a></li>
			    	<li><a href="news.html">News</a></li>
			    	<li><a href="contact.html">Contact</a></li>
			    	<div class="clear"></div>
     			</ul>
	     	</div>
	     	<div class="search_box">
                                                          <form action="search.jsp" method="get">
                                                                            <input type="radio" name="what" value="ISBN">搜 ISBN
                                                                            <input type="radio" name="what" value="name">搜书名
	     			<input type="text" name="key" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
                                                                             <input type="submit" value="">
	     		</form>
	     	</div>
	     	<div class="clear"></div>
	     </div>	     
	<div class="header_slide">
			
					
		   <div class="clear"></div>
		</div>
   </div>
   
 <div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>所有的书</h3>
    		</div>
    		<div class="see">
                                                    <p><a href="#">所有</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
	      <div class="section group">
                                                <table class="mytable">
            <tr>
                <td>详情</td>
                <td>书名</td>
                <td>作者</td>
                <td>出版社</td>
                <td>出版时间</td>
                <td>ISBN</td>
                <td>字数</td>
                <td>价格</td>
                <td>简介</td>
                
                
                
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
                 out.print("<tr class='tablea'><td><a href='bookdetails.jsp?id="+s+"'>查看详情</a></td>");
                 //out.print("<td>"+re.getString(1)+"</td>");
                 out.print("<td>"+re.getString(2)+"</td>");
                 out.print("<td>"+re.getString(3)+"</td>");
                 out.print("<td>"+b.getpublish(re.getInt(4))+"</td>");
                 out.print("<td class='pink'>"+re.getString(5)+"</td>");
                 out.print("<td class='red'>"+re.getString(6)+"</td>");
                 out.print("<td class='blue'>"+re.getString(7)+"</td>");
                 out.print("<td class = 'green'>"+re.getString(8)+"</td>");
                 out.print("<td>"+re.getString(9)+"</td>");
                 out.print("</tr>");
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
                  
                  
                  
                  
                  
                  
				
				
				
				
			</div>
			<div class="content_bottom">
    		<div class="heading">
    		<h3>Feature Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
			<div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="#"><img src="images/new-pic1.jpg" alt="" /></a>					
					 <h2>Lorem Ipsum is simply </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$849.99</span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="#">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
				
				
				
			</div>
    </div>
 </div>
</div>
   <div class="footer">
   	  <div class="wrap">	
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
						<h4>Information</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Advanced Search</a></li>
						<li><a href="delivery.html">Orders and Returns</a></li>
						<li><a href="contact.html">Contact Us</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Why buy from us</h4>
						<ul>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Customer Service</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="contact.html">Site Map</a></li>
						<li><a href="#">Search Terms</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>My account</h4>
						<ul>
							<li><a href="contact.html">Sign In</a></li>
							<li><a href="index.html">View Cart</a></li>
							<li><a href="#">My Wishlist</a></li>
							<li><a href="#">Track My Order</a></li>
							<li><a href="contact.html">Help</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contact</h4>
						<ul>
							<li><span>+91-123-456789</span></li>
							<li><span>+00-123-000000</span></li>
						</ul>
						<div class="social-icons">
							<h4>Follow Us</h4>
					   		  <ul>
							      <li><a href="#" target="_blank"><img src="images/facebook.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="images/twitter.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="images/skype.png" alt="" /> </a></li>
							      <li><a href="#" target="_blank"> <img src="images/dribbble.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"> <img src="images/linkedin.png" alt="" /></a></li>
							      <div class="clear"></div>
						     </ul>
   	 					</div>
				</div>
			</div>			
        </div>
        <div class="copy_right">
				<p>.。。。。。。。。。。。。。。。。。。</p>
		   </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>

</body>
</html>

