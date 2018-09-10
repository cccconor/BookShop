package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DbConnect.DbCon;
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

      out.write('\r');
      out.write('\n');
      DbConnect.DbCon main = null;
      synchronized (_jspx_page_context) {
        main = (DbConnect.DbCon) _jspx_page_context.getAttribute("main", PageContext.PAGE_SCOPE);
        if (main == null){
          main = new DbConnect.DbCon();
          _jspx_page_context.setAttribute("main", main, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("   <title>bookshop</title>\r\n");
      out.write("   </head>\r\n");
      out.write("   <body>\r\n");
      out.write("       \r\n");
      out.write("       ");

           String user = (String)session.getAttribute("user");
           String uid = (String)session.getAttribute("uid");
           String apage =  request.getParameter("curpage");
           int curpage = 0;
           if(apage==null)
           {
                curpage = 1;
           }else  curpage = Integer.valueOf(apage).intValue();
           pageserv pages = new pageserv(curpage,30);
           
           
           
      out.write("\r\n");
      out.write("           <p>当前登陆用户为");
      out.print(user);
      out.write("该用户的昵称为");
      out.print(uid);
      out.write("</p>\r\n");
      out.write("<!--       <table cellspacing=\"10\">-->\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>1</td>\r\n");
      out.write("                <td>2</td>\r\n");
      out.write("                <td>3</td>\r\n");
      out.write("                <td>4</td>\r\n");
      out.write("                <td>5</td>\r\n");
      out.write("                <td>6</td>\r\n");
      out.write("                <td>7</td>\r\n");
      out.write("                <td>8</td>\r\n");
      out.write("                <td>9</td>\r\n");
      out.write("                <td>10</td>\r\n");
      out.write("                <td>11</td>\r\n");
      out.write("                <td>12</td>\r\n");
      out.write("                <td>13</td>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
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
                
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        </table>\r\n");
      out.write("                <p>\r\n");
      out.write("                    <a href=\"main.jsp?curpage=1\">首页</a>\r\n");
      out.write("                    <a href=\"main.jsp?curpage=");
pages.getstart();
      out.write("\">第");
      out.print(pages.getstart());
      out.write("页</a>\r\n");
      out.write("                    <a href=\"main.jsp?curpage=");
pages.getend();
      out.write("\">第");
      out.print(pages.getend());
      out.write("页</a>\r\n");
      out.write("                    <a href=\"main.jsp?curpage=");
      out.print(pages.gettotalpage());
      out.write("\">末页</a>\r\n");
      out.write("                </p>\r\n");
      out.write("                <p>这里是主页。。。<a href=\"repsd.jsp\">前往用户信息详情页</a></p>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>");
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
