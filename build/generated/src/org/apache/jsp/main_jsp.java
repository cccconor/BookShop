package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import serve.book;
import serve.pageserv;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<head>\n");
      out.write("<title>主页</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("<link href=\"css/style1.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
      out.write("<link href=\"css/slider.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.7.2.min.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"js/move-top.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/easing.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/startstop-slider.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t\t.mytable{\n");
      out.write("/*                                                          width: 800px;*/\n");
      out.write("                                                         background-color:#E6E6F2;\n");
      out.write("/*                                                         border-collapse:collapse;\n");
      out.write("\t\t\ttable-layout: fixed;只有定义表格的算法为fixed,th才有效果\n");
      out.write("\t\t\tborder-collapse: collapse;边框合并模式*/\n");
      out.write("\t\t}\n");
      out.write("\t\t.tablea{\n");
      out.write("/*                                                        border-bottom:1px solid #000;*/\n");
      out.write("/*                                                          width:50%;\n");
      out.write("\t\t\toverflow:hidden;超出的文字隐藏\n");
      out.write("                                                         white-space:nowrap;文字不换行\n");
      out.write("\t\t\tword-break:keep-all;文字不换行\n");
      out.write("\t\t\ttext-overflow:ellipsis;文字超出后,显示省略号*/\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("                                        .pink{\n");
      out.write("                                            background-color:#FF79BC;\n");
      out.write("                                        }\n");
      out.write("                                        .red{\n");
      out.write("                                            background-color:\t#46A3FF;\n");
      out.write("                                        }\n");
      out.write("                                        .blue{\n");
      out.write("                                            background-color:\t#ff7575;\n");
      out.write("                                        }\n");
      out.write("                                        .green{\n");
      out.write("                                            background-color:\t#A6FFA6;\n");
      out.write("                                        }\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

           String user = (String)session.getAttribute("user");
           String uid = (String)session.getAttribute("uid");
           String apage =  request.getParameter("curpage");
           int curpage = 0;
           if(apage==null)
           {
                curpage = 1;
           }else  curpage = Integer.valueOf(apage).intValue();
           pageserv pages = new pageserv(curpage,30);
           
           
           
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("  <div class=\"wrap\">\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"headertop_desc\">\n");
      out.write("\t\t\t<div class=\"call\">\n");
      out.write("                            <p>当前登陆用户为&nbsp;&nbsp;&nbsp;<a href=\"#\">");
      out.print(user);
      out.write("</a>&nbsp;&nbsp;&nbsp;该用户的昵称为&nbsp;&nbsp;&nbsp;<a href=\"#\">");
      out.print(uid);
      out.write("</a></p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"account_desc\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("                                                                                                <li><a href=\"main.jsp\">主页</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"login.jsp\">注册</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"login.jsp\">登陆</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"cart.jsp\">购物车</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"repsd.jsp\">用户信息</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"header_top\">\n");
      out.write("\t\t\t<div class=\"logo\">\n");
      out.write("\t\t\t\t<a href=\"index.html\"><img src=\"images/logo.png\" alt=\"\" /></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t  <div class=\"cart\">\n");
      out.write("\t\t\t  \t   <p>Welcome to our Online Store! <span>Cart:</span><div id=\"dd\" class=\"wrapper-dropdown-2\"> 0 item(s) - $0.00\n");
      out.write("\t\t\t  \t   \t<ul class=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t\t<li>you have no items in your Shopping cart</li>\n");
      out.write("\t\t\t\t\t</ul></div></p>\n");
      out.write("\t\t\t  </div>\n");
      out.write("\t\t\t  <script type=\"text/javascript\">\n");
      out.write("\t\t\tfunction DropDown(el) {\n");
      out.write("\t\t\t\tthis.dd = el;\n");
      out.write("\t\t\t\tthis.initEvents();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tDropDown.prototype = {\n");
      out.write("\t\t\t\tinitEvents : function() {\n");
      out.write("\t\t\t\t\tvar obj = this;\n");
      out.write("\n");
      out.write("\t\t\t\t\tobj.dd.on('click', function(event){\n");
      out.write("\t\t\t\t\t\t$(this).toggleClass('active');\n");
      out.write("\t\t\t\t\t\tevent.stopPropagation();\n");
      out.write("\t\t\t\t\t});\t\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t$(function() {\n");
      out.write("\n");
      out.write("\t\t\t\tvar dd = new DropDown( $('#dd') );\n");
      out.write("\n");
      out.write("\t\t\t\t$(document).click(function() {\n");
      out.write("\t\t\t\t\t// all dropdowns\n");
      out.write("\t\t\t\t\t$('.wrapper-dropdown-2').removeClass('active');\n");
      out.write("\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t</script>\n");
      out.write("\t <div class=\"clear\"></div>\n");
      out.write("  </div>\n");
      out.write("\t<div class=\"header_bottom\">\n");
      out.write("\t     \t<div class=\"menu\">\n");
      out.write("                                                             \n");
      out.write("\t     \t\t<ul>\n");
      out.write("\t\t\t    \t<li class=\"active\"><a href=\"main.jsp\">主页</a></li>\n");
      out.write("\t\t\t    \t<li><a href=\"cart.jsp\">购物车</a></li>\n");
      out.write("\t\t\t    \t<li><a href=\"repsd.jsp\">用户信息</a></li>\n");
      out.write("\t\t\t    \t<li><a href=\"news.html\">News</a></li>\n");
      out.write("\t\t\t    \t<li><a href=\"contact.html\">Contact</a></li>\n");
      out.write("\t\t\t    \t<div class=\"clear\"></div>\n");
      out.write("     \t\t\t</ul>\n");
      out.write("\t     \t</div>\n");
      out.write("\t     \t<div class=\"search_box\">\n");
      out.write("                                                          <form action=\"search.jsp\" method=\"get\">\n");
      out.write("                                                                            <input type=\"radio\" name=\"what\" value=\"ISBN\">搜 ISBN\n");
      out.write("                                                                            <input type=\"radio\" name=\"what\" value=\"name\">搜书名\n");
      out.write("\t     \t\t\t<input type=\"text\" name=\"key\" value=\"Search\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Search';}\">\n");
      out.write("                                                                             <input type=\"submit\" value=\"\">\n");
      out.write("\t     \t\t</form>\n");
      out.write("\t     \t</div>\n");
      out.write("\t     \t<div class=\"clear\"></div>\n");
      out.write("\t     </div>\t     \n");
      out.write("\t<div class=\"header_slide\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t   <div class=\"clear\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write(" <div class=\"main\">\n");
      out.write("    <div class=\"content\">\n");
      out.write("    \t<div class=\"content_top\">\n");
      out.write("    \t\t<div class=\"heading\">\n");
      out.write("    \t\t<h3>所有的书</h3>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t\t<div class=\"see\">\n");
      out.write("                                                    <p><a href=\"#\">所有</a></p>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t\t<div class=\"clear\"></div>\n");
      out.write("    \t</div>\n");
      out.write("\t      <div class=\"section group\">\n");
      out.write("                                                <table class=\"mytable\">\n");
      out.write("            <tr>\n");
      out.write("                <td>详情</td>\n");
      out.write("                <td>书名</td>\n");
      out.write("                <td>作者</td>\n");
      out.write("                <td>出版社</td>\n");
      out.write("                <td>出版时间</td>\n");
      out.write("                <td>ISBN</td>\n");
      out.write("                <td>字数</td>\n");
      out.write("                <td>价格</td>\n");
      out.write("                <td>简介</td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

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
                
      out.write("\n");
      out.write("        \n");
      out.write("        </table>\n");
      out.write("                <p>\n");
      out.write("                    <a href=\"main.jsp?curpage=1\">首页</a>&nbsp;&nbsp;\n");
      out.write("                    ");

                        for(int i=pages.getstart();i<=pages.getend();i++)
                        {
                            out.print("<a href='main.jsp?curpage=" +i+"'>第" +i+"页</a>");
                            out.print("&nbsp;&nbsp;");
                        }
                        
      out.write("                  \n");
      out.write("                        <a href=\"main.jsp?curpage=");
      out.print(pages.gettotalpage());
      out.write("\">末页</a>&nbsp;&nbsp;\n");
      out.write("                    <a href=\"\" id=\"123\">共");
      out.print(pages.gettotalpage());
      out.write('页');
      out.write('，');
      out.print(pages.gettotalrecord());
      out.write("条记录</a>\n");
      out.write("                </p>\n");
      out.write("                <p>这里是主页。。。<a href=\"repsd.jsp\">前往用户信息详情页</a></p>\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"content_bottom\">\n");
      out.write("    \t\t<div class=\"heading\">\n");
      out.write("    \t\t<h3>Feature Products</h3>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t\t<div class=\"see\">\n");
      out.write("    \t\t\t<p><a href=\"#\">See all Products</a></p>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t\t<div class=\"clear\"></div>\n");
      out.write("    \t</div>\n");
      out.write("\t\t\t<div class=\"section group\">\n");
      out.write("\t\t\t\t<div class=\"grid_1_of_4 images_1_of_4\">\n");
      out.write("\t\t\t\t\t <a href=\"preview.html\"><img src=\"images/new-pic1.jpg\" alt=\"\" /></a>\t\t\t\t\t\n");
      out.write("\t\t\t\t\t <h2>Lorem Ipsum is simply </h2>\n");
      out.write("\t\t\t\t\t<div class=\"price-details\">\n");
      out.write("\t\t\t\t       <div class=\"price-number\">\n");
      out.write("\t\t\t\t\t\t\t<p><span class=\"rupees\">$849.99</span></p>\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t       \t\t<div class=\"add-cart\">\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4><a href=\"preview.html\">Add to Cart</a></h4>\n");
      out.write("\t\t\t\t\t\t\t     </div>\n");
      out.write("\t\t\t\t\t\t\t <div class=\"clear\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("    </div>\n");
      out.write(" </div>\n");
      out.write("</div>\n");
      out.write("   <div class=\"footer\">\n");
      out.write("   \t  <div class=\"wrap\">\t\n");
      out.write("\t     <div class=\"section group\">\n");
      out.write("\t\t\t\t<div class=\"col_1_of_4 span_1_of_4\">\n");
      out.write("\t\t\t\t\t\t<h4>Information</h4>\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"about.html\">About Us</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"contact.html\">Customer Service</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Advanced Search</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"delivery.html\">Orders and Returns</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"contact.html\">Contact Us</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col_1_of_4 span_1_of_4\">\n");
      out.write("\t\t\t\t\t<h4>Why buy from us</h4>\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"about.html\">About Us</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"contact.html\">Customer Service</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Privacy Policy</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"contact.html\">Site Map</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Search Terms</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col_1_of_4 span_1_of_4\">\n");
      out.write("\t\t\t\t\t<h4>My account</h4>\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"contact.html\">Sign In</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"index.html\">View Cart</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">My Wishlist</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Track My Order</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"contact.html\">Help</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col_1_of_4 span_1_of_4\">\n");
      out.write("\t\t\t\t\t<h4>Contact</h4>\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li><span>+91-123-456789</span></li>\n");
      out.write("\t\t\t\t\t\t\t<li><span>+00-123-000000</span></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t<div class=\"social-icons\">\n");
      out.write("\t\t\t\t\t\t\t<h4>Follow Us</h4>\n");
      out.write("\t\t\t\t\t   \t\t  <ul>\n");
      out.write("\t\t\t\t\t\t\t      <li><a href=\"#\" target=\"_blank\"><img src=\"images/facebook.png\" alt=\"\" /></a></li>\n");
      out.write("\t\t\t\t\t\t\t      <li><a href=\"#\" target=\"_blank\"><img src=\"images/twitter.png\" alt=\"\" /></a></li>\n");
      out.write("\t\t\t\t\t\t\t      <li><a href=\"#\" target=\"_blank\"><img src=\"images/skype.png\" alt=\"\" /> </a></li>\n");
      out.write("\t\t\t\t\t\t\t      <li><a href=\"#\" target=\"_blank\"> <img src=\"images/dribbble.png\" alt=\"\" /></a></li>\n");
      out.write("\t\t\t\t\t\t\t      <li><a href=\"#\" target=\"_blank\"> <img src=\"images/linkedin.png\" alt=\"\" /></a></li>\n");
      out.write("\t\t\t\t\t\t\t      <div class=\"clear\"></div>\n");
      out.write("\t\t\t\t\t\t     </ul>\n");
      out.write("   \t \t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\t\t\t\n");
      out.write("        </div>\n");
      out.write("        <div class=\"copy_right\">\n");
      out.write("\t\t\t\t<p>.。。。。。。。。。。。。。。。。。。</p>\n");
      out.write("\t\t   </div>\n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\t\t$(document).ready(function() {\t\t\t\n");
      out.write("\t\t\t$().UItoTop({ easingType: 'easeOutQuart' });\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("    <a href=\"#\" id=\"toTop\"><span id=\"toTopHover\"> </span></a>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
