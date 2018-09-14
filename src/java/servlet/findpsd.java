/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serve.getastring;
import serve.mailserv;
import serve.user;

/**
 *
 * @author ZJX
 */
@WebServlet(name = "findpsd", urlPatterns = {"/findpsd"})
public class findpsd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet findpsd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet findpsd at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String email = request.getParameter("email");
            user u = new user();
            //u.setName(user);
            u=u.getallinfo(user);
            if(u.getEmail().equals(email))
            {
                String s = getastring.createRandomString(6);
                u.setPsd(s);
                if(u.repsd(u)!=0)
                {
                    mailserv m = new mailserv();
                m.setto(u.getEmail());
                String c = "亲爱的  "+u.getName()+"你好，你刚刚在图书商城进行了找回密码操作，你的新密码是：   "+u.getPsd()+"   请使用新密码进行登陆操作";
                m.setcontent(c);
                if(m.send())
                {
                    out.println("<script language ='javaScript'>alert('密码重置成功，新密码已发送至邮箱，请使用新密码登陆！');</script>");
                     response.setHeader("refresh", "0;url=login.html");
                }
                else {
                    out.println("<script language ='javaScript'>alert('密码重置失败，请重试！');</script>");
                     response.setHeader("refresh", "0;url=findpsd.html");
                }
                }else {
                    out.println("<script language ='javaScript'>alert('密码重置失败，请重试！');</script>");
                     response.setHeader("refresh", "0;url=findpsd.html");
                }
                //u.repsd(u);
                
            }
            else {
                out.println("<script language ='javaScript'>alert('用户名或邮箱输入错误，请重试！');</script>");
                     response.setHeader("refresh", "0;url=findpsd.html");
            }
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(findpsd.class.getName()).log(Level.SEVERE, null, ex);
        }
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
